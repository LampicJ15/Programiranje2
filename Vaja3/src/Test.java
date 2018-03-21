
public class Test {

	public static void main(String[] args) {
		Tocka tocka1 = new Tocka("tocka1");
		Tocka tocka2 = new Tocka("tocka2");
		Tocka tocka3 = new Tocka("tocka3");
		Tocka tocka4 = new Tocka("tocka4");
		
		
		Graf graf = new Graf();
		
		graf.dodajTocko(tocka1);
		graf.dodajTocko(tocka2);
		graf.dodajTocko(tocka3);
		graf.dodajTocko(tocka4);
		
		graf.dodajPovezavo(tocka1, tocka2);
		graf.dodajPovezavo(tocka1, tocka3);
		graf.dodajPovezavo(tocka1, tocka4);
		
		graf.dodajPovezavo(tocka2, tocka4);
		
		graf.dodajPovezavo(tocka3, tocka4);
		
//		graf.izpis();
		
		Graf poln= Graf.poln(5);
		poln.izpis();

// Majhna sprememba 
		
		
	}

}
