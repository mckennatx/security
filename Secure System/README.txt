UTEID: lm29956;
FIRSTNAME: Lauren;
LASTNAME: McKenna;
CSACCOUNT: mckenna;
EMAIL: laurenmckenna@utexas.edu;

Program 1]
[Description]
This program has three classes:
1. SecureSystem.java
	This is where the main method of the program is ran. It is responsible for reading in from an instruction.txt file
	It passes a String line to the InstructionObject class
	Creates Objects and Subjects
		Inside this class is three more classes:
		1. Object
		2. Subject
		3. SecurityLevel
			Methods that check if a subj/obj is able to read/write
2. ReferenceMonitor.java
	The ReferenceMonitor is responsible for determining whether or not to read/write an obj/subj. It also handles bad instructions.
	The ObjectManager is a sub class found inside ReferenceMonitor.java. It either reads values into subjects or writes values to objects when
	the reference monitor grants it permission.
3. InstructionObject.java
	The InstructionObject reads in a string line from a file. It parses the line and determines if it is a legal instruction.
	Legal instruction formats are the following:
 			READ subject_name object_name 
   			WRITE subject_name object_name value
	If it is not a legal instruction, it will return a bad instruction object back to main 
To complie our program, you need to use "javac *.java". To run our program, you need to use "java SecureSystem instructionList" (or any name of a text file that is provided because the program reads in the argument in the command line) IE: File input = new File(args[0]);

[Finish]
I have completed all parts of the project and the program passes all the provided tests.

[Test Cases]
[Input of test 1]
write Hal HObj 
read Hal 
write Lyle LObj 10
read Hal LObj 
write Lyle HObj 20
write Hal LObj 200
read Hal HObj
read Lyle LObj
read Lyle HObj
foo Lyle LObj
Hi Lyle,This is Hal
The missile launch code is 1234567

[Output of test 1]
Reading from file: instructionList

Bad Instruction
The current state is: 
   LObj has value: 0
   HObj has value: 0
   Lyle has recently read: 0
   Hal has recently read: 0

Bad Instruction
The current state is: 
   LObj has value: 0
   HObj has value: 0
   Lyle has recently read: 0
   Hal has recently read: 0

lyle writes value 10 to lobj
The current state is: 
   LObj has value: 10
   HObj has value: 0
   Lyle has recently read: 0
   Hal has recently read: 0

hal reads lobj
The current state is: 
   LObj has value: 10
   HObj has value: 0
   Lyle has recently read: 0
   Hal has recently read: 10

lyle writes value 20 to hobj
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 0
   Hal has recently read: 10

hal writes value 200 to lobj
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 0
   Hal has recently read: 10

hal reads hobj
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 0
   Hal has recently read: 20

lyle reads lobj
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 10
   Hal has recently read: 20

lyle reads hobj
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 0
   Hal has recently read: 20

Bad Instruction
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 0
   Hal has recently read: 20

Bad Instruction
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 0
   Hal has recently read: 20

Bad Instruction
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 0
   Hal has recently read: 20
   
[Input of test 2]
write Lyle LObj 10
write Lyle LObj 20
write Lyle LObj 30
read Hal 
read Hal LObj 
write Hal LObj 200
read Hal HObj
read Lyle LObj
read Lyle HObj

[Output of test 2]
lyle writes 10 to lobj
The current state is: 
    LObj has value: 10
    HObj has value: 0
    Lyle has recently read: 0
    Hal has recently read: 0

lyle writes 20 to lobj
The current state is: 
    LObj has value: 20
    HObj has value: 0
    Lyle has recently read: 0
    Hal has recently read: 0

lyle writes 30 to lobj
The current state is: 
    LObj has value: 30
    HObj has value: 0
    Lyle has recently read: 0
    Hal has recently read: 0
The current state is: 
    LObj has value: 30
    HObj has value: 0
    Lyle has recently read: 0
    Hal has recently read: 0

hal reads lobj
The current state is: 
    LObj has value: 30
    HObj has value: 0
    Lyle has recently read: 0
    Hal has recently read: 30

WRITE VIOLATES -*Property
The current state is: 
    LObj has value: 30
    HObj has value: 0
    Lyle has recently read: 0
    Hal has recently read: 30

hal reads hobj
The current state is: 
    LObj has value: 30
    HObj has value: 0
    Lyle has recently read: 0
    Hal has recently read: 0

lyle reads lobj
The current state is: 
    LObj has value: 30
    HObj has value: 0
    Lyle has recently read: 30
    Hal has recently read: 0

READ VIOLATES SSP
The current state is: 
    LObj has value: 30
    HObj has value: 0
    Lyle has recently read: 0
    Hal has recently read: 0

[Input of test 3]
read Lyle LObj
read Hal HObj
write Lyle LObj 0
write Hal HObj 0
write Hal LObj 10
write Hal HObj 100
write Lyle HObj 50
read Lyle LObj
read Hal HObj

[Output of test 3]
lyle reads lobj
The current state is: 
    LObj has value: 0
    HObj has value: 0
    Lyle has recently read: 0
    Hal has recently read: 0

hal reads hobj
The current state is: 
    LObj has value: 0
    HObj has value: 0
    Lyle has recently read: 0
    Hal has recently read: 0

