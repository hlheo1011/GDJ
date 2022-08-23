package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ApiMain {

	public static void main(String[] args) {
	
		/*
		StringBuilder urlBuilder = new StringBuilder();
		try {
			String serviceKey = "QcU2VuPP/9FzvgkNvkxpRFvzzIly2xSCTkvnE9X5mBOFZf2QyvN0DwfHh+B0ZgOmffGc5dVSJDjaBCKqtB0r1Q==";
			urlBuilder.append("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
			//urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey), "UTF-8"));
			urlBuilder.append("&searchYear=2021");
			urlBuilder.append("&siDo=1100");
			urlBuilder.append("&guGun=1125");
			urlBuilder.append("&type=json");
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&pageNo=1");
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HttpURLConnection con = null;
		try {
			URL url = new URL(urlBuilder.toString());
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");			
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = null;
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				
			}
		} catch
		*/

	}
	
}