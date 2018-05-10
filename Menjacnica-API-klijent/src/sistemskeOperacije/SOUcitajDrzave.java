package sistemskeOperacije;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore.Entry;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import klase.Drzava;
public class SOUcitajDrzave {
	public static String sajt = "http://free.currencyconverterapi.com/api/v3/countries";
	
	public static ArrayList<Drzava> ucitajDrzave() throws Exception{
		
			ArrayList<Drzava> lista = new ArrayList<Drzava>();
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
			
			Gson gson= new GsonBuilder().create();
			
			JsonObject sadrzaj = gson.fromJson(tekst, JsonObject.class);
			JsonObject drzave = sadrzaj.get("results").getAsJsonObject();
			
			for (java.util.Map.Entry<String, JsonElement> entry : drzave.entrySet()) {
				Drzava drzava = gson.fromJson(entry.getValue().getAsJsonObject(), Drzava.class);
				lista.add(drzava);
			}
			
			
			
			
			
		
		return lista;
		
	}

	
}
