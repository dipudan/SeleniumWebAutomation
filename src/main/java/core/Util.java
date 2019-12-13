package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

//import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import jodd.props.Props;

public class Util {

	//static Logger log = Logger.getLogger(Util.class.getName());
	
	public static String getConfigPropertyAsString(String strPropertyName) {
		Props p = new Props();
		File configFile = new File("src\\main\\resources\\config.properties");
		try {
			p.load(new File(configFile.getAbsolutePath()));
		}
		catch(Exception e) {
			//log.error("Error while accessing config.properties");
			e.printStackTrace();
		}		
		return p.getValue(strPropertyName);	
	}

	public static Integer getConfigPropertyAsInt(String strPropertyName) {
		Props p = new Props();
		File configFile = new File("src\\main\\resources\\config.properties");
		try {
			p.load(new File(configFile.getAbsolutePath()));
		}
		catch(Exception e) {
			//log.error("Error while accessing config.properties");
			e.printStackTrace();
		}
		return p.getIntegerValue(strPropertyName);
	}
	
	public static String getJsonData(String strPropertyName,String strFileName) {
		String jsonData = readFile("src\\main\\resources\\data\\"+strFileName);		
		try {
			JSONObject jObj= new JSONObject(jsonData);
			return(jObj.get(strPropertyName).toString());
		} catch (JSONException e) {
			//log.error("Error while accessing json file.");
		}
		return "";
	}
	
	private static String readFile(String filename) {
		String result ="";		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line !=null) {
				sb.append(line);
				line=br.readLine();
			}
			result = sb.toString();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;		
	}
}
