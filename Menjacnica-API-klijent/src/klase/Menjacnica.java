package klase;

import java.util.ArrayList;

import sistemskeOperacije.SOUcitajDrzave;
import sistemskeOperacije.SOUcitajValute;

public class Menjacnica {

	
	
	public ArrayList<Drzava> ucitajDrzave() throws Exception{
		return SOUcitajDrzave.ucitajDrzave();
	}
	
	public double ucitajValute(String valutaIz, String valutaU) throws Exception{
		return SOUcitajValute.ucitajValute(valutaIz, valutaU);
}
	
}
