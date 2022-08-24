package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class Main {

	public static void main(String[] args) {
		
		try {
			String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000";

			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "applicationc/xml; charset=UTF-8");
			
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);				
			}

			File file = new File("test.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			JSONObject channel = XML.toJSONObject(sb.toString())
									.getJSONObject("rss")
									.getJSONObject("channel");
			

			String pubDate = channel.getString("pubDate");
			bw.write(pubDate + "\n");
			
			JSONObject item = channel.getJSONObject("item");
			
			String category = item.getString("category");
			bw.write(category + "\n");

			JSONObject description2 = item.getJSONObject("description");
			JSONObject body = description2.getJSONObject("body");
			JSONArray dataList = body.getJSONArray("data");
			
			for(int i = 0; i < dataList.length(); i++) {
				JSONObject data = dataList.getJSONObject(i);
				int temp = data.getInt("temp");
				String wfKor = data.getString("wfKor");
				int hour = data.getInt("hour");
				bw.write(hour + "시, " + temp + "도, " + wfKor + "\n");
			}
			
			bw.close();
			br.close();
			con.disconnect();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
				
		
	}

}
