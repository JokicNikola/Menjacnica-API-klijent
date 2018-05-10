package klase;

import java.util.GregorianCalendar;

public class Valuta {
	private String izValute, uValutu;
	private GregorianCalendar datum;
	private double odnos;
	public String getIzValute() {
		return izValute;
	}
	public void setIzValute(String izValute) {
		this.izValute = izValute;
	}
	public String getuValutu() {
		return uValutu;
	}
	public void setuValutu(String uValutu) {
		this.uValutu = uValutu;
	}
	public GregorianCalendar getDatum() {
		return datum;
	}
	public void setDatum(GregorianCalendar datum) {
		this.datum = datum;
	}
	public double getOdnos() {
		return odnos;
	}
	public void setOdnos(double odnos) {
		this.odnos = odnos;
	}
	
	
}
