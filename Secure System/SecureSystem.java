import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class SecurityLevel {
	static final int LOW = -1;
	static final int HIGH = 1;
	
	public static boolean r_access(int sub_sl, int obj_sl) {
		if(sub_sl >= obj_sl)
			return true;
		return false;
	}
	
	public static boolean w_access(int obj_sl, int sub_sl) {
		if(obj_sl >= sub_sl)
			return true;
		return false;
	}
}
class Subject {
	public String name;
	public int security_level;
	public int temp;
	
	public Subject(String n, int sl) {
		name = n;
		security_level = sl;
	}
}

class Object {
	public String name;
	public int security_level;
	public int val;
	
	public Object(String n, int sl) {
		name = n;
		security_level = sl;
		val = 0;
	}
}

public class SecureSystem {
	public static void main(String[] args) throws FileNotFoundException {
		File input = new File(args[0]);
		System.out.println("Reading from file: " + input.getName());
		ReferenceMonitor rm = new ReferenceMonitor();
		
		// CREATE SUBJECTS: lyle and hal
		Subject lyle = new Subject("lyle", SecurityLevel.LOW);
		Subject hal = new Subject("hal", SecurityLevel.HIGH);

		//Inform Reference Monitor about subjects
		rm.getSubject_map().put(lyle.name, lyle);
		rm.getSubject_map().put(hal.name, hal);
		rm.getSL_map().put(lyle.name, lyle.security_level);
		rm.getSL_map().put(hal.name, hal.security_level);

		
		// ADD OBJECTS: high and low
		Object LObj = new Object("lobj", SecurityLevel.LOW);
		Object HObj = new Object("hobj", SecurityLevel.HIGH);
		
		//Inform Reference Monitor & Object Manager about objects
		rm.getSL_map().put(LObj.name, LObj.security_level);
		rm.getSL_map().put(HObj.name, HObj.security_level);
		rm.obj_man.getObj_map().put(LObj.name, LObj);
		rm.obj_man.getObj_map().put(HObj.name, HObj);

		// Instructions are read in and parsed from instruction list
		Scanner scan = new Scanner(input);
		while (scan.hasNextLine()) {
			String inst = scan.nextLine();
			// check to see if instruction == READ or WRITE passing it to
			// InstructionObject class
			InstructionObject instruction = new InstructionObject(inst);
			rm.parse_instruct(instruction);
			printState(LObj, HObj, lyle, hal);
		}
		scan.close();
	}
	
	public static void printState(Object lobj, Object hobj, Subject lyle, Subject hal) {
		System.out.println("The current state is: ");
		System.out.println("    LObj has value: " + lobj.val);
		System.out.println("    HObj has value: " + hobj.val);
		System.out.println("    Lyle has recently read: " + lyle.temp);
		System.out.println("    Hal has recently read: " + hal.temp);
	}
}
