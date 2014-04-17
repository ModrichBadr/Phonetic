package com.mo.phonetic.model;

/**
 * This surname object stores the surname and the key generated for it
 * 
 * @author Badr
 * 
 */
public class Surname {

	private String surname;
	private String code;

	/**
	 * 
	 * @param name
	 * @param code
	 */
	public Surname(String surname, String code) {

		this.setSurname(surname);
		this.setCode(code);

	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
