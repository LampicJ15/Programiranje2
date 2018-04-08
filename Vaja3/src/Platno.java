import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Platno extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
	protected Dimension velikost;
	protected Graf graf;
	
	final static int polmer = 10;
	protected int klikX;
	protected int klikY;
	
	protected int klikX2;
	protected int klikY2;
	
	
	protected Set<Tocka> oznaceneTocke;
	protected Tocka aktivnaTocka;
	
	protected Color barvaTock;
	protected Color barvaOzTock;
	protected Color barvaAkTocke;
	protected Color barvaPovezav;
	
	
	
	
	
	public Platno(int sirina, int visina){
		this.velikost = new Dimension(sirina, visina);
		this.graf = null;
		
		this.oznaceneTocke = new HashSet<Tocka>();
		this.aktivnaTocka = null;
		
		this.barvaTock = Color.black;
		this.barvaAkTocke = Color.red;
		this.barvaOzTock = Color.yellow;
		this.barvaPovezav = Color.gray;
		
		
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		
		}
	
	public Dimension getPreferredSize(){
		return velikost;
		
	}
	
	public void narisi(Graf g){
		this.graf = g;
		repaint();
	}
	
	public static int zaokrozi(double x){
		return (int)(x+0.5);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//narisemo povezave
		for (Tocka tocka: graf.tocke.values()){
			for (Tocka sosed: tocka.sosedi){
				g.drawLine(zaokrozi(tocka.x),zaokrozi(tocka.y),zaokrozi(sosed.x),zaokrozi(sosed.y));
			}
		}
		
		//narisemo tocke
		for (Tocka tocka: graf.tocke.values()){
			if (tocka == aktivnaTocka) {
				g.setColor(barvaAkTocke);
			} else if ( oznaceneTocke.contains(tocka)){
				g.setColor(barvaOzTock);
			}else {
				g.setColor(barvaTock);
			}
			g.fillOval(zaokrozi(tocka.x - polmer/2 ), zaokrozi(tocka.y - polmer/2), polmer, polmer);
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (aktivnaTocka != null) {
			aktivnaTocka.x = e.getX();
			aktivnaTocka.y = e.getY();
			repaint();
		} else {
			for (Tocka tocka: oznaceneTocke) {
				tocka.x = tocka.x + (e.getX() - klikX2);
				tocka.y = tocka.y + (e.getY() - klikY2);
			}
			klikX2 = e.getX();
			klikY2 = e.getY();
			repaint();
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		klikX = e.getX();
		klikY = e.getY();
		
		klikX2 = e.getX();
		klikY2 = e.getY();
		
		for (Tocka tocka: graf.tocke.values()) {
			double razdalja =  Math.sqrt( Math.pow(e.getX() - tocka.x, 2) + Math.pow(e.getY() - tocka.y, 2)) ; 
			 
			 if (razdalja < polmer){
				 aktivnaTocka = tocka;
				 
				 break;
			 }
		}
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (aktivnaTocka == null && klikX == e.getX() && klikY == e.getY()) {
			Tocka nova = new Tocka(System.currentTimeMillis());
			nova.x = e.getX();
			nova.y = e.getY();
			
			graf.dodajTocko(nova);
			
			for (Tocka tocka: oznaceneTocke) {
				graf.dodajPovezavo(nova, tocka);
			}
			repaint();
			
		} else if (klikX == e.getX() && klikY == e.getY()) {
			if (oznaceneTocke.contains(aktivnaTocka)) {
				oznaceneTocke.remove(aktivnaTocka);
				aktivnaTocka = null;
			}else {
				oznaceneTocke.add(aktivnaTocka);
				aktivnaTocka = null;
			}
		} else {
			aktivnaTocka = null;
		}
		repaint();

	}
}


