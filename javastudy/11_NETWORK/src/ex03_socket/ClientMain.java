package ex03_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientMain {

	public static void main(String[] args) {
		
		Socket clientSocket = null;
		
		try {
			
			// Socket 생성
			clientSocket = new Socket();
			
			// 접속할 Server의 InetSocketAddress 생성
			InetSocketAddress address = new InetSocketAddress("localhost", 909);
			
			// 서버에 접속
			clientSocket.connect(address);
			
			System.out.println("[클라이언트] 접속 성공");			
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( clientSocket.isClosed() == false) {
					clientSocket.close();
					System.out.println("서버 중지");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
