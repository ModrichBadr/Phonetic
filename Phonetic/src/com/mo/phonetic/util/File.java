package com.mo.phonetic.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.mo.phonetic.model.Surname;

/**
 * 
 * @author Badr
 * 
 */
public class File {

	/**
	 * This method reads all the surnames in the specified file and generates a
	 * key for each
	 * 
	 * @param file_name
	 * @return list of surnames objects, each object contains the surname and
	 *         the key generated for it.
	 */
	public static ArrayList<Surname> readFileGenerateKey(String file_name) {
		ArrayList<Surname> surnames = new ArrayList<Surname>();
		try (BufferedReader br = new BufferedReader(new FileReader(file_name))) {

			String line = null;
			line = br.readLine();

			while (line != null) {
				// generate key for surname
				String code = Algorithm.generateKey(line);
				// new surname and key
				Surname sur = new Surname(line, code);
				surnames.add(sur);
				// next line
				line = br.readLine();
			}

		} catch (IOException e1) {

			e1.printStackTrace();
		}
		// Java 7 will use auto close features no need to close
		// bufferReader which would usually be done in the finally clause

		return surnames;

	}
}