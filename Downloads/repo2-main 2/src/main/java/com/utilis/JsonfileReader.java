package com.utilis;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.testbase.BasePage;

public class JsonfileReader extends BasePage {

	
	
	public static String[] jsonreader(String name) throws Exception {
		
		JSONParser json= new JSONParser();
		FileReader file = new FileReader(System.getProperty("user.dir")+"/src/main/java/com/resources/data.json");
		Object obj=json.parse(file);
		JSONObject jsonobject = (JSONObject)obj;
		JSONArray array=(JSONArray)jsonobject.get(name);
		String arr[]=new String[array.size()];
		for (int i=0;i<array.size();i++) {
		 user= (JSONObject)array.get(i);
			 
		}
		
		
		
		return arr;
		
	}
}
