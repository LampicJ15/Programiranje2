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
	
	//Metoda povezava preveri, èe obstaja povezava med tocko1 in tocko2
	
	public boolean povezava(Tocka tocka1, Tocka tocka2) {
		return (tocka1.sosedi.contains(tocka2));
	}
	
	//Metoda dodajTocko doda toèkografu, èe toèke s takim imenom še ni v grafu
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
	
	//metoda odstraniTocko odstrani toèko iz grafa
	public void odstraniTocko(Tocka tocka1) {
		for (Object imeTocke : tocke.keySet()) {
			Tocka tocka2 = tocke.get(imeTocke); //tocko2 poklièemo iz slovarja da dobimo objekt 
			if ( tocka1.sosedi.contains(tocka2)) {
				tocka2.sosedi.remove(tocka1);
			}
		}
		tocke.remove(tocka1.ime, tocka1);
	}
	
	
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
	
	//metoda poln, vrne poln graf na n toèkah
	public static Graf poln(int n){
		Graf graf = prazen(n);
		
		for (int i=1; i <= n; i++) {			
			for(int j=1; j<= n; j++) {
				graf.dodajPovezavo(graf.tocka(i), graf.tocka(j));
				}
		}
		return(graf);
	}
	
	// metoda polndvodelen vrne poln dvodelen graf na n+m tockah
	public static Graf polnDvodelen(int n, int m) {
		Graf graf = prazen(n+m);
		for (int i=1; i <= n; i++) {
			for (int j  = n+1; j <= m+n; j++) {
				graf.povezava(graf.tocka(i), graf.tocka(j));
			}
			
		}
		return graf;
		
	}
	
	public void izpis() {
		for (Object ime: this.tocke.keySet()) {
			Tocka tocka = this.tocka(ime);
			String sosedi = "";
			
			for (Tocka sosed: tocka.sosedi) {
				sosedi += " "+sosed.toString();
			}
			System.out.println("Tocka:" + tocka +", njene sosedne tocke: " + sosedi );
		}
		}
	
	
	
	/*
	 * metoda razporedi tocke grafa enakomerno na kroznico s polmeron r
	 * in srediscem v (cx,cy)
	 */
	public void razporedi(double cx, double cy, double r){
		int stTock = tocke.size(); //stevilo tock
		double kot = (2*Math.PI)/ stTock; //kot ko dodajamo tocke
		int i = 0;
		
		for (Tocka tocka: this.tocke.values()){
			tocka.x = cx + r * Math.cos(kot * i);
			tocka.y = cy + r * Math.sin(kot * i);
			i += 1;
			}
			
		}
		
	
}

	
