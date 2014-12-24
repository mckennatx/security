UTEID: lm29956; nk4682;
FIRSTNAME: Lauren; Nick;
LASTNAME: McKenna; Kubala;
CSACCOUNT: mckenna; nkubala;
EMAIL: laurenmckenna@utexas.edu; nkubala@utexas.edu;

[Program 2]
[Description]
This program creates a covert channel in the class: CovertChannel. The program begins by creating two subjects: LYLE (security level = low) and HAL (security level = high). It then reads in bits from a file, and calls the following methods:
	sys.runHal(currentBit, verbose, logWriter);
	sys.runLyle(verbose, logWriter);

In runHal, it checks to see if Hal is to write a 0, if it does it creates a new object
In runLyle, Lyle needs to sense the bit (the presence or absence of the object) by executing the following:
  CREATE LYLE OBJ
  WRITE LYLE OBJ 1
  READ LYLE OBJ
  DESTROY LYLE OBJ
  RUN LYLE
It does this by setting currentInstruction = new InstructionObject("create", "Lyle", "obj", 0);
the monitor then processes the instruction.
It then sets currentInstruction  = new InstructionObject("write", "Lyle", "obj", 1);
the monitor again processes the instruction
It then sets currentInstruction = new InstructionObject("read", "Lyle", "obj", 0); 
readResult = monitor.processInstruction(currentInstruction, subjectMap);
currentInstruction = new InstructionObject("destroy", "Lyle", "obj", 0);
The monitor processes the instruction
currentInstruction = new InstructionObject("run", "Lyle", null, readResult);

[Finish]
We finished the whole thing. It works.

[Timing Output]
Machine type: Linux (lab computer)
Clock speed: cpu MHz		: 1600.000

Document				Size			Bandwidth
metamorphosis.txt 	   141,418 bytes	3120.5 bits/ms
prideandprejudice.txt  717,568 bytes	4337.6 bits/ms
test.txt			   278 bytes		47 bits/ms



