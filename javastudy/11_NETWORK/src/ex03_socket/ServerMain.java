package ex03_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {


		// SeverSocket
		// 클라이언트와 통신할 때 사용하는 클래스
	
		// InetSocketAddress
		// Socket 사용 시
	
		// Socket
		// 클라이언트가 서버와 통신할 때 사용하는 클래스
		
		
	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		
		try {
			
			// ServerSocket 생성 
			serverSocket = new ServerSocket();
			
			// InetSocketAddress 생성
			InetSocketAddress address = new InetSocketAddress("localhost", 909);
			
			// ServerSocket에 InetSocketAddress 연결
			serverSocket.bind(address);
			
			// serverSocket는 무한루프로 구현
			while(true) {
				
				System.out.println("[서버] 클라이언트 접속을 기다리는 중");
				Socket client = serverSocket.accept();
				InetSocketAddress clientAddress = (InetSocketAddress)client.getRemoteSocketAddress();
				System.out.println("접속이 허용된 클라이언트 : " + clientAddress.getHostName());
			}	
			
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
