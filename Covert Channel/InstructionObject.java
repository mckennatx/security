public class InstructionObject
{
	public static BadInstruction BAD_INSTRUCTION = new BadInstruction("bad", null, null, 0);
	
	private String instructionType, subjectName, objectName;
	private int value;

	public InstructionObject(String instructionType, String subjectName, String objectName, int value) {
		this.setInstructionType(instructionType);
		this.setSubjectName(subjectName);
		this.setObjectName(objectName);
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getInstructionType() {
		return instructionType;
	}

	public void setInstructionType(String instructionType) {
		this.instructionType = instructionType;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public String toString() {
		if(this.instructionType.equals("read"))
			return this.subjectName + " reads " + this.objectName;
		else if(this.instructionType.equals("write"))
			return this.subjectName + " writes value " + this.value + " to " + this.objectName;
		else if (this.instructionType.equals("create"))
			return this.subjectName + " creates " + this.objectName;
		else if (this.instructionType.equals("destroy"))
			return this.subjectName + " destroys " + this.objectName;
		else if (this.instructionType.equals("run"))
			return "run " + this.subjectName;
		else
			return "Bad Instruction";
		
	}
	

	private static class BadInstruction extends InstructionObject {
		BadInstruction(String instructionType, String subjectName, String objectName, int value) {
			super(instructionType, subjectName, objectName, value);
		}
		
		public String toString() {
			return "Bad Instruction";
		}
	
	}

}
