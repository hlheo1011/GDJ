package prac2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {

	// Server : 스레드
	// Client : 스레드
	// Server 하나 당 Client 하나 담당
	
	// 생성된 Server 목록
	public static List<Server> servers = new ArrayList<>();
	
	// 모든 Server에 메시지 전송
	public static void sendMessage(String message) throws IOException {
		/* 일반 for문
		for(int i = 0, length = servers.size(); i < length; i++) {
		servers.get(i).sendMessage(message);
		}
		
		향상 for문 */
		for(Server server : servers) {
			server.sendMessage(message);
		}
	}
	
	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket client = null;
		
		try {
			
			server = new ServerSocket();
			server.bind(new InetSocketAddress("localhost", 9090));
			System.out.println("😧😧🤯🤯🙀🙀🦥🦥 채팅 서버 오픈 🦥🦥🙀🙀🤯🤯😧😧");
			
			while(true) {
				
				client = server.accept();	// 서버가 접속을 허용하면 클라이언트 정보가 넘어 온다.
				
				Server s = new Server(client);
				servers.add(s);
				
				System.out.println("현재 접속 중인 클라이언트" + servers.size() + "명");		
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(server.isClosed() == false) {
					server.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
