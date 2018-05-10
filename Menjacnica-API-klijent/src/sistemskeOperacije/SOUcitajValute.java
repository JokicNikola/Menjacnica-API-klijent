package sistemskeOperacije;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SOUcitajValute {
	
	public static String url = "http://free.currencyconverterapi.com/api/v3/convert?q=";
	
	public static double ucitajValute(String valutaIz, String valutaU)throws Exception{
		
		
		String sajt = url+valutaIz+ "_" +valutaU;
		
		URL obj = new URL(sajt);
		HttpURLConnection veza = (HttpURLConnection) obj.openConnection();
		veza.setRequestMethod("GET");
		
		BufferedReader r = new BufferedReader(new InputStreamReader(veza.getInputStream()));
		
		String tekst="";
		boolean dok=true;
		
		while(dok) {
			String ucitaj=r.readLine();
			if(ucitaj==null)dok=false;
			else tekst=tekst+ucitaj;
		}
		r.close();
		Gson gson = new GsonBuilder().create();
		JsonParser parse = new JsonParser();
		
		
		JsonObject konverzija = gson.fromJson(tekst, JsonObject.class);
		if(konverzija.get("count").getAsInt()!=0) {
			 double kurs=konverzija.get("val").getAsDouble();
			return kurs;
		
		}
		else 
			throw new RuntimeException("Ne postoji konvercija");
		
	}
	
	
}

