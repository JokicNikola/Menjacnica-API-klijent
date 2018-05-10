package klase;

import java.util.ArrayList;

import sistemskeOperacije.SOUcitajDrzave;
import sistemskeOperacije.SOUcitajValute;

public class Menjacnica {

	
	
	public static ArrayList<Drzava> ucitajDrzave() throws Exception{
		return SOUcitajDrzave.ucitajDrzave();
	}
	
	public static double ucitajValute(String valutaIz, String valutaU) throws Exception{
		return SOUcitajValute.ucitajValute(valutaIz, valutaU);
	}
	
}
