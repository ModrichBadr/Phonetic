package com.mo.phonetic.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Badr
 * 
 */
public class Algorithm {

	/**
	 * 
	 * This variant of the Soundex (phonetic algorithm) based on the
	 * specification provided, A code is generated for a surnames by passing the
	 * string char by char through the different steps
	 * 
	 * 
	 * @param surname
	 * @return generated key
	 */
	public static String generateKey(String surname) {
		// return key
		String key = "";

		// for each character in the string
		for (char sur : surname.toCharArray()) {

			// Step 1: All non-alphabetic characters are ignored
			if (isAlphabetic(sur)) {

				// Step 2 Word case is not significant
				sur = Character.toUpperCase(sur);
				// Step 3 After the first letter, any of the following letters
				// are discarded: A, E, I, H, O, U, W, Y.
				if (key.length() > 0) {
					if (sur == 'A' || sur == 'E' || sur == 'I' || sur == 'H'
							|| sur == 'O' || sur == 'U' || sur == 'W'
							|| sur == 'Y') {
						sur = ' ';
					}
				}

				switch (sur) {

				// Step 4 The following sets of letters are considered
				// equivalent
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
					// Step 5 Any consecutive occurrences of equivalent letters
					// (after discarding letters in step 3) are considered as a
					// single occurrence
					if (!key.endsWith("A"))
						key += "A";

					break;

				case 'C':
				case 'G':
				case 'J':
				case 'K':
				case 'Q':
				case 'S':
				case 'X':
				case 'Y':
				case 'Z':
					if (!key.endsWith("B"))
						key += "B";

					break;

				case 'B':
				case 'F':
				case 'P':
				case 'V':
				case 'W':
					if (!key.endsWith("C"))
						key += "C";

					break;

				case 'D':
				case 'T':
					if (!key.endsWith("D"))
						key += "D";

					break;

				case 'M':
				case 'N':
					if (!key.endsWith("E"))
						key += "E";

					break;

				case 'H':
					if (!key.endsWith("H"))
						key += "H";

					break;

				case 'L':
					if (!key.endsWith("L"))
						key += "L";

					break;

				case 'R':
					if (!key.endsWith("R"))
						key += "R";

					break;
				}
			}
		}
		return key;
	}

	/**
	 * check if a char is alphabetic
	 * 
	 * @param c
	 * @return true if alphabetic, false if not
	 */
	private static boolean isAlphabetic(char c) {
		Pattern alphabetic = Pattern.compile("[a-zA-Z]");
		Matcher isAlphabetic;
		isAlphabetic = alphabetic.matcher(String.valueOf(c));
		return isAlphabetic.matches();

	}

}