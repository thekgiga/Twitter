package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
* Osnovna klasa za platformu sajta Twitter.com
* @author Thekgiga
* @version 1.9
*
*/
public class Twitter {
	
	/**
	* Lista poruka koje unose korisnici.
	*/
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	* Metoda vraca sve poruke koje su korisnici uneli.
	* @return poruke koje su unete od strane korisnika
	*/
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	* Metoda unosi novu poruku, koju je napisao korisnik, u listu.
	*
	* @param korisnik Korisnik koji salje poruku
	* @param poruka Poruka koju je korisnik uneo.
	*/
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	* Metoda prolazi kroz listu poruka i sve one koje sadrze dati tag ubacuje u niz, sve do maksimalnog broja poruka koji je zadat.
	* Ova metoda zatim vraca novonastali niz poruka.
	*
	* @param maxBroj Maksimalan broj poruka koje se ubacuju u niz
	* @param tag Tag na osnovu koga se vrsi selekcija poruka koje se ubacuju u niz
	* @return vratiPoruke vraca niz poruka izdvojenih na osnovu izvrsene pretrage
	*
	* @throws java.lang.RuntimeException ako je tag 
	*
	* <ul>
	* <li>null ili </li>
	* <li>prazan String</li>
	* </ul>
	*/
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}
