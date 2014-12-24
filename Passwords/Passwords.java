import java.util.*;
import java.io.*;
 
public class Passwords {
	//Member Vars
	/********************************************************************************************/
	public static int[] COUNTS = new int[26];
	public static int[] STARTERS = new int[26];
	public static int[][] FOLLOWERS = new int[26][26];

	public static File readIn;
	public static int num_pw, len_pw;
	/********************************************************************************************/
	
	//Main, etc.
	/********************************************************************************************/
	public static void main (String[] args) throws IOException{
		//ensure arguments are valid
        if (!parseArgs(args)) {
            return;
        }
        /* Argument Debugging */
        //System.out.println(readIn.toString());
        //System.out.println("number of passwords = " + num_pw + " length of passwords = " + len_pw);
        
        computeTables();
        System.out.println("Passwords are: ");
        for(int count=0; count<num_pw; count++) {
        	passwordGenerator();
        }
	}

	public static boolean parseArgs(String[] args) {
        if(args.length != 3){
            System.err.println("Error: must specify 3 command line arguments (mode, key file, and a file to encode or decode.");
            return false;
        }

       	readIn = new File (args[0]);
     	num_pw = Integer.parseInt(args[1]);
     	len_pw = Integer.parseInt(args[2]);

        return true;
    }	
    /********************************************************************************************/


	//Compute COUNTS, STARTERS, and FOLLOWERS TABLE
	/********************************************************************************************/
	public static void computeTables() throws IOException {
		Scanner scan = new Scanner (readIn);
    	while (scan.hasNextLine()) {
    		String input = scan.nextLine();
    		String[] word = input.split(" ");
    			
    		for(int i=0; i<word.length; i++) {
    			String upper = word[i].toUpperCase();
    			for(int j=0; j<upper.length(); j++) {
    				if(charValid(upper.charAt(j))) {
    					int index = upper.charAt(j) % 65;
    					if(j==0) {
    						STARTERS[index]++;
    					}
    					if(j<upper.length()-1 && charValid(upper.charAt(j+1))) {
    						int index2 = upper.charAt(j+1) % 65;
    						FOLLOWERS[index][index2]++;
    					}
    				}
    			}
    		}
    	}
    	computeCounts();
     	//printCOUNTERS();
    	//printSTARTERS();
    	printFOLLOWERS();
	}

	public static void computeCounts() {
		for(int row=0; row<FOLLOWERS.length; row++){
			for(int col=0; col<FOLLOWERS.length; col++) {
				COUNTS[row] += FOLLOWERS[row][col];
			}
		}
	}

	public static boolean charValid (char ch) {
    	//65 = ASCII value of uppercase A
    	//90 = ASCII value of uppercase Z
    	if((int)ch >= 65 && (int)ch <= 90)
    		return true;
    	return false;
    }	
	/********************************************************************************************/

	//Password Generator and helper methods
	/********************************************************************************************/
	public static void passwordGenerator () {
		int length = len_pw;
		StringBuilder sb = new StringBuilder();
		Random rg = new Random();
		char ch;

		ch = computeFirstLetter(rg);
      	sb.append(ch);
      	for (int i=1; i<len_pw; i++) {
	      	ch = computeNext(rg, ch);
	      	sb.append(ch);
      	}

		System.out.println(sb.toString());
	}

	public static char computeFirstLetter (Random rg) {
 		int startCount = starterFreq()+1;
        int startFreq = rg.nextInt(startCount);
        int first = getFirst(startFreq, startCount);
    
        return (char)(first+65);
	}

	public static char computeNext (Random rg, char prev) {
		int index = prev % 65;
		int count = COUNTS[index]+1;
        int freq = rg.nextInt(count);
        int nextCh = getNext(freq, count, index);

        return (char)(nextCh+65);
	}

	public static int getNext (int freq, int count, int index) {
        int counter = 0;
        for(int col=0; col<FOLLOWERS.length; col++) {
        	counter += FOLLOWERS[index][col];
        	if(counter >= freq) {
				return col;
        	}
        }
        return -1;
	}

	public static int getFirst (int freq, int startCount) {
		int counter = 0;
		for(int i=0; i<STARTERS.length; i++) {
			counter += STARTERS[i];
			if(counter >= freq) {
				return i;
			}
		}
		return -1;
	} 

	public static int starterFreq () {
    	int count = 0;
    	for(int i=0; i<STARTERS.length; i++) 
    		count += STARTERS[i];
    	return count;
    }
	/********************************************************************************************/

	//Print methods for Debugging
	/********************************************************************************************/
    public static void printCharacters(boolean tab) {
		for(int i = 0; i < 26; i++) {
			if(i==0 && tab)
				System.out.print("\t");
			System.out.print((char)(i+65) + "\t");
		}
		System.out.println();
    }

    public static void printCOUNTERS() {
		System.out.println("\nCOUNTS TABLE: ");
		printCharacters(false);
		for(int i=0; i<COUNTS.length; i++) {
				System.out.print(COUNTS[i] + "\t");
		}
		System.out.println("\n");
    }

    public static void printSTARTERS() {
		System.out.println("\nSTARTERS TABLE: ");
		printCharacters(false);
		for(int i=0; i<STARTERS.length; i++)
			System.out.print(STARTERS[i] + "\t");

		System.out.println("\n");
    }

    public static void printFOLLOWERS() {
    	System.out.println("\nFOLLOWERS TABLE: ");
    	printCharacters(true);
    	for(int i=0; i<FOLLOWERS.length; i++) {
    		System.out.print((char)(i+65) + ":\t");
    		for(int j=0; j<FOLLOWERS.length; j++) {
    			System.out.print(FOLLOWERS[i][j] + "\t");
    		}
    		System.out.println();
    	}
    }
	/********************************************************************************************/

}