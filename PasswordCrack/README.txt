UTEID: lm29956;
FIRSTNAME: Lauren; 
LASTNAME: McKenna; 
CSACCOUNT: mckenna; 
EMAIL: laurenmckenna@utexas.edu;

[Description]
PasswordCrack.java is a program that reads in a file of users and dictionary words. When users are read in, a User object is created, saving the user's username, salt, encrypted password, and full_name. It also creates a list of unique words for the user.

The program than tries to crack a password for a user by just checking words in the dictionary and first/last name.
If there is a match, user is removed from user list, and their password is printed to stdout.

If there are no matches, the word lists for each user and for the dictionary is mangled. 
There are 12 methods that are used to manipulate a word. When the word is mangled and checked whether or not it is a password, the mangled word is added to a mangled_dictionary.
If there is a match, user is removed from user list, and their password is printed to stdout.

If there are no matches, the word lists for each user and for the mangled dictionary are mangled again.
It repeats step two again, if there is a match, user is removed from user list, and their password is printed to stdout.

[Finish]
I have finished all parts of this program. 

[Test Cases]
I was able to solve 14/20 passwords in just over a minute and a half for password1.txt

Output:
Password for Michael Ferris is: michael
Total time:        0.73
Password for Samantha Connelly is: amazing
Total time:        0.80
Password for Abigail Smith is: liagiba
Total time:        0.86
Password for Alexander Brown is: squadro
Total time:        1.72
Password for Benjamin Ewing is: abort6
Total time:        1.72
Password for Jennifer Elmer is: doorrood
Total time:        1.85
Password for Evan Whitney is: Impact
Total time:        2.08
Password for Victor Esperanza is: THIRTY
Total time:        2.51
Password for Connor Larson is: enoggone
Total time:        3.17
Password for Maia Salizar is: Salizar
Total time:        3.58
Password for Tyler Jones is: eeffoc
Total time:        4.17
Password for Morgan Simmons is: rdoctor
Total time:       41.65
Password for Jack Gibson is: sATCHEL
Total time:       49.01
Password for Nathan Moore is: sHREWDq
Total time:      101.00

********************************************************************************************************************
I was able to solve 13/20 passwords in 3 minutes for password2.txt

Output:
Password for Michael Ferris is: tremors
Total time:        0.07
Password for Abigail Smith is: Saxon
Total time:        0.50
Password for Tyler Jones is: eltneg
Total time:        0.71
Password for James Dover is: enchant$
Total time:        0.84
Password for Morgan Simmons is: dIAMETER
Total time:        0.95
Password for Nicole Rizzo is: INDIGNITY
Total time:        1.18
Password for Jack Gibson is: ellows
Total time:        1.62
Password for Caleb Patterson is: zoossooz
Total time:        2.01
Password for Connor Larson is: nosral
Total time:        2.02
Password for Alexander Brown is: Lacque
Total time:      100.44
Password for Evan Whitney is: ^bribed
Total time:      182.31
Password for Nathan Moore is: uPLIFTr
Total time:      232.60
Password for Dustin Hart is: Swine3
Total time:      232.62