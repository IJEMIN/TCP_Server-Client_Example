import java.io.*;
import java.net.*;
class TCPClient {
	
	
	public static void main(String argv[]) throws Exception
	
	{
		
		String clientMessage; String serverMessage;
		
		
		while(true)
		{
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			
			
			Socket clientSocket = new Socket("localhost",2500);

			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			
			
			BufferedReader inFromServer =
					new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			
			clientMessage = inFromUser.readLine();
			
			
			outToServer.writeBytes(clientMessage + '\n');
			
			
			
			serverMessage = inFromServer.readLine();
			
			
			System.out.println("FROM SERVER: " + serverMessage);
			
			clientSocket.close();
			
		}
		
		

	}
}