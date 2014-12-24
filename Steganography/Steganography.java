import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Steganography {
	public static final int NUM_ARGS = 5;
	public static final int ENCODING = 3;
	public static final int ZERO_BYTE = 00000000;
	
	public static void main(String[] args) {
		String fileName = "";
		String ext = "";
		boolean encode = false;
		boolean decode = false;
		
		BufferedImage img = null;
		try {
			if(args[0].equalsIgnoreCase("-E"))
				encode = true;
			else if(args[0].equalsIgnoreCase("-D"))
				decode = true;
			
			img = ImageIO.read(new File(args[1]));
			String file = args[1];
			String[] fileTokens = file.split("\\.");
			fileName = fileTokens[0];
			ext = fileTokens[1];
			
			if(encode) {
				//also get the input file with the message we want to hide
				String inFile = args[2];
				encode(img, inFile);
			}
			else {
				String outFile = args[2];
				decode(img, outFile);
			}
			
		} catch (IOException e) {

		}

		//write the encoded file to disk.
		try {
			ImageIO.write(img, ext, new File(fileName + "-steg." + ext));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void encode(BufferedImage img, String inFile) {
		int numBits = 0;
		boolean willFit = true;
		// open BufferedReader with file
		ArrayList<Integer> encode = new ArrayList<Integer>();
		byte[] lineBuffer;
		int currentBit, numBytesIn;
		BufferedReader in;
		String currentLine;
		try {
			in = new BufferedReader(new FileReader(inFile));
		} catch (FileNotFoundException e) {
			System.err.println("Error: file not found.");
			return;
		}
		try {
			currentLine = in.readLine();
		} catch (IOException e) {
			System.err.println("Error: unable to read from file.");
			return;
		}
		while (currentLine != null) {
			lineBuffer = (currentLine).getBytes();
			numBytesIn = lineBuffer.length;
			for (int i = 0; i < numBytesIn; i++) {
				for (int j = 7; j >= 0; j--) {
					currentBit = readBit(lineBuffer[i], j);
					encode.add(currentBit);
					numBits++;
				}
			}
//			// add the null padding at the end of the arraylist
//			encode.add(ZERO_BYTE);
			try {
				currentLine = in.readLine();
			} catch (IOException e) {
				System.err.println("Error: unable to read from file.");
				return;
			}
		}
		int height = img.getHeight();
		int width = img.getWidth();

		ArrayList<int[]> rgb = new ArrayList<int[]>();
		// BufferedImage newImage = new BufferedImage(width, width, width);
		// get the amount of pixel in an image by getting the image buffer
		// array, and then looping through and finding each RGB pixel?
		int amountPixel = 0;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int[] arr = new int[NUM_ARGS];
				int pixels = img.getRGB(i, j);
				int alpha = (pixels >> 24) & 0xFF;
				int r = (pixels >> 16) & 0xFF;
				int g = (pixels >> 8) & 0xFF;
				int b = pixels & 0xFF;

				arr[0] = i;
				arr[1] = j;
				arr[2] = r;
				arr[3] = g;
				arr[4] = b;
				rgb.add(arr);
				amountPixel++;
			}
		}
		
		// check to see if the message can fit in the picture by checking the
		// pixels with the number of characters
		if (numBits > amountPixel)
			willFit = false;

		int index = 0;
		int rgbIndex = 0;

		while (index < encode.size() - 2) {
			// read in the first three bits:
			int[] threeBits = new int[3];
			for (int k = 0; k < ENCODING; k++) {
				threeBits[k] = encode.get(index);
				index++;
			}
			/*
			 * get the next rgb values, and modify do not decrement if value is
			 * 0. do not increment if value is 255 if you want to store a 1,
			 * make the value of rgb even if you want to store a 0, make the
			 * value of rgb odd
			 */
			int[] temp = rgb.get(rgbIndex);
			int[] rgbSet = new int[3];
			rgbSet[0] = temp[2];
			rgbSet[1] = temp[3];
			rgbSet[2] = temp[4];

			for (int rgbVals = 0; rgbVals < rgbSet.length; rgbVals++) {
				if (threeBits[rgbVals] == 0) {
					// make rgb odd
					if (rgbSet[rgbVals] % 2 == 0) {
						// value is even, so make it odd
						rgbSet[rgbVals] = rgbSet[rgbVals] + 1;
					}
				} else {
					if (rgbSet[rgbVals] % 2 != 0) {
						// value is odd, so make it even
						if (rgbSet[rgbVals] == 255) {
							rgbSet[rgbVals] = rgbSet[rgbVals] - 1;

						} else {
							rgbSet[rgbVals] = rgbSet[rgbVals] + 1;
						}
					}
				}
				
				
				// set the new rgbValues
				// if willfit is set false, than we need to reserve the last 3
				// bits to
				// be the NULL value, and print to terminal that the
				// message was too big to encode in picture
				/* set the new rgbValues */
				Color col = new Color(rgbSet[0], rgbSet[1], rgbSet[2]);
				img.setRGB(temp[0], temp[1], col.getRGB());
			}
		}
		if(willFit == false)
					System.out.println("Message has been truncated");
	}

	public static void decode(BufferedImage img, String outFile) throws IOException {
		File file = new File(outFile);
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}
		//file.createNewFile();
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);

		//loop through pictures until reach ZERO_BYTE
		int height = img.getHeight();
		int width = img.getWidth();
		ArrayList<Integer> decode = new ArrayList<Integer>();
		ArrayList<int[]> rgb = new ArrayList<int[]>();
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				int[] arr = new int[NUM_ARGS];
				int pixels = img.getRGB(i, j);
				int alpha = (pixels >> 24) & 0xFF;
				int r = (pixels >> 16) & 0xFF;
				int g = (pixels >> 8) & 0xFF;
				int b = pixels & 0xFF;
				
				arr[0] = i;
				arr[1] = j;
				arr[2] = r;
				arr[3] = g;
				arr[4] = b;
				rgb.add(arr);
				//check whether each is a even number or odd
			}
		}
		
		for(int index = 0; index < rgb.size(); index++) {
			for(int j = 2; j < 5; j++) {
				//System.out.println(rgb.get(index)[j]);
				if(rgb.get(index)[j]%2 == 0) {
					//even number, so add 0 to map
					decode.add(1);
					//System.out.println(1);
				}else if(rgb.get(index)[j]==255)
					decode.add(0);
			}
		}
		
		for(int i =0; i < 90; i++) {
				//System.out.print(decode.get(i));
		}
		//bw.write(decode.get(j));
		//bw.write(content);
		bw.close();
	}
	
	// read the bit at the given index
	public static int readBit(Byte b, int index) {
		return (b >> index) & 1;
	}
}
