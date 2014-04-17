package com.mo.phonetic;

import java.util.ArrayList;

import com.mo.phonetic.model.Surname;
import com.mo.phonetic.util.Algorithm;
import com.mo.phonetic.util.File;

/**
 * 
 * The data structure used to store the data for this program is a list
 * implementation. This mainly due to the performance a list implementation
 * provides when iterating over the data. since I do not access data arbitrary,
 * I thought this was the most suitable approach.
 * 
 * For scalability I would look into using a ConcurrentMap
 * (java.util.concurrent) data structure and use threads to process multiple
 * names at the same time. The current implementation does not utilise the
 * system resource.
 * 
 * 
 * 
 * @author Badr
 * 
 */
public class Main {

	private static ArrayList<Surname> surnames_file = new ArrayList<Surname>();
	private static ArrayList<Surname> surname_args = new ArrayList<Surname>();
	// output formatting
	private static boolean first_result;

	public static void main(String[] args) {

		// processing args
		String file_name = null;
		for (String arg : args) {
			if (arg.endsWith(".txt")) {
				file_name = arg;
			} else {
				Surname sur = new Surname(arg, null);
				surname_args.add(sur);
			}

		}

		// check input for missing args
		if (file_name != null && !surname_args.isEmpty()) {
			// read all surnames in the file and generate a key for each surname
			surnames_file = File.readFileGenerateKey(file_name);

			// process the args
			for (Surname arg : surname_args) {
				first_result = true;

				// generate a key for surname and set key for the object
				arg.setCode(Algorithm.generateKey(arg.getSurname()));
				String output = arg.getSurname() + ": ";

				// compare key generated for the surnames arg with keys
				// generated for surnames file
				for (Surname file_arg : surnames_file) {
					// if the keys match get
					if (arg.getCode().equals(file_arg.getCode())) {
						// only add if not first
						if (!first_result) {
							output += ", ";
						}

						output += file_arg.getSurname();
						first_result = false;
					}

				}

				// since there was no first result, first_result remains true
				// thus no matches have been found
				if (first_result) {
					System.out.println(output + "No Matches Found");
				} else {
					// print result
					System.out.println(output);
				}
			}

		} else {

			System.out
					.println("file name or  surnames  are not included in the args");
		}

	}
}
