/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test klasa, klase Twitter
 * 
 * @author Thekgiga
 * 
 */
public class TwitterTest {

	Twitter tweet;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tweet = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tweet = null;
	}

	/**
	 * Test method for
	 * {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {

		tweet.unesi("Mika", "žvaka");

		assertEquals(1, tweet.vratiSvePoruke().size());
		assertEquals("Mika", tweet.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("žvaka", tweet.vratiSvePoruke().get(0).getPoruka());

		// Testiranjem je utvrdjeno da u klasi Twitter, metodi Unesi, postoji
		// greska kod linije tp.setKorisnik("korisnik");
		// potrebno je obrisati znake navoda.

	}

	/**
	 * Test method for
	 * {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagIsEmpty() {
		tweet.vratiPoruke(10, "");

	}

	/**
	 * Test method for
	 * {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagIsNull() {
		tweet.vratiPoruke(10, null);

	}

	/**
	 * Test method for
	 * {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPorukeArrayLength() {
		assertEquals(10, tweet.vratiPoruke(10, "tagic").length);
	}

	/**
	 * Test method for
	 * {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPorukeArrayLengthLessThenZero() {
		assertEquals(100, tweet.vratiPoruke(-5, "tagic").length);
	}

	/**
	 * Test method for
	 * {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {

		tweet.unesi("Mika", "žvaka");

		assertEquals("žvaka", tweet.vratiPoruke(10, "žvaka")[0].getPoruka());
		// Test metoda pokazuje da postoji NullPointerException sto znaci da
		// twitter.vratiPoruke(10, "žvaka")[0].getPoruka()
		// je null, a na osnovu toga mozemo zakljuciti da se poruke ne unose u
		// niz na mesto na koje treba da se unose.
	}

	/**
	 * Test method for
	 * {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke2() {
		tweet.unesi("Pera","fox");
		assertEquals("fox",tweet.vratiPoruke(10,"fox")[1].getPoruka());
		
		// Iz ove test metode vidimo da je poruka za pronadjen tag na drugom mestu u
		// nizu(indeks 1),
		// sto znaci da se u pomocni niz ne unosi na prvo mesto pa je to greska
		// koju treba ispraviti.
	}

}
