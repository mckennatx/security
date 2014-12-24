import java.util.*;

public class User {

	public String username;
	public String salt;
	public String encrypt_pw;
	public String full_name;
	public ArrayList<String> word_list;
	public Set<String> mangled_words;
	public boolean mangled;

	public User(String un, String s, String pw, String name) {
		word_list = new ArrayList<String>();
		mangled_words = new HashSet<String>();

		username = un;
		salt = s;
		encrypt_pw = pw;
		full_name = name;
		mangled = false;

		String[] split = full_name.split(" ");
		word_list.add(split[0].toLowerCase());
		word_list.add(split[1].toLowerCase());
	}

	public void print_word_list() {
		for(int i = 0; i < word_list.size(); i++) {
			System.out.println(word_list.get(i));
		}
	}
}