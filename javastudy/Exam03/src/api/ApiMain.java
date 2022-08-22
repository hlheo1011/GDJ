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
		

		String serviceKey = "QcU2VuPP/9FzvgkNvkxpRFvzzIly2xSCTkvnE9X5mBOFZf2QyvN0DwfHh+B0ZgOmffGc5dVSJDjaBCKqtB0r1Q==";
		
		try {
			serviceKey = URLEncoder.encode(serviceKey, "UTF-8");
			
		} catch(UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩 실패", e);
		}
		
		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath";
		String response = getResponse(apiURL);
		createFile(response);
			
	}
	
	public static String getResponse(String apiURL) {
		
		HttpURLConnection con = getConnection(apiURL);		
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				return readBody(con.getInputStream());
			} else {
				return readBody(con.getErrorStream());
			} 
		} catch(IOException e) {
			throw new RuntimeException("API 요청 오류", e);
		}
	}
	
	
	public static HttpURLConnection getConnection(String apiURL) {
		try {
			URL url = new URL(apiURL);
			return(HttpURLConnection)url.openConnection();
		} catch(MalformedURLException e) {
			throw new RuntimeException("API 주소 오류", e);
		} catch(IOException e) {
			throw new RuntimeException("API 연결 오류", e);
		}
	}
	
	public static String readBody(InputStream in) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch(IOException e) {
			throw new RuntimeException("API 응답 오류", e);
		}
	}

	
	public static void createFile(String response) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\storage\\accident.txt"))) {
			List<String> list = new ArrayList<>();
			Accident accident = new Accident();
			list.add(response);
			bw.write(response);
			bw.flush();
			System.out.println(response);
			
		} catch(IOException e) {
			throw new RuntimeException("파일 생성 오류", e);
		}

	}
	
	
	
}