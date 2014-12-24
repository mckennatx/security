import java.util.HashMap;
import java.util.Map;

public class ReferenceMonitor {
	private Map<String, Integer> sl_map;
	private Map<String, Subject> subject_map;
	ObjectManager obj_man = new ObjectManager();
	
	public ReferenceMonitor() {
		sl_map = new HashMap<String, Integer>();
		subject_map = new HashMap<String, Subject>();
	}
	
	public Map<String, Subject> getSubject_map() {
		return subject_map;
	}
	
	public Map<String, Integer> getSL_map() {
		return sl_map;
	}
	
	public void parse_instruct(InstructionObject instruct_obj) {
		String subject = instruct_obj.get_subj(instruct_obj);
		String object = instruct_obj.get_obj(instruct_obj);
		if(getSubject_map().containsKey(subject) && obj_man.object_map.containsKey(object)) {
			String instruction = instruct_obj.get_type(instruct_obj);
			int value = instruct_obj.get_val(instruct_obj);	
			if(instruction.equalsIgnoreCase("read"))
				read(subject, object);
			
			else if(instruction.equalsIgnoreCase("write")) 
				write(subject, object, value);
		}
		else
			System.out.println("\nBAD INSTRUCTION");
	}
	
	private void read(String sub_name, String obj_name) {
		//Check to see if reading is available
		if(SecurityLevel.r_access(sl_map.get(sub_name), sl_map.get(obj_name))) {
			System.out.println("\n" + sub_name + " reads " + obj_name);
			//set subj temp variable = to the obj val
			obj_man.execute_r(getSubject_map().get(sub_name), obj_man.object_map.get(obj_name));
		}
		
		else {
			System.out.println("\nREAD VIOLATES SSP");
			getSubject_map().get(sub_name).temp = 0;
		}
	}

	private void write(String sub_name, String obj_name, int val) {
		//Check to see if writing is available
		if(SecurityLevel.w_access(sl_map.get(obj_name), sl_map.get(sub_name))) {
			System.out.println("\n" + sub_name + " writes " + val + " to " + obj_name);
			obj_man.execute_w(obj_man.object_map.get(obj_name), val);
		}
		else
			System.out.println("\nWRITE VIOLATES -*Property");
	}
	
	static class ObjectManager{
		private Map<String, Object> object_map = new HashMap<String, Object>();

		public void execute_r(Subject sub, Object obj) {
			sub.temp = obj.val;
		}

		public void execute_w(Object obj, int val) {
			//update the value
			obj.val = val;
		}
		
		public Map<String, Object> getObj_map() {
			return object_map;
		}
	}
}
