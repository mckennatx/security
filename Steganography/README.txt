UTEID: lm29956;
FIRSTNAME: Lauren;
LASTNAME: McKenna;
CSACCOUNT: mckenna;
EMAIL: laurenmckenna@utexas.edu;

Program 3

[Description of Code]
	Steganography.java is a program that hides an ASCII message in a picture.
	The program has two main functions: encoding messages and decoding messages
	-E flag denotes the user wants to encode a message, and -D flag denotes the user wants to decode a message.
	The program encodes a message by the following:
		Opens file with image, reads in the RGB values of each pixel and stores them in an arraylist
		Opens the file with the message that wants to be hidden, stores each bit of the ascii characters into an arraylist and then adds the 0 byte to the end of the arraylist
		Once this metadata is stored, it checks to see if the full message can be stored in the file (is num bits < num pixels), if it can't it will write to the console that the message has been truncated, and it encodes as much as the message as it can (still adding the 0 byte to the end)
		uses getRGB method to get RGB value and then hexidecimal math to get the value of R, G, and B respectively
		After checking the boolean value, it loops through the arraylist of pixels in the picture, and loops through the arraylist of bits to be encoded, it grabs three bits from the bits to be encoded, grabs one set of rgb vals from and makes the respective values of RGB even if the bit = 0 or odd if the bit = 1.
		Exports image.
	The program decodes the message by doing a similar thing, except will change the RGB value to odd if the bit = 0 or odd if the bit = 1.

[Finished Program?]
	I unfortunately have not finished this project to its entirety. I completely finished the encoding part of the program, and the program correctly encodes the message in each bit of the RGB values. The decoding method is implemented, however the logic used to design it is off because it is not returning the correct decoded message. The reason for not having time to figure out directly why the decoding portion of this problem doesn't work is I have been working on a project for Operating Systems, and I flew out to Chicago and missed the couple days of school for a second round interview. However, I tried to get as much as I could working.

[Questions]
1. I can't visibly see any differences between the modified image and the original image
2. You could hide the message in various ways, perhaps you have a key for each number 0-255, depending on what the number equals, you could add the bit to it that way.
3. The bandwidth of this channel could be increased if the pixel in each image was represented by more than 24 bits. That would mean more than 3 ascii bits could be stored per pixel.
4. To build the firewall, you would need to be able to see the pattern of the zero byte at the end of message, if the picture had the remaining pixels of their message all set to even numbers, you could be able to distinguish what is a "safe" photo from a photo that contained a hidden message.
5. This is a covert channel that is not as easily recognized, even by the eye. It takes normally harmless pieces of data and hides the secret information insid of it. To the sender and receiver of he data, the basis of using steganography is to keep it from being easily recognized.