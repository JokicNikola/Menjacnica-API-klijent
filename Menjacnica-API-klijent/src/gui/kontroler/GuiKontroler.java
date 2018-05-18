package gui.kontroler;

import java.awt.EventQueue;

import gui.GlavniProzor;
import klase.Menjacnica;

public class GuiKontroler {
	public static Menjacnica m = new Menjacnica();
	

	
	
	public GuiKontroler(Menjacnica menjacnica) {
		m = menjacnica;
	}


	public static Menjacnica getMenjacnica() {
		return m;
	}


	public void setMenjacnica(Menjacnica menjacnica) {
		m = menjacnica;
	}


	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor frame = new GlavniProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
