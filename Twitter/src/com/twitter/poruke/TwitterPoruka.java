package com.twitter.poruke;

/**
 * Predstavlja TwitterPoruku.
 * @author Thekgiga
 *@version 1.0
 */
public class TwitterPoruka {
	
	/**
	 * Predstavlja korisnika Twitter-a, koji je poslao tweet.
	 */
	private String korisnik;
	
	/**
	 * Tekst poslate poruke.
	 */
	private String poruka;
	
	/**
	 * metoda vraca ime korisnika, tj vednost atributa korisnik.
	 * @return ime korisnika kao string.
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Metoda postavlja korisnika na unetu vrednost.
	 * @param korisnik ime korisnika.
	 * @throws java.lang.RuntimeException ako je uneto ime korisnika null ili prazan string.
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik.equals(""))
			throw new RuntimeException(
					"Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * metoda vraca tekst poruke, tj vednost atributa poruka.
	 * @return tekst poruke kao String.
	 */
	public String getPoruka() {
		return poruka;
	}
	
	/**
	 * metoda postavlja poruku na unetu vrednost.
	 * @param poruka uneta vrednost poruke.
	 * @throws java.lang.RuntimeException ako je uneta vrednost poruke 
	 * <ul> 
	 * <li>null;</li>
	 * <li>duza od 140 karaktera.</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.length()>140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * metoda daje informaciju o korisniku i poruci koju je napisao.
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
	
}