lyle writes 0 to lobj
The current state is: 
    LObj has value: 0
    HObj has value: 0
    Lyle has recently read: 0
    Hal has recently read: 0

hal writes 0 to hobj
The current state is: 
    LObj has value: 0
    HObj has value: 0
    Lyle has recently read: 0
    Hal has recently read: 0

WRITE VIOLATES -*Property
The current state is: 
    LObj has value: 0
    HObj has value: 0
    Lyle has recently read: 0
    Hal has recently read: 0

hal writes 100 to hobj
The current state is: 
    LObj has value: 0
    HObj has value: 100
    Lyle has recently read: 0
    Hal has recently read: 0

lyle writes 50 to hobj
The current state is: 
    LObj has value: 0
    HObj has value: 50
    Lyle has recently read: 0
    Hal has recently read: 0

lyle reads lobj
The current state is: 
    LObj has value: 0
    HObj has value: 50
    Lyle has recently read: 0
    Hal has recently read: 0

hal reads hobj
The current state is: 
    LObj has value: 0
    HObj has value: 50
    Lyle has recently read: 0
    Hal has recently read: 50

[Input of test 4]
write Lyle HObj 10
READ Lyle hobj
write HAL lobj 15
READ HAL LOBJ 
read lyle lobj
read lyle hobj
read hal lobj
read hal hobj
write lyle lobj 25
write lyle hobj 25
write hal lobj 50
write hal hobj 50
read lyle lobj
read lyle hobj
read hal lobj
read hal hobj
test not valid subjects and objects
read sam lobj
read hal hobj2
write sam lobj 10 
write lyle lobj2 10
test blank line

[Output of test 4]
lyle writes 10 to hobj
The current state is: 
    LObj has value: 0
    HObj has value: 10
    Lyle has recently read: 0
    Hal has recently read: 0

READ VIOLATES SSP
The current state is: 
    LObj has value: 0
    HObj has value: 10
    Lyle has recently read: 0
    Hal has recently read: 0

WRITE VIOLATES -*Property
The current state is: 
    LObj has value: 0
    HObj has value: 10
    Lyle has recently read: 0
    Hal has recently read: 0

hal reads lobj
The current state is: 
    LObj has value: 0
    HObj has value: 10
    Lyle has recently read: 0
    Hal has recently read: 0

lyle reads lobj
The current state is: 
    LObj has value: 0
    HObj has value: 10
    Lyle has recently read: 0
    Hal has recently read: 0

READ VIOLATES SSP
The current state is: 
    LObj has value: 0
    HObj has value: 10
    Lyle has recently read: 0
    Hal has recently read: 0

hal reads lobj
The current state is: 
    LObj has value: 0
    HObj has value: 10
    Lyle has recently read: 0
    Hal has recently read: 0

hal reads hobj
The current state is: 
    LObj has value: 0
    HObj has value: 10
    Lyle has recently read: 0
    Hal has recently read: 10

lyle writes 25 to lobj
The current state is: 
    LObj has value: 25
    HObj has value: 10
    Lyle has recently read: 0
    Hal has recently read: 10

lyle writes 25 to hobj
The current state is: 
    LObj has value: 25
    HObj has value: 25
    Lyle has recently read: 0
    Hal has recently read: 10

WRITE VIOLATES -*Property
The current state is: 
    LObj has value: 25
    HObj has value: 25
    Lyle has recently read: 0
    Hal has recently read: 10

hal writes 50 to hobj
The current state is: 
    LObj has value: 25
    HObj has value: 50
    Lyle has recently read: 0
    Hal has recently read: 10

lyle reads lobj
The current state is: 
    LObj has value: 25
    HObj has value: 50
    Lyle has recently read: 25
    Hal has recently read: 10

READ VIOLATES SSP
The current state is: 
    LObj has value: 25
    HObj has value: 50
    Lyle has recently read: 0
    Hal has recently read: 10

hal reads lobj
The current state is: 
    LObj has value: 25
    HObj has value: 50
    Lyle has recently read: 0
    Hal has recently read: 25

hal reads hobj
The current state is: 
    LObj has value: 25
    HObj has value: 50
    Lyle has recently read: 0
    Hal has recently read: 50
The current state is: 
    LObj has value: 25
    HObj has value: 50
    Lyle has recently read: 0
    Hal has recently read: 50

BAD INSTRUCTION
The current state is: 
    LObj has value: 25
    HObj has value: 50
    Lyle has recently read: 0
    Hal has recently read: 50

BAD INSTRUCTION
The current state is: 
    LObj has value: 25
    HObj has value: 50
    Lyle has recently read: 0
    Hal has recently read: 50

BAD INSTRUCTION
The current state is: 
    LObj has value: 25
    HObj has value: 50
    Lyle has recently read: 0
    Hal has recently read: 50

BAD INSTRUCTION
The current state is: 
    LObj has value: 25
    HObj has value: 50
    Lyle has recently read: 0
    Hal has recently read: 50

BAD INSTRUCTION
The current state is: 
    LObj has value: 25
    HObj has value: 50
    Lyle has recently read: 0
    Hal has recently read: 50