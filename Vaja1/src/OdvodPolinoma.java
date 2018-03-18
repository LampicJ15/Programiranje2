
public class OdvodPolinoma {
	
	/*
	 * funkcija prvi odvod prejme seznam koeficientov polinoma in ga odvaja
	 */
	
	public static float[] prviOdvod(float[] polinom) {
		float[] odvajan = new float[polinom.length-1]; //pripravimo tabelo za odvajan polinom
		
		for(int j=1; j < polinom.length; j += 1) {
			odvajan[j-1] = polinom[j] * j;
		}
		
		return(odvajan);
	}

}
