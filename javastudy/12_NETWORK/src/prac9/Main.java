package prac9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Main {
	
	public static void m1() {
		
		String apiURL = "http://openapi.data.go.kr/openapi/service/rest/Covid19";
		
		try {
			
			String serviceKey = "QcU2VuPP/9FzvgkNvkxpRFvzzIly2xSCTkvnE9X5mBOFZf2QyvN0DwfHh+B0ZgOmffGc5dVSJDjaBCKqtB0r1Q==";
			apiURL += "?pageNo=" + URLEncoder.encode("1", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("10", "UTF-8");
			apiURL += "&startCreateDt=" + URLEncoder.encode("20200310", "UTF-8");
			apiURL += "&endCreateDt=" + URLEncoder.encode("20200315", "UTF-8");
			apiURL += "&ServiceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
		
		} catch(UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
						
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("APT 주소 접속 실패");
		}
		
		
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			reader.close();
			
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}
		
		
		String response = sb.toString();
		
		File file = new File("c:\\storage", "api9.xml");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		//
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			System.out.println(root.getNodeName());
			
			NodeList nodeList = root.getChildNodes();
			for(int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println("  " + node.getNodeName());
				
				NodeList nodeList2 = node.getChildNodes();
				for(int j = 0; j < nodeList2.getLength(); j++) {
					Node node2 = nodeList2.item(j);
					System.out.println("    " + node2.getNodeName());
					
					if(node2.getNodeName().equals("items")) {
						NodeList items = node2.getChildNodes();
						for(int k = 0; k < items.getLength(); k++) {
							Node item = items.item(k);
							System.out.println("        " + item.getNodeName());
							
							NodeList itemChildren = item.getChildNodes();
							for(int l = 0; l < itemChildren.getLength(); l++) {
								Node itemChild = itemChildren.item(l);
								System.out.println("        " + itemChild.getNodeName() + ":" + itemChild.getTextContent());
							}
							
						}
								
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		

		
		
		
		
		con.disconnect();
		
	}

	public static void main(String[] args) {
		m1();
	}

}
