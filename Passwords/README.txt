UTEID: lm29956; nk4682;
FIRSTNAME: Lauren; Nick;
LASTNAME: McKenna; Kubala;
CSACCOUNT: mckenna; nkubala;
EMAIL: laurenmckenna@utexas.edu; nkubala@utexas.edu;

[Program 5]
[Description]
This program creats k n-length passwords using the Markov process. The program reads in a line from a file at a time. It tokenizes a line on a space. It loops through each character in that word and determines if it is a valid ASCII character (between A-Z, ASCII values 65-90). If it is valid and is the first letter of the word, it updates the STARTERS table. Next it computes the FOLLOWERS table by getting the character that follows the current character and updates the 2d array. It lastly computes the COUNTS table by summing each row in the FOLLOWERS table.

It computes the first letter of each password by generating a random number between the range of [0...n] where n = sum of all frequencies of the STARTERS table. It then loops through the STARTERS table looking for the cummulative letter count that is >= the random number that was generated. When it finds the character that satisfies the condition it appends it to the password string.

The next letters of the password is generated the same way as the first letter was generated except it uses the FOLLOWERS table.

The followers table and generated passwords are printed to stdout.

[Finish]
We finished all of the project.

[Source of Reference File]
All of these files are English books that were taken from Project Gutenberg.

1. prideandprejudice.txt from: http://www.gutenberg.org/files/1342/1342-h/1342-h.htm
   size: 704 kb

2. dentsmodernlang.txt from: http://www.gutenberg.org/files/47382/47382-h/47382-h.htm
   size: 213 kb

3. johnbrown.txt from: http://www.gutenberg.org/files/47391/47391-h/47391-h.htm
   size: 312 kb

4. huckfinn.txt from: http://www.gutenberg.org/files/76/76-h/76-h.htm
   size: 597 kb

[Test Cases]
[Input of test 1]
java Passwords prideandprejudice.txt 6 7

[Output of test 1]
Passwords are: 
TERINTE
THERSES
HENYODA
NDOFREN
THEDIZA
INEATHE

[Input of test 2]
java Passwords dentsmodernlang.txt 9 10

[Output of test 2]
Passwords are: 
ITARENGHER
WICKITRTHE
ATEAKJEMOE
CHENTHERON
WHESIDIEAT
VEBYMPREXE
SONONDUERG
ADEMPENEDP
SMBIFOFINF

[Input of test 3]
java Passwords johnbrown.txt 11 5

[Output of test 3]
Passwords are: 
REEAN
USISE
BRAPT
WISTT
CKIGE
GROUS
YOMAR
THEFI
FODEY
TENDN
OUROU

[Input of test 4]
java Passwords huckfinn.txt 5 7

[Output of test 4]
Passwords are: 
TIGLOPL
ITIDOUS
THANDGH
OWAYOTH
SPADEVE

