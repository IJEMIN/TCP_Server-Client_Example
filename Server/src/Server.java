import java.io.*;
import java.net.*;

public class Server {
	public static void main (String args[]) throws Exception
	{
		
		int portNumber = 2356;
		String messagesFromClient = null;
		String messagesToClient = null;
		
		//클라이언트가 접속하는 소켓 생성
		ServerSocket wellcomeSocket = new ServerSocket(portNumber);
		
		System.out.println("SERVER PORT NUMBER: " + portNumber);
		
		
		while(true) {
			
			
			//연결이 되면 connectionSocket에 new Socket 할당, 연결안되면 메소드는 block 되어 있다.
			Socket connectionSocket = wellcomeSocket.accept();
			
			//클라이언트로 부터의 메세지를 받기 위한 버퍼 리더
			//connectionSocket이 연결된 경우 이로 부터 클라이언트의 입력을 받아온다.
			BufferedReader inFromClient = new BufferedReader (new InputStreamReader(connectionSocket.getInputStream()));
			
			
			
			//클라이언트 쪽으로 내보낼 데이터를 담을 스트림, connectionSocket을 사용.
			DataOutputStream outToClient =
					new DataOutputStream(connectionSocket.getOutputStream());
			
			
			//클라이언트로 부터 온 버퍼를 읽어 String 변수에 저장
			messagesFromClient = inFromClient.readLine();
			
			
			//클라이언트로 부터 온 메세지를 출력
			System.out.println("FROM Clinet: " +  messagesFromClient);
			
			
			messagesToClient = messagesFromClient;
			
			System.out.println("SERVER MESSAGE to Client (ECO): " + messagesToClient);
			

			//스트림에 맞게 String을 8비트로 변환하여 클라이언트에게 보냄 (클라 쪽에서 다시 String으로 변환)
			outToClient.writeBytes(messagesToClient);
			
			
		}
		
		
		
	}

}
