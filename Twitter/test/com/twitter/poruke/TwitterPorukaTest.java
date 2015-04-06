/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Thekgiga
 *
 */
public class TwitterPorukaTest {
	
	private TwitterPoruka tp;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		
		tp.setKorisnik("Mika");
		assertEquals("Mika", tp.getKorisnik());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNULL() {
		
		tp.setKorisnik(null);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikIsEmpty() {
		
		tp.setKorisnik("");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		
		tp.setPoruka(" Test tweet:) ");
		assertEquals(" Test tweet:) ", tp.getPoruka());
		
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNULL() {

		tp.setPoruka(null);
		
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaMoreThan140() {
		
		tp.setPoruka("TweetTweetTweetTweetTweetTweetTweetTweetTweetTweetTweetTweetTweetTweet"
				+ "TweetTweetTweetTweetTweetTweetTweetTweetTweetTweetTweetTweetTweetTweetTweet");	
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		
		tp.setKorisnik("Pera");
		tp.setPoruka("poruka");
		
		assertEquals("KORISNIK:Pera PORUKA:poruka",tp.toString());
	}

}
