package sistemskeOperacije;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class SOUpisiJSON {

	public static void upisiJSON(String drzava1, String drzava2, double kurs) {
		
		JsonObject j = new JsonObject();
		GregorianCalendar d = new GregorianCalendar();
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS"); 
		String datum2 = dt.format(d.getTime());
		j.addProperty("datumVreme", datum2);
		j.addProperty("izValute", drzava1);
		j.addProperty("uValutu", drzava2);
		j.addProperty("kurs", kurs);
		try (FileWriter writer = new FileWriter("data/log.json")) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(j,writer);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} 
	
}
