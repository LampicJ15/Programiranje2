import java.util.*;

public class Tocka {
	protected Object ime;
	protected Set<Tocka> sosedi;
	
	
	
	public Tocka(Object ime) {
		this.ime = ime;
		this.sosedi = new HashSet<Tocka>();
	}


	public int stopnja() {
		return sosedi.size();  
		
	}


	@Override
	public String toString() {
		return  "" + ime;
	}
}
	