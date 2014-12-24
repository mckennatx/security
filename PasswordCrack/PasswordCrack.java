import java.util.*;
import java.io.*;




public class PasswordCrack {
	//Member Vars
    /********************************************************************************************/
    public static File dict;
	public static File pw_crack;
    public static ArrayList<String> dictionary = new ArrayList<String>();
    //public static ArrayList<String> mangled_dict = new ArrayList<String>();
    public static Set<String> mangled_dict = new HashSet<String>();
    public static ArrayList<User> users = new ArrayList<User>();
    public static long time;
    public static String[] keyboard_chars = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l"
            ,"m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G"
            ,"H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
            ,"0","1","2","3","4","5","6","7","8","9","!","@","#","$","%","^","&","*","(",")"
            ,"`","~","-","_","=","+","[","]","{","}","\\","|",";",":","'", "\"", ",", "<", ".", ">", "?", "/"};
    /********************************************************************************************/

    //Main, etc.
    /********************************************************************************************/
	public static void main(String[] args) throws IOException {
        time = System.currentTimeMillis();
		//ensure arguments are valid
        if (!parseArgs(args)) {
            return;
        }
        getDictionary();
        getUser();
        crack();
	}

	public static boolean parseArgs(String[] args) {
        if(args.length != 2){
            System.err.println("Error: must specify 2 command line arguments (mode, key file, and a file to encode or decode.");
            return false;
        }

       	dict = new File (args[0]);
     	pw_crack = new File (args[1]);

        return true;
    }
    /********************************************************************************************/
    
    //READ IN DICTIONARY AND USERS
    /********************************************************************************************/
    public static void getDictionary() throws IOException {
        Scanner scan = new Scanner(dict);
        while (scan.hasNextLine()) {
            dictionary.add(scan.nextLine().toLowerCase());
        }
        scan.close();
    }

    public static void getUser() throws IOException {
        Scanner scan = new Scanner(pw_crack);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parse = line.split(":");

            User new_user = new User(parse[0], parse[1].substring(0,2), parse[1].substring(2), parse[4]);
            users.add(new_user);
        }
        scan.close();
    }
    /********************************************************************************************/
    
    //IS PASSWORD?
    /********************************************************************************************/
    public static boolean isPassword(User u, String pword) {
        if(u.mangled) {
            u.mangled_words.add(pword);
            mangled_dict.add(pword);
        }

        if(jcrypt.crypt(u.salt, pword).substring(2).equals(u.encrypt_pw)) {
            long timeFound = System.currentTimeMillis();
            double secondsElapsed = (timeFound - time) / 1000.0;
            System.out.println("Password for " + u.full_name + " is: " + pword);
            System.out.printf("%s %10.2f", "Total time: ", secondsElapsed);
            System.out.println("");
            return true;
        }
        return false;
    }
    /********************************************************************************************/

    //CRACK
    /********************************************************************************************/
    public static void crack() {
        for(int i=0; i<users.size(); i++) {
            crack1(users.get(i));
        }

        for(int i=0; i<users.size(); i++) {
            crack2(users.get(i));
        }

        for(int i=0; i<users.size(); i++) {
            crack3(users.get(i));
        }
    }

    public static void crack1(User u) {
        for(String pw : u.word_list) {
            if(isPassword(u, pw)) {
                users.remove(u);
                break;
            }
        }
        for(String d : dictionary) {
            if(isPassword(u, d)) {
                users.remove(u);
                break;
            }
        }
    }

    public static void crack2(User u) {
        u.mangled = true;
        for(String pw : u.word_list) {
            if(prepend(u, pw)) {
                users.remove(u);
                break;
            }
            else if(append(u, pw)) {
                users.remove(u);
                break;
            }
            else if(deleteFirst(u, pw)) {
                users.remove(u);
                break;
            }
            else if(deleteLast(u, pw)) {
                users.remove(u);
                break;
            }
            else if(reverse(u, pw)) {
                users.remove(u);
                break;
            }

            else if(duplicate(u, pw)) {
                users.remove(u);
                break;
            }
            else if(reflect(u, pw)) {
                users.remove(u);
                break;
            }
            else if(upper(u, pw)) {
                users.remove(u);
                break;
            }
            else if(lower(u,pw)) {
                users.remove(u);
                break;
            }
            else if(capitalize(u, pw)) {
                users.remove(u);
                break;
            }
            else if(nCapitalize(u, pw)) {
                users.remove(u);
                break;
            }
            else if(toggle(u, pw, true)) {
                users.remove(u);
                break;
            }
            else if(toggle(u, pw, false)) {
                users.remove(u);
                break;
            }
        }

        for(String d : dictionary) {
            if(prepend(u, d)) {
                users.remove(u);
                break;
            }
            else if(append(u, d)) {
                users.remove(u);
                break;
            }
            else if(deleteFirst(u, d)) {
                users.remove(u);
                break;
            }
            else if(deleteLast(u, d)) {
                users.remove(u);
                break;
            }
            else if(reverse(u, d)) {
                users.remove(u);
                break;
            }

            else if(duplicate(u, d)) {
                users.remove(u);
                break;
            }
            else if(reflect(u, d)) {
                users.remove(u);
                break;
            }
            else if(upper(u, d)) {
                users.remove(u);
                break;
            }
            else if(lower(u,d)) {
                users.remove(u);
                break;
            }
            else if(capitalize(u, d)) {
                users.remove(u);
                break;
            }
            else if(nCapitalize(u, d)) {
                users.remove(u);
                break;
            }
            else if(toggle(u, d, true)) {
                users.remove(u);
                break;
            }
            else if(toggle(u, d, false)) {
                users.remove(u);
                break;
            }
        }
    }

    public static void crack3(User u) {
        u.mangled = false;

        for(String pw : u.mangled_words) {
            if(prepend(u, pw)) {
                users.remove(u);
                break;
            }
            else if(append(u, pw)) {
                users.remove(u);
                break;
            }
            else if(deleteFirst(u, pw)) {
                users.remove(u);
                break;
            }
            else if(deleteLast(u, pw)) {
                users.remove(u);
                break;
            }
            else if(reverse(u, pw)) {
                users.remove(u);
                break;
            }

            else if(duplicate(u, pw)) {
                users.remove(u);
                break;
            }
            else if(reflect(u, pw)) {
                users.remove(u);
                break;
            }
            else if(upper(u, pw)) {
                users.remove(u);
                break;
            }
            else if(lower(u,pw)) {
                users.remove(u);
                break;
            }
            else if(capitalize(u, pw)) {
                users.remove(u);
                break;
            }
            else if(nCapitalize(u, pw)) {
                users.remove(u);
                break;
            }
            else if(toggle(u, pw, true)) {
                users.remove(u);
                break;
            }
            else if(toggle(u, pw, false)) {
                users.remove(u);
                break;
            }

        }
        for(String d : mangled_dict) {
            if(prepend(u, d)) {
                users.remove(u);
                break;
            }
            else if(append(u, d)) {
                users.remove(u);
                break;
            }
            else if(deleteFirst(u, d)) {
                users.remove(u);
                break;
            }
            else if(deleteLast(u, d)) {
                users.remove(u);
                break;
            }
            else if(reverse(u, d)) {
                users.remove(u);
                break;
            }

            else if(duplicate(u, d)) {
                users.remove(u);
                break;
            }
            else if(reflect(u, d)) {
                users.remove(u);
                break;
            }
            else if(upper(u, d)) {
                users.remove(u);
                break;
            }
            else if(lower(u,d)) {
                users.remove(u);
                break;
            }
            else if(capitalize(u, d)) {
                users.remove(u);
                break;
            }
            else if(nCapitalize(u, d)) {
                users.remove(u);
                break;
            }
            else if(toggle(u, d, true)) {
                users.remove(u);
                break;
            }
            else if(toggle(u, d, false)) {
                users.remove(u);
                break;
            }
        }
    }
    /********************************************************************************************/

    //MANGLES
    /********************************************************************************************/
    //prepend a character to the string, e.g., @string;
    public static boolean prepend(User u, String word) {
        for(int j=0; j<keyboard_chars.length; j++) {
            String pre = (keyboard_chars[j] + word);
            if(isPassword(u, pre)) {
                return true;
            }
        }
        return false;
    }
    //append a character to the string, e.g., string9;
     public static boolean append(User u, String word) {
        for(int j=0; j<keyboard_chars.length; j++) {
            String app = (word + keyboard_chars[j]);
            if(isPassword(u, app)) {
                return true;
            }
        }
        return false;
    }
    //delete the first character from the string, e.g., tring;
    public static boolean deleteFirst(User u, String word) {
        String firstRemoved = word.substring(1);
        return isPassword(u, firstRemoved);
    }
    //delete the last character from the string, e.g., strin;
    public static boolean deleteLast(User u, String word) {
        String lastRemoved = word.substring(0, word.length()-1);
        return isPassword(u, lastRemoved);
    }
    //reverse the string, e.g., gnirts;
    public static boolean reverse(User u, String word) {
        StringBuilder sb = new StringBuilder();
        for(int i=word.length()-1; i>=0; i--) {
            sb.append(word.charAt(i));
            if(isPassword(u, sb.toString()))
                return true;
        }
        return false;
    }
    //duplicate the string, e.g., stringstring;
    public static boolean duplicate(User u, String word) {
        String dup = word + word;
        return isPassword(u, dup);
    }
    //reflect the string, e.g., stringgnirts or gnirtsstring;
    public static boolean reflect(User u, String word) {
        StringBuilder sb = new StringBuilder();
        for(int i=word.length()-1; i>=0; i--) {
            sb.append(word.charAt(i));
        }
        String reverse = sb.toString();
        if(isPassword(u, word+reverse))
            return true;
        else if(isPassword(u, reverse+word))
            return true;
        return false;
    }   
    //uppercase the string, e.g., STRING;
    public static boolean upper(User u, String word) {
        return isPassword(u, word.toUpperCase());
    }
    //lowercase the string, e.g., string;
    public static boolean lower(User u, String word) {
        return isPassword(u, word.toLowerCase());
    }
    //capitalize the string, e.g., String;
    public static boolean capitalize(User u, String word) {
        String cap = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
        return isPassword(u, cap);
    }
    //ncapitalize the string, e.g., sTRING;
     public static boolean nCapitalize(User u, String word) {
        String nCap = word.substring(0, 1).toLowerCase() + word.substring(1).toUpperCase();
        return isPassword(u, nCap);
    }
    //toggle case of the string, e.g., StRiNg or sTrInG;
    public static boolean toggle(User u, String word, boolean t) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<word.length(); i++) {
            if(t) {
                if(i%2 == 0)
                    sb.append((word.charAt(i) +"").toUpperCase());
                else 
                    sb.append((word.charAt(i)+""));
            }
            else {
                if (i%2 == 1)
                    sb.append(((word.charAt(i))+"").toUpperCase());
                else {
                    sb.append((word.charAt(i)+""));
                }
            }
        }
         return isPassword(u, sb.toString());
    }
    /********************************************************************************************/
}