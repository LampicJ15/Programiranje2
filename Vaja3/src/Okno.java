import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Okno extends JFrame {
	protected Platno platno;
	
	public Okno(String naslov){
		this.setTitle(naslov);
		this.platno = new Platno(600,600);
		add(platno);
		
	}
	

}