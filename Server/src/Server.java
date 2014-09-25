import java.io.*;
import java.net.*;

public class Server {
	public static void main (String args[]) throws Exception
	{
		
		int portNumber = 2356;
		String messagesFromClient = null;
		String messagesToClient = null;
		
		//Ŭ���̾�Ʈ�� �����ϴ� ���� ����
		ServerSocket wellcomeSocket = new ServerSocket(portNumber);
		
		System.out.println("SERVER PORT NUMBER: " + portNumber);
		
		
		while(true) {
			
			
			//������ �Ǹ� connectionSocket�� new Socket �Ҵ�, ����ȵǸ� �޼ҵ�� block �Ǿ� �ִ�.
			Socket connectionSocket = wellcomeSocket.accept();
			
			//Ŭ���̾�Ʈ�� ������ �޼����� �ޱ� ���� ���� ����
			//connectionSocket�� ����� ��� �̷� ���� Ŭ���̾�Ʈ�� �Է��� �޾ƿ´�.
			BufferedReader inFromClient = new BufferedReader (new InputStreamReader(connectionSocket.getInputStream()));
			
			
			
			//Ŭ���̾�Ʈ ������ ������ �����͸� ���� ��Ʈ��, connectionSocket�� ���.
			DataOutputStream outToClient =
					new DataOutputStream(connectionSocket.getOutputStream());
			
			
			//Ŭ���̾�Ʈ�� ���� �� ���۸� �о� String ������ ����
			messagesFromClient = inFromClient.readLine();
			
			
			//Ŭ���̾�Ʈ�� ���� �� �޼����� ���
			System.out.println("FROM Clinet: " +  messagesFromClient);
			
			
			messagesToClient = messagesFromClient;
			
			System.out.println("SERVER MESSAGE to Client (ECO): " + messagesToClient);
			

			//��Ʈ���� �°� String�� 8��Ʈ�� ��ȯ�Ͽ� Ŭ���̾�Ʈ���� ���� (Ŭ�� �ʿ��� �ٽ� String���� ��ȯ)
			outToClient.writeBytes(messagesToClient);
			
			
		}
		
		
		
	}

}