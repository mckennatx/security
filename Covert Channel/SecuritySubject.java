import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SecuritySubject {
	private String subjectName;
	private SecurityLevel securityLevel;
	private int TEMP;
	
	private byte outBuffer;
	private int outBufferIdx;
	private BufferedWriter oWriter;
	
	private String tempByte;
	
	public SecuritySubject(String subjectName, SecurityLevel securityLevel) {
		this.setSubjectName(subjectName);
		this.setSecurityLevel(securityLevel);
		this.setTEMP(0);
		this.setByte("");
		outBuffer = 2;
		outBufferIdx = 7;
		oWriter = null;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public SecurityLevel getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(SecurityLevel securityLevel) {
		this.securityLevel = securityLevel;
	}

	public int getTEMP() {
		return TEMP;
	}

	public void setTEMP(int TEMP) {
		this.TEMP = TEMP;
	}
	
	public void setByte(String b) {
		this.tempByte = b;
	}
	
//	private void writeByte(ByteArrayOutputStream ostream) {
//		
//	}
	
	public void initializeWriter(String inFile) {
		File file = new File(inFile + ".out");
		if(!file.exists())
			try {
				file.createNewFile();
			} catch(IOException e){
				System.err.println("Error: Can't open new file to write output.");
				return;
			}
			
		FileWriter fw = null;
		try {
			fw = new FileWriter(file.getAbsoluteFile());
		} catch(IOException e){
			System.err.println("Error: cannot write output to file.");
			return;
		}
		oWriter = new BufferedWriter(fw);
	}
	
	public void closeWriter() {
		try {
			oWriter.close();
		} catch(IOException e){
			System.err.println("Error closing connection to file. Output buffer may not have fully emptied.");
		}
	}
	
	
	// adds a bit to the current position in the buffer
	// prints the value of the buffer if it is full (outBufferIdx <= 0)
	public void addBit(int bit) {
//		System.err.println("writing bit " + bit);
		if (bit == 1)
			outBuffer = (byte) (outBuffer | (1 << outBufferIdx));
		else
			outBuffer = (byte) (outBuffer & ~(1 << outBufferIdx));
		
//		System.err.println("buffer index is " + outBufferIdx);
		if (outBufferIdx <= 0) {
//			System.err.println("writing string to file: " + (char)outBuffer);
			outBufferIdx = 7;
			try {
//				System.err.println("writing string to file: " + (char)outBuffer);
				oWriter.write((char)outBuffer);
			} catch(IOException e){
				System.err.println("Error writing output to file.");
			}
		}
		else
			--outBufferIdx;
	}
	
	
	public void executeRun() {
		if (this.securityLevel == SecurityLevel.LOW) {
			
		}
		else {
			//figure out what bit is being sent
			//add bit to byte string
			//if byte is complete write it
			
		}
		
		
//		if(sys.subjectExists(inst.subjectName) && (subjectLabels.get(inst.subjectName) == SecurityLevel.LOW)){
//			Subject activeSubject = sys.getSubject(inst.subjectName);
//			activeSubject.addBit(inst.value);
//		}
	}
}
