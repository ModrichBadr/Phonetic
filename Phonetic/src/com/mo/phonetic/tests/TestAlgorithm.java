package com.mo.phonetic.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mo.phonetic.util.Algorithm;

public class TestAlgorithm {

	// names to be tested
	private String jones;
	private String winton;
	private String mohamed;
	private String jon;
	private String aiden;
	private String carley;

	@Before
	public void generateKey() {

		// generate the keys for the names
		jones = Algorithm.generateKey("Jones");
		winton = Algorithm.generateKey("Winton");
		mohamed = Algorithm.generateKey("Mohamed");
		jon = Algorithm.generateKey("Jon");
		aiden = Algorithm.generateKey("Aiden");
		carley = Algorithm.generateKey("Carley");

	}

	/**
	 * Test for Step 1 (All non-alphabetic characters are ignored)
	 */
	@Test
	public void testNonAlphabetic() {

		String result = Algorithm.generateKey("Jones1");
		assertEquals(jones, result);

		result = Algorithm.generateKey("Jones1.");
		assertEquals(jones, result);

		result = Algorithm.generateKey("Jones1./[(*œ∑´®†¥¨^ø˚∆˙ƒç≈");
		assertEquals(jones, result);
	}

	/**
	 * test for Step (Any consecutive occurrences of equivalent letters (after
	 * discarding letters in step 3) are considered as a single occurrence)
	 */
	@Test
	public void testConsecutiveOccurrences() {

		String result = Algorithm.generateKey("JJJJones");
		assertEquals(jones, result);

		result = Algorithm.generateKey("Joooones1..");
		assertEquals(jones, result);

		result = Algorithm.generateKey("Jonesssssss");
		assertEquals(jones, result);

		result = Algorithm.generateKey("Joneeeesssssss");
		assertEquals(jones, result);
	}

	/**
	 * test for Step 2 (Word case is not significant)
	 */
	@Test
	public void testCaseSensitive() {

		String result = Algorithm.generateKey("JONES");
		assertEquals(jones, result);

		result = Algorithm.generateKey("jones");
		assertEquals(jones, result);

		result = Algorithm.generateKey("jONES");
		assertEquals(jones, result);

	}


	@Test
	public void jonesTestJonas() {

		String result = Algorithm.generateKey("Jonas");
		assertEquals(jones, result);

	}

	@Test
	public void jonesTestJohns() {

		String result = Algorithm.generateKey("Johns");
		assertEquals(jones, result);

	}

	@Test
	public void jonesTestSaunas() {

		String result = Algorithm.generateKey("Saunas");
		assertEquals(jones, result);

	}

	@Test
	public void wintonTestVan() {

		String result = Algorithm.generateKey("Van Damme");
		assertEquals(winton, result);

	}

	@Test
	public void mohamedTestAll() {

		String result = Algorithm.generateKey("Mohamad");
		assertEquals(mohamed, result);

		result = Algorithm.generateKey("Mohammad");
		assertEquals(mohamed, result);

		result = Algorithm.generateKey("Mohammed");
		assertEquals(mohamed, result);

		result = Algorithm.generateKey("Muhamad");
		assertEquals(mohamed, result);

		result = Algorithm.generateKey("Muhamet");
		assertEquals(mohamed, result);

		result = Algorithm.generateKey("Mahammud");
		assertEquals(mohamed, result);

	}

	@Test
	public void jonTestAll() {

		String result = Algorithm.generateKey("jen");
		assertEquals(jon, result);

		result = Algorithm.generateKey("jenn");
		assertEquals(jon, result);

		result = Algorithm.generateKey("jin");
		assertEquals(jon, result);

		result = Algorithm.generateKey("jinn");
		assertEquals(jon, result);

		result = Algorithm.generateKey("jyn");
		assertEquals(jon, result);

		result = Algorithm.generateKey("jynn");
		assertEquals(jon, result);

		result = Algorithm.generateKey("jonn");
		assertEquals(jon, result);

	}

	@Test
	public void aidenTestAll() {

		String result = Algorithm.generateKey("Aaden");
		assertEquals(aiden, result);

		result = Algorithm.generateKey("Adan");
		assertEquals(aiden, result);

		result = Algorithm.generateKey("Aidan");
		assertEquals(aiden, result);

		result = Algorithm.generateKey("Aden");
		assertEquals(aiden, result);

		result = Algorithm.generateKey("Aidyn");
		assertEquals(aiden, result);

		result = Algorithm.generateKey("Ayden");
		assertEquals(aiden, result);

		result = Algorithm.generateKey("Aydin");
		assertEquals(aiden, result);

	}

	@Test
	public void carleyTestAll() {

		String result = Algorithm.generateKey("Carlee");
		assertEquals(carley, result);

		result = Algorithm.generateKey("Carley");
		assertEquals(carley, result);

		result = Algorithm.generateKey("Carlie");
		assertEquals(carley, result);

		result = Algorithm.generateKey("Karlee");
		assertEquals(carley, result);

		result = Algorithm.generateKey("Karlie");
		assertEquals(carley, result);

	}

}
