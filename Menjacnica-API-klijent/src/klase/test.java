package klase;

import sistemskeOperacije.SOUcitajValute;

public class test {

	public static void main(String[] args) {
		try {
			System.out.println(SOUcitajValute.ucitajValute("RSD", "EUR"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
