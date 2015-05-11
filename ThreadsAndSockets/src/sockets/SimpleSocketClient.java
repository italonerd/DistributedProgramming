package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleSocketClient {

	public static void main(String[] args) {
			int port = 9999;
			String adress= "localhost";
			String message = "Message";
			int nTimes = 4;
			
			for (int i = 0; i < nTimes; i++) {
				try {					
					createSocket(adress,port,message);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
	}
	
	public static void createSocket(String adress, int port, String message) throws Exception{
			Socket socket = new Socket(adress, port);
			System.out.println("Socket aberto");
			
			if (socket.isConnected()) {
				// obtém o stream de saída e o encapsula
				DataOutputStream dataOutput = new DataOutputStream( socket.getOutputStream());

				// obtém o stream de entrada e o encapsula
				DataInputStream dataInput = new DataInputStream(socket.getInputStream());
				
				
				// executa alguma coisa... no caso, envia uma mensagem
				// e espera resposta.
				dataOutput.writeUTF(message);
				String response = dataInput.readUTF();
				
				System.out.println(response);
			}			
			
			System.out.println("Socket fechado");
			// fecha o socket
			socket.close();
	}

}
