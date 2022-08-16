package ex04_socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			
			// ServerSocket 생성
			serverSocket = new ServerSocket();
			
			// ServerSocket의 호스트/포트번호 설정
			serverSocket.bind(new InetSocketAddress("localhost", 9099));
			
			// 접속한 클라이언트 개수
			int clientCnt = 0;
			
			// 서버는 종료 없이 무한루프
			while(true) {
				
				System.out.println("[서버] 클라이언트 접속 기다리는 중");
				
				// 클라이언트 접속 및 카운팅
				Socket clientSocket = serverSocket.accept();
				clientCnt++;
				
				// 클라이언트에게 "Welcome"메세지 전송
				// 바이트 출력 스트림 중에서 DataOutputStream은 writeUTF 메소드를 이용해서
				// 한글을 깨짐없이 보낼 수 있다.
				DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
				out.writeUTF("[서버] 게스트" + clientCnt + "님 환영합니다");
				out.close();
				
				// 클라이언트 접속 종료
				clientSocket.close();
				
				// 접속한 클라이언트가 3명이면 무한루프 종료
				if(clientCnt == 3) {
					System.out.println("[서버] 서버가 종료되었습니다.");
					serverSocket.close();
					break;
				}
				
			} // while(true)
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket.isClosed() == false) {
					System.out.println("[서버] 서버가 종료되었습니다.");
					serverSocket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

}
