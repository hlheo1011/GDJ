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
		
		// XML 파싱
		// API응답(XML) -> XML파일로 바꾸고, -> Document 파일로 XML 파일을 읽어서 만듬)
		
		// JSON 파싱
		// API응답(JSON) -> JSONObject
		// 중간에 파일 생성 과정이 필요하지 않다. 바로 JSONObject를 만들면 된다.
		
		try {
			String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000";
			
			// 기상청 파라미터를 쓰기때문에, 붙일 파라미터가 없다.
			// zone=1154551000은 금천구 가산동의 데이터임.
			// 서비스 키 또한 필요 없다.
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");	// 주소창에 파라미터 붙여서 보내는게 "GET" 이다. // 안적어줘도 GET으로 받기 때문에 안적어도 된다.
			con.setRequestProperty("Content-Type", "applicationc/xml; charset=UTF-8");	// xml이여서 타입을 지정 안해줘도 파일은 온다.
			
			// 결과 읽기
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);				
			}
			
			// 파싱 결과를 저장할 파일
			File file = new File("test.txt");
			// 경로가 없으면 프로젝트에 txt가 생긴다.		
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			// StringBuilder에 저장된 응답(XML) 데이터를 JSON으로 변경하기
			JSONObject obj = XML.toJSONObject(sb.toString());
			JSONObject rss = obj.getJSONObject("rss");
			JSONObject channel = rss.getJSONObject("channel");
			String link = channel.getString("link");
			String description = channel.getString("description");
			String generator = channel.getString("generator");
			String language = channel.getString("language");
			String title = channel.getString("title");
			String pubDate = channel.getString("pubDate");
			bw.write(pubDate + "\n");
			JSONObject item = channel.getJSONObject("item");
			String author = item.getString("author");
			String link2 = item.getString("link");
			String category = item.getString("category");
			bw.write(category + "\n");
			String title2 = item.getString("title");
			JSONObject description2 = item.getJSONObject("description");
			JSONObject body = description2.getJSONObject("body");
			JSONArray dataList = body.getJSONArray("data");
			
			// 파싱
			for(int i = 0; i < dataList.length(); i++) {
				JSONObject data = dataList.getJSONObject(i);
				int sky = data.getInt("sky");
				int temp = data.getInt("temp");
				String wfKor = data.getString("wfKor");
				int wd = data.getInt("wd");
				int hour = data.getInt("hour");
				bw.write(hour + "시, " + temp + "도, " + wfKor + "\n");
			}
			
			bw.close();
			br.close();
			con.disconnect();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// 첫번쨰줄은 pubDate
		// 두번째줄은 category
		// hour, temp, wfKor
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
