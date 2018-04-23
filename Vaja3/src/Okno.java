import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class Okno extends JFrame implements ActionListener {
	protected Platno platno;
	
	JMenuBar mb = new JMenuBar();
	JMenu graf = new JMenu("Nastavitve grafa");
	JMenu datoteka = new JMenu("Uvoz/Izvoz");
	JMenu barva = new JMenu("Barva");
	
	JMenuItem poln = new JMenuItem("Poln");
	JMenuItem prazen = new JMenuItem("Prazen");
	JMenuItem cikel = new JMenuItem("Cikel");
	
	JMenuItem barvaTock = new JMenuItem("Barva toèk");
	JMenuItem barvaPovezav = new JMenuItem("Barva povezav");

	JMenuItem uvoz = new JMenuItem("Uvoz grafa");
	JMenuItem izvoz = new JMenuItem("Izvoz grafa");
	
	
	
	
	public Okno(String naslov){
		this.setTitle(naslov);
		this.platno = new Platno(600,600);
		add(platno);
		
		poln.addActionListener(this);
		prazen.addActionListener(this);
		cikel.addActionListener(this);
		
		barvaTock.addActionListener(this);
		barvaPovezav.addActionListener(this);
		
		
		uvoz.addActionListener(this);
		izvoz.addActionListener(this);
		
	
		datoteka.add(uvoz);
		datoteka.add(izvoz);
		
		graf.add(cikel);
		graf.add(prazen);
		graf.add(poln);
		
		barva.add(barvaPovezav);
		barva.add(barvaTock);
		
		mb.add(datoteka);
		mb.add(graf);
		mb.add(barva);
		setJMenuBar(mb);
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == cikel) {
			String n = JOptionPane.showInputDialog("Vnesi število toèk");
			Graf graf = Graf.cikel(Integer.parseInt(n));
			graf.razporedi(300, 300, 300);
			
			platno.narisi(graf);
		}
		
		if (event.getSource() == poln) {
			String n = JOptionPane.showInputDialog("Vnesi število toèk");
			Graf graf = Graf.poln(Integer.parseInt(n));
			graf.razporedi(300, 300, 300);
			platno.narisi(graf);
			
		}
		
		if (event.getSource() == prazen) {
			String n = JOptionPane.showInputDialog("Vnesi število toèk");
			Graf graf = Graf.prazen(Integer.parseInt(n));
			graf.razporedi(300, 300, 300);
			
			platno.narisi(graf);
		}
		
		if (event.getSource() == barvaTock) {
			Color barva = JColorChooser.showDialog(this, "Izberi barvo toèk", platno.barvaTock);
			platno.barvaTock = barva;
			platno.narisi(platno.graf);
		}
		
		if (event.getSource() == barvaPovezav) {
			Color barva = JColorChooser.showDialog(this, "Izberi barvo povezav", platno.barvaPovezav);
			platno.barvaPovezav = barva;
			platno.narisi(platno.graf);
		}
		
		//uvoz datotek
		
		if (event.getSource() == uvoz) {
			JFileChooser fc = new JFileChooser();
			int option = fc.showOpenDialog(this);
			
			if (option == JFileChooser.APPROVE_OPTION) {
				String ime = fc.getSelectedFile().getPath();
				
				
								
			}
		
		}
		
		//izvoz datotek oz. grafa
		if (event.getSource() == izvoz) {
			JFileChooser fc = new JFileChooser();
			int option = fc.showSaveDialog(this);
			
			if (option == JFileChooser.APPROVE_OPTION) {
				String ime = fc.getSelectedFile().getPath();
	
				
				
								
			}
		
		}
		
		
		

		
	}
	

}