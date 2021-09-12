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

	/**
	 * Retrieve the property value of the parameter from the config.properties file
	 * and return as string.
	 * @param propertyName : Parameter whose value is to be fetched.
	 * @return value of property as string.
	 */
	public static String getConfigPropertyAsString(String propertyName) {
		Props p = new Props();
		File configFile = new File("src\\test\\resources\\config.properties");
		try {
			p.load(new File(configFile.getAbsolutePath()));
		}
		catch(Exception e) {
			//log.error("Error while accessing config.properties");
			e.printStackTrace();
		}		
		return p.getValue(propertyName);
	}

	/**
	 * Retrieve the propertyName value of the parameter from the config.properties file
	 * and return as string.
	 * @param propertyName : Parameter whose value is to be fetched.
	 * @return value of propertyName as string.
	 */
	public static Integer getConfigPropertyAsInt(String propertyName) {
		Props p = new Props();
		File configFile = new File("src\\test\\resources\\config.properties");
		try {
			p.load(new File(configFile.getAbsolutePath()));
		}
		catch(Exception e) {
			//log.error("Error while accessing config.properties");
			e.printStackTrace();
		}
		return p.getIntegerValue(propertyName);
	}

	/**
	 * Retrieve the test data from json file 'fileName', saved in the node 'propertyName'.
	 * @param propertyName : The node whose value is to be retrieved from json.
	 * @param fileName : Testdata json from which the data is to be taken.
	 * @return Json file as string.
	 */
	public static String getJsonData(String propertyName,String fileName) {
		String jsonData = readFile(Util.getConfigPropertyAsString("jsonFile")+fileName);
		try {
			JSONObject jObj= new JSONObject(jsonData);
			return(jObj.get(propertyName).toString());
		} catch (JSONException e) {
			//log.error("Error while accessing json file.");
		}
		return "";
	}

	/**
	 * Reading the file content and return as a string.
	 * @param filename : File for reading the data.
	 * @return result : The file content as string.
	 */
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
