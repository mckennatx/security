import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CovertChannel {

	private Map<String, SecuritySubject> subjectMap = new HashMap<String, SecuritySubject>();
	
	private ReferenceMonitor monitor;
	
	public static boolean process = true;
	
	private InstructionObject currentInstruction;
	
	public CovertChannel() {
		this.monitor = new ReferenceMonitor();
	}
	
	
	public static void main(String[] args) {
		if(args.length == 0 || (args.length == 1 && args[0].equals("v"))){
			System.err.println("Error: no input file specified.\n");
			return;
		}
		
		long startTime, endTime;
		
		//if -v flag is set, open log file
		PrintWriter logWriter;
		boolean verbose = false;
		if (args[0].equals("v")) {
			verbose = true;
			try {
				logWriter = new PrintWriter("log.txt");
			} catch (FileNotFoundException e) {
				System.err.println("Error: can't write instructions to log file. Verbose mode turned off.");
				verbose = false;
				logWriter = null;
			}
		}
		else
			logWriter = null;
		
		//extract inFile name
		String inFile;
		if (verbose)
			inFile = args[1];
		else
			inFile = args[0];
		
		
		//instantiate sys object
		CovertChannel sys = new CovertChannel();
		
		SecurityLevel low = SecurityLevel.LOW;
		SecurityLevel high = SecurityLevel.HIGH;
		
		sys.createSubject("Lyle", low);
		sys.createSubject("Hal", high);
		
//		sys.getReferenceMonitor().createNewObject("LObj", low);
//		sys.getReferenceMonitor().createNewObject("HObj", high);
		
		sys.getSubject("Lyle").initializeWriter(inFile);
		startTime = System.nanoTime();
		
		//open BufferedReader with file
		byte[] lineBuffer;
		int currentBit, numBytesIn;
		BufferedReader in;
		String currentLine;
		try {
			in = new BufferedReader(new FileReader(inFile));
		} catch(FileNotFoundException e){
			System.err.println("Error: file " + inFile + " not found.");
			return;
		}
		try {
			currentLine = in.readLine();
		} catch(IOException e) {
			System.err.println("Error: unable to read from file.");
			return;
		}
		while(currentLine != null && process) {
			lineBuffer = (currentLine + "\n").getBytes();
			numBytesIn = lineBuffer.length;
			for(int i = 0; i < numBytesIn; i++) {
				for(int j = 7; j >= 0; j--) {
					currentBit = readBit(lineBuffer[i], j);
					sys.runHal(currentBit, verbose, logWriter);
					sys.runLyle(verbose, logWriter);
				}
			}
			
			try{
				currentLine = in.readLine();
			} catch(IOException e){
				System.err.println("Error: unable to read from file.");
				return;
			}
		}

		endTime = System.nanoTime();
		sys.getSubject("Lyle").closeWriter();
		if(logWriter != null)
			logWriter.close();
		long duration = endTime - startTime;
		long filesize = (new File(inFile)).length();
		System.out.println("\n" + inFile + ": File Size = " + filesize + ", Time: " + duration + ", Bandwidth = " + (filesize * 8.0) / (duration / 1000000));
//		sys.readInstructions(args[0]);
	}
	
	
	public void printState() {
		System.out.println("The current state is:");
		SecurityObject lObj = this.monitor.getObject("LObj");
		SecurityObject hObj = this.monitor.getObject("HObj");
		System.out.println("  LObj has value: " + lObj.getValue());
		System.out.println("  HObj has value: " + hObj.getValue());
		SecuritySubject lyle = this.getSubject("Lyle");
		SecuritySubject hal = this.getSubject("Hal");
		System.out.println("  Lyle has recently read: " + lyle.getTEMP());
		System.out.println("  Hal has recently read: " + hal.getTEMP());
		System.out.println();
	}
	
	public void createSubject(String subjectName, SecurityLevel securityLevel) {
		SecuritySubject subject = new SecuritySubject(subjectName, securityLevel);
		subjectMap.put(subjectName, subject);
		
	}

	public ReferenceMonitor getReferenceMonitor() {
		return this.monitor;
	}
	
	private void readInstructions(String fileName) {
		File f = new File(fileName);
		System.out.println();
		System.out.println("Reading from file: " + fileName);
		System.out.println();
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNext()) {
				String instruction = sc.nextLine();
				InstructionObject iObj = parseInstruction(instruction);
				
				int ret = monitor.processInstruction(iObj, subjectMap);
				printState();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private InstructionObject parseInstruction(String in) {
		String[] line = in.split(" ");

		if (line.length < 3) {
			return InstructionObject.BAD_INSTRUCTION;
		}
		if (!checkSubject(line[1]) || !checkObject(line[2])) {
			return InstructionObject.BAD_INSTRUCTION;
		}
		
		if (line[0].equals("write")) {
			if (line.length != 4) {
				return InstructionObject.BAD_INSTRUCTION;
			}
			
			int value;
			try {
				value = Integer.parseInt(line[3]);
			}
			catch (NumberFormatException e) {
				return InstructionObject.BAD_INSTRUCTION;
			}
			return new InstructionObject(line[0], line[1], line[2], value);
		}
		else if (line[0].equals("read")) {
			if (line.length != 3) {
				return InstructionObject.BAD_INSTRUCTION;
			}
			else {
				return new InstructionObject(line[0], line[1], line[2], 0);
			}
		}
		else if (line[0].equals("create")) {
			if (line.length != 3) {
				return InstructionObject.BAD_INSTRUCTION;
			}
			else {
				return new InstructionObject(line[0], line[1], line[2], 0);
			}
		}
		else if (line[0].equals("destroy")) {
			if (line.length != 3) {
				return InstructionObject.BAD_INSTRUCTION;
			}
			else {
				return new InstructionObject(line[0], line[1], line[2], 0);
			}
		}
		else if (line[0].equals("run")) {
			if (line.length != 2) {
				return InstructionObject.BAD_INSTRUCTION;
			}
			else {
				return new InstructionObject(line[0], line[1], null, 0);
			}
		}

		return InstructionObject.BAD_INSTRUCTION;
	}
	
	private boolean checkSubject(String subjectName) {
		return subjectMap.containsKey(subjectName);
	}
	
	private boolean checkObject(String objName) {
		return monitor.checkObject(objName);
	}
	
	public SecuritySubject getSubject(String name) {
		return subjectMap.get(name);
	}

	// read the bit at the given index
	public static int readBit(Byte b, int index){
		return (b >> index) & 1;
	}

	
	//if hal is to write a 0, create a new object, otherwise do nothing.
	public void runHal(int bit, boolean verbose, PrintWriter w) {
		currentInstruction = new InstructionObject("run", "Hal", null, 0);
		if (verbose)
			logInstruction(currentInstruction, w);
		monitor.processInstruction(currentInstruction, subjectMap);
		if (bit == 0) {
			currentInstruction = new InstructionObject("create", "Hal", "obj", 0);
			if (verbose)
				logInstruction(currentInstruction, w);
			monitor.processInstruction(currentInstruction, subjectMap);
		}
	}
	
	
	public void runLyle(boolean verbose, PrintWriter w) {
		int readResult = 0;
		currentInstruction = new InstructionObject("create", "Lyle", "obj", 0);
		if(verbose){
			logInstruction(currentInstruction, w);
		}
		monitor.processInstruction(currentInstruction, subjectMap);
		currentInstruction = new InstructionObject("write", "Lyle", "obj", 1);
		if(verbose){
			logInstruction(currentInstruction, w);
		}
		monitor.processInstruction(currentInstruction, subjectMap);
		currentInstruction = new InstructionObject("read", "Lyle", "obj", 0);
		if(verbose){
			logInstruction(currentInstruction, w);
		}
		readResult = monitor.processInstruction(currentInstruction, subjectMap);
		currentInstruction = new InstructionObject("destroy", "Lyle", "obj", 0);
		if(verbose){
			logInstruction(currentInstruction, w);
		}
		monitor.processInstruction(currentInstruction, subjectMap);
		currentInstruction = new InstructionObject("run", "Lyle", null, readResult);
		if(verbose){
			logInstruction(currentInstruction, w);
		}
		monitor.processInstruction(currentInstruction, subjectMap);
	}
	
	
	public void logInstruction(InstructionObject iObj, PrintWriter w) {
		String instruction = iObj.getInstructionType();
		
		switch (instruction) {
			case "create":
				w.println("create " + iObj.getSubjectName() + " " + iObj.getObjectName());
				break;
			case "destroy":
				w.println("destroy " + iObj.getSubjectName() + " " + iObj.getObjectName());
				break;
			case "run":
				w.println("run " + iObj.getSubjectName());
				break;
			case "write":
				w.println("write " + iObj.getSubjectName() + " " + iObj.getObjectName() + " " + iObj.getValue());
				break;
			case "read":
				w.println("read " + iObj.getSubjectName() + " " + iObj.getObjectName());
				break;
			default:
				break;
		}
	}


}



