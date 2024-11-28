/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
	
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	} 

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1).replaceAll(" ","");
		str2 = preProcess(str2).replaceAll(" ","");
		if (str1.length() != str2.length()) {
			return false;
		}
		long check1 = 1;
		long check2 = 1;
		for (int i = 0; i < str1.length(); i++) {
			check1 *= ((int) str1.charAt(i));
			check2 *= ((int) str2.charAt(i));
		}
		return check1==check2;
	}

	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		String s2 = "";
		for (int i = 0; i < str.length(); i++) {
			if ((int) str.charAt(i) > 96 || ((int) str.charAt(i) > 47 && (int) str.charAt(i) < 58) || (int) str.charAt(i) == 32) {
				s2 += str.charAt(i);
			}
			else {
				if (((int) str.charAt(i) > 64) && ((int) str.charAt(i) < 91)) {
					s2 += (char) (str.charAt(i)+32);
				} 
			}
		}
		return s2;
	} 


	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		int char_index = 0;
		String str2 = "";
		while(str.length() > 0) {
			char_index = (int) (Math.random() * (str.length()-1));
			str2 += str.charAt(char_index);
			str = str.substring(0,char_index) + str.substring(char_index+1, (str.length()));
		}
		return str2;
	}
}
