package com.gdu.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiSearchBook {
	
	public static void main(String[] args) {
		
		String clientId = "luiB6A4n2eXDEubyWuRA";
		String clientSecret = "E2983l6y80";
		
		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.print("검색어를 입력하세요 >>> ");
			String beforeSearch = sc.next();
			String search = URLEncoder.encode(beforeSearch, "UTF-8");
			
			String apiURL = "https://openapi.naver.com/v1/search/book?query=" + search;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client_Id", clientId);
			con.setRequestProperty("X-Naver-Client_Secret", clientSecret);
			BufferedReader br = null;
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			sc.close();
			con.disconnect();
			
			JSONObject obj = new JSONObject(sb.toString());
			JSONArray results = obj.getJSONArray("results");
			
			
			File dir = new File("C:\\download");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			
			File file = new File(dir, search + ".html");
			PrintWriter out = new PrintWriter(file);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"?UTF-8\">");
			out.println("<title>검색 결과</tilte>");
			out.println("</head>");
			out.println("<body>");
			
            for(int i = 0; i < results.length(); i++) {
            	
                JSONObject result = results.getJSONObject(i);
                String title = result.getString("title");
                String link = result.getString("link");
                String image = result.getString("image");
                
                
                
                out.print("<a href='" + link + "'>" + title + "</a>");
                out.print("<br>");
                out.print("<img alt = \"오류\" src = \"" + image + "\" height=\"150px\">");
                out.print("<hr>");
                
             }
			
			out.println("</body>");
			out.println("</html>");
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				
				Date date = new Date(System.currentTimeMillis());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a h:mm:ss");
				String now = sdf.format(date);
				
				File dir = new File("C:\\download\\log");
				if(dir.exists() == false) {
					dir.mkdirs();
				}
				
				File file = new File(dir, "error_log.txt");
				PrintWriter out = new PrintWriter(file);
				out.println("예외메시지        " + e.getMessage());
				out.println("예외발생시간	" + now);
				out.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		
	}

}
