
public class PoudarjanjeZnakov {
	
	/*
	 * funkicja poudari prejme niz in vrne nov poudarjen niz, 
	 * v katerem so vsi znaki loèeni z dodatnim presledkom, 
	 * vse male èrke pa predelane v velike
	 */
	
	public static String poudari(String niz) {
		niz = niz.toUpperCase();
		String novNiz = "";
		int dolzina = niz.length(); //dolzina prvotnega niza
		
		for (int i=0; i < dolzina - 1; i +=1) {
			novNiz = novNiz + niz.charAt(i) + " "; 
		}
		
		novNiz = novNiz + niz.charAt(dolzina-1);
		
		return(novNiz);
		
	}
	
	/*
	 * funkcija poudarek sprejme niz in vrne niz, ki ima poudarejene besede
	 * znotraj zvedzic *....*
	 */
	public static String poudarek(String niz) {
		String novNiz = "";
		
		int dolzina = niz.length();
		boolean poudarek = false;
		
		for (int i=0; i < dolzina; i += 1) {
			if (niz.charAt(i) == '*') {
				poudarek = !poudarek;
			}else {
				if(poudarek == true) {
					char znak = niz.charAt(i);
					novNiz = novNiz + Character.toUpperCase(znak);
				}else {
					novNiz = novNiz +niz.charAt(i);
				}
			}
			
			
		}
		
		return(novNiz);
	}

}
