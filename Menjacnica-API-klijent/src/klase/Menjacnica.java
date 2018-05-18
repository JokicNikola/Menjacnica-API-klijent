package klase;

import java.util.ArrayList;


import sistemskeOperacije.SOUcitajDrzave;
import sistemskeOperacije.SOUcitajValute;
import sistemskeOperacije.SOUpisiJSON;

public class Menjacnica {

	
	
	public ArrayList<Drzava> ucitajDrzave() throws Exception{
		return SOUcitajDrzave.ucitajDrzave();
	}
	
	public double ucitajValute(String valutaIz, String valutaU) throws Exception{
		return SOUcitajValute.ucitajValute(valutaIz, valutaU);
}
	
	public void upisiJSON(String drzava1, String drzava2, double kurs) {
		
		SOUpisiJSON.upisiJSON(drzava1, drzava2, kurs);
	}
	
	public  double izracunaj(String valutaIz, String valutaU, double iznos) {
		try {
			return iznos*ucitajValute(valutaIz, valutaU);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	
}
