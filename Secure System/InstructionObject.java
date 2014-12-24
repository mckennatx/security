/* 
 * InstructionObject takes in a string, and parses through String
 * Creates an InstructionObject that is sent to the ReferenceMonitor
 */
public class InstructionObject {
	private static String instruct_type;
    private static String sub_name;
    private static String obj_name;
    private static int val; 

    public InstructionObject(String s){
        String[] tokens = s.split(" ");
        if (tokens.length == 3 || tokens.length == 4){
            instruct_type = tokens[0].toUpperCase();
            
            if (!instruct_type.equals("WRITE") && !instruct_type.equals("READ"))
                instruct_type = "BAD";
            
            sub_name = tokens[1].toLowerCase();
            obj_name = tokens[2].toLowerCase();      
        }else 
            instruct_type = "BAD";
  

        if (instruct_type.equals("WRITE")){
            if (tokens.length == 4)
                val = Integer.parseInt(tokens[3]);
            else 
                instruct_type = "BAD"; 
        }
    }

	public String get_subj(InstructionObject instruct_obj) {
		return sub_name;
	}
	
	public String get_obj(InstructionObject instruct_obj) {
		return obj_name;
	}
	
	public String get_type(InstructionObject instruct_obj) {
		return instruct_type;
	}
	
	public int get_val(InstructionObject instruct_obj) {
		return val;
	}
}