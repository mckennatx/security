import java.util.HashMap;
import java.util.Map;

public class ReferenceMonitor {
	private ObjectManager objectManager;

	public ReferenceMonitor() {
		this.objectManager = new ObjectManager();
	}

	public void createNewObject(String objectName, SecurityLevel level) {
		SecurityObject newObj = new SecurityObject(objectName, level);
		objectManager.storeObject(newObj);
	}

	public int executeRead(SecuritySubject subj, SecurityObject obj) {
		if (subj.getSecurityLevel().dominates(obj.getSecurityLevel())) {
			subj.setTEMP(obj.getValue());
			return subj.getTEMP();
		}
		subj.setTEMP(0);
		return 0;
	}

	public void executeWrite(SecuritySubject subj, SecurityObject obj, int value) {
		if (obj.getSecurityLevel().dominates(subj.getSecurityLevel())) {
			obj.setValue(value);
		}
	}
	
	public void executeCreate(SecurityLevel level, String objName) {
		createNewObject(objName, level);
	}
	
	public void executeDestroy(SecuritySubject subj, SecurityObject obj) {
		if (obj.getSecurityLevel().dominates(subj.getSecurityLevel())) {
			objectManager.objects.remove(obj.getObjectName());
		}
		else return;
	}
	
//	public void executeRun(SecuritySubject subj) {
//		
//	}

	public ObjectManager getObjectManager() {
		return this.objectManager;
	}

	public boolean checkObject(String objName) {
		return objectManager.objects.containsKey(objName);
	}
	
	public SecurityObject getObject(String objName) {
		return objectManager.objects.get(objName);
	}

	public int processInstruction(InstructionObject iObj,
		Map<String, SecuritySubject> subjectMap) {
		
//		System.out.println("printing iObj:");
//		System.out.println(iObj);
//		System.out.println("instructionType: " + iObj.getInstructionType());
		
		SecuritySubject subj = subjectMap.get(iObj.getSubjectName());
		
		SecurityObject obj = null;
		//if the instruction isn't a create, get object from object map
		if (!iObj.getInstructionType().equals("create")) {
			obj = objectManager.objects.get(iObj.getObjectName());
		}
		int value = iObj.getValue();

		
		String iType = iObj.getInstructionType();
		if (iType.equals("bad")) {
			return 0;
		}
		else if (iType.equals("read")) {
			return executeRead(subj, obj);
		}
		else if (iType.equals("write")) {
			executeWrite(subj, obj, value);
		}
		else if (iType.equals("create")) {
			if (!objectManager.objects.containsKey(iObj.getObjectName())) {
				SecurityLevel l = subj.getSecurityLevel();
//				System.err.println(subj.getSubjectName() + " creating objecting with level " + l.toString());
				executeCreate(l, iObj.getObjectName());
			}
		}
		else if (iType.equals("destroy")) {
			if (objectManager.objects.containsKey(iObj.getObjectName()))
				executeDestroy(subj, obj);
		}
		else if (iType.equals("run")) {
			if (subj != null && subj.getSecurityLevel() == SecurityLevel.LOW)
//				subj.executeRun();
				subj.addBit(value);
		}
		else {
			System.err.println("Unrecognized instruction: " + iType);
		}
		
		return 0;
		
//		switch(iObj.getInstructionType()) {
//		case "bad":
//			break;
//		case "read":
//			return executeRead(subj, obj);
//		case "write":
//			executeWrite(subj, obj, value);
//			break;
//		case "create":
//			if (objectManager.objects.containsKey(iObj.getObjectName()))
//				break;
//			SecurityLevel l = subj.getSecurityLevel();
//			executeCreate(l, iObj.getObjectName());
//			break;
//		case "destroy":
//			if (!objectManager.objects.containsKey(iObj.getObjectName()))
//				break;
//			executeDestroy(subj, obj);
//			break;
//		//for run, if subject has high level, do nothing. otherwise, write bit.
//		case "run":
//			if (subj != null && subj.getSecurityLevel() == SecurityLevel.LOW)
////				subj.executeRun();
//				subj.addBit(value);
//			break;
//		default:
//			return 0;
//		}
//		return 0;
	}

	private class ObjectManager {
		Map<String, SecurityObject> objects = new HashMap<String, SecurityObject>();

		public void storeObject(SecurityObject obj) {
			objects.put(obj.getObjectName(), obj);
		}
	}
}
