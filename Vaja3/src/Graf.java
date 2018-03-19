import java.util.HashMap;
import java.util.Map;

public class Graf {
	
	protected Map<Object, Tocka>tocke;
	
	/*
	 * Konstruktor, ki sestavi graf brez tock
	 */

	public Graf() {
		super();
		this.tocke = new HashMap<Object, Tocka>();
	}
	
	//Metoda, ki vrne tocko z danim imenom
	
	public Tocka tocka(Object ime) {
		return tocke.get(ime);
	}
	
	//Metoda povezava preveri, �e obstaja povezava med tocko1 in tocko2
	
	public boolean povezava(Tocka tocka1, Tocka tocka2) {
		return (tocka1.sosedi.contains(tocka2));
	}
	
	//Metoda dodajTocko doda to�kografu, �e to�ke s takim imenom �e ni v grafu
	public void dodajTocko(Tocka point) {
		if (!tocke.containsKey(point)) {
			tocke.put(point.ime, point);
		}
	
	}
	
	//metoda dodajPovezavo, grafu doda povezavo med dvema tockama (ce sta razlicni in se nista povezani)
	public void dodajPovezavo(Tocka tocka1, Tocka tocka2) {
		if ((tocka1 != tocka2) && !povezava(tocka1, tocka2)) {
			tocka1.sosedi.add(tocka2);
			tocka2.sosedi.add(tocka1);
			
			tocke.put(tocka1.ime, tocka1);
			tocke.put(tocka2.ime, tocka2);
		}
	}
	
	//metoda odstraniPovezavo iz grafa odstrani povezavo med danima tockama	
	public void odstraniPovezavo(Tocka tocka1, Tocka tocka2) {
		if(povezava(tocka1, tocka2)) {
			tocka1.sosedi.remove(tocka2);
			tocka2.sosedi.remove(tocka1);
		}
	}
	
	//metoda odstraniTocko odstrani to�ko iz grafa
	public void odstraniTocko(Tocka tocka1) {
		for (Object imeTocke : tocke.keySet()) {
			Tocka tocka2 = tocke.get(imeTocke); //tocko2 pokli�emo iz slovarja da dobimo objekt 
			if ( tocka1.sosedi.contains(tocka2)) {
				tocka2.sosedi.remove(tocka1);
			}
		}
		tocke.remove(tocka1.ime, tocka1);
	}
	
	//metoda prazen vrne prazen graf z n to�kami
	//za imena to�k so uporabljeni stringi
	
//	public static Graf prazen(int n) {
//		Graf g = new Graf();
//		final int RADIX = 10;
//		for (int i = 1; i <= n; i += 1) {
//			char ch = Character.forDigit(i, RADIX); // spremenimo i v tip char
//			String ime = "tocka" + ch;
//			Tocka novaTocka = new Tocka(ime);
//			g.dodajTocko(novaTocka);
//		}
//		return g;
//	}
	
//	pri tej metodi prazen pa sem za imena tock uporabil stevilke
	
	public static Graf prazen(int n) {
		Graf graf = new Graf();
		
		for(int i=1; i<=n; i+=1) {
			Tocka novaTocka = new Tocka(i);
			graf.dodajTocko(novaTocka);
		}
		return(graf);
	}
	
//	metoda cikel vrne ciklicni graf na n tockah

	public static Graf cikel(int n) {
		Graf ciklGraf = prazen(n);
		ciklGraf.dodajPovezavo(ciklGraf.tocka(1), ciklGraf.tocka(n));
		
		for (int i = 2; i <= n; i++) {
			ciklGraf.dodajPovezavo(ciklGraf.tocka(i), ciklGraf.tocka(i-1));
		}
		
		return(ciklGraf);
		
		
		
		}
		
	}
	
	
	
