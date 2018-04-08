import java.util.*;

public class Tocka {
	protected Object ime;
	protected Set<Tocka> sosedi;
	protected double x;
	protected double y;
	
	
	
	
	
	public Tocka(Object ime) {
		this.ime = ime;
		this.sosedi = new HashSet<Tocka>();
		this.x = 0;
		this.y = 0;
	}


	public int stopnja() {
		return sosedi.size();  
		
	}


	@Override
	public String toString() {
		return  "" + ime;
	}
}
	