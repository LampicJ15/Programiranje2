
public class Collatz {

	public static void main(String[] args) {
		float [][] c = {{1,2,3},{4,5,6}};
		float [][] b = {{1,2,3},{4,5,6}};
		b = MnozenjeMatrik.transponiraj(b);
		float [][] matrika = MnozenjeMatrik.zmnozi(c,b);
		
		
		for (int i=0; i< matrika.length; i++) {
			for(int j=0; j< matrika[i].length; j++) {
				System.out.print(matrika[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
		
	}
	/*
	 * funckija naslednji clen vrne naslednje stevilo v Collatzovem zaporedja
	 */
	public static int naslednjiClen(int n) {
		if(n == 1) {
			return(1);
		}else {
			if(n % 2== 0) {
				return(n/2);
			}else {
				return(3*n +1);
			}
		}
	}
	
	/*
	 * funkcija dolzina vrne dolzino Collatzovega zaporedja, ki se zacne 
	 * s stevilom n
	 */
	public static int dolzina(int n) {
		int dolzina = 1;
		
		while(n != 1) {
			n = naslednjiClen(n);
			dolzina = dolzina + 1;
		}
		return(dolzina);
		
	}
	
	/*
	 * funkcija najvecji clen vrne najve�ji �len v Collatzovem zaporedju,
	 * ki se za�ne s stevilom n
	 */
	
	public static int najvecjiClen(int n) {
		int M = n; //shranjujemo najvecji clen
		
		while(n != 1) {
			n = naslednjiClen(n);
			M = Math.max(M, n);
		}
		return(M);
	}
	
	/*
	 *  funkcija collatz izpise vse clene Collatzovega zaporedja,
	 *  ki se zacnjejo s stevilom n
	 */
	
	public static void collatz(int n) {
		System.out.println(n);
		while(n != 1) {
			n = naslednjiClen(n);
			System.out.println(n);
		}
		
	}

}
