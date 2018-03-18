
public class MnozenjeMatrik {
	
	/*
	 * Funkcija skalarniProdukt vrne skalarni produkt dveh vektorejv/seznamov
	 */
	
	public static float skalarniProdukt(float[] v1, float[] v2) {
		float vsota = 0;
		
		for(int i=0; i < v1.length; i+=1) {
			vsota += v1[i] * v2[i];
		}
		
		return(vsota);
	}
	
	/*
	 * funkcija transponiraj prejeme matriko in jo transponira
	 */
	
	public static float[][] transponiraj(float[][] matrika) {
		int i = matrika.length; //število vrstic
		int j = matrika[0].length; //število stolpcev
		
		float [][] trMatrika = new float[j][i];
		
		for (int x=0; x < i;x+=1){
			for(int y=0; y<j; y+=1) {
				trMatrika[y][x] = matrika[x][y];
			}
		}
		
		return(trMatrika);
		
	}
	
	/*
	 * funkcija zmnozi - prejme dve matriki in jih zmnozi
	 * 
	 */
	
	public static float[][] zmnozi(float [][] matrika1, float[][] matrika2){
		float [][] trMatrika = transponiraj(matrika2);
		float [][] novaMatrika = new float [matrika1.length][matrika2[0].length]; //nastavimo novo matriko
		
		for (int i=0; i < matrika1.length; i+=1) {
			for(int j = 0; j<matrika2[0].length; j+=1) {
				novaMatrika[i][j] = skalarniProdukt(matrika1[i],trMatrika[j]);
			}		
			
		}
		return(novaMatrika);
		
		
		
	}



}
