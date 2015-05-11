package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SocketHandler extends Thread{
	private Socket socket;	
	
	public SocketHandler(Socket socket){
		this.socket = socket;  
	}
	
	public synchronized void run(){
		try {
			System.out.println("Socket begin");
			// obtém o stream de entrada e o encapsula
			DataInputStream dataInput = new DataInputStream(socket.getInputStream());
			
			// obtém o stream de saída e o encapsula
			DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());
			
			// executa alguma coisa... no caso, um eco.
			String data = dataInput.readUTF();			
			data+= " checked";
			System.out.println(data);
			dataOutput.writeUTF(data);
			
			// fecha o socket
			socket.close();
			System.out.println("Socket end");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}
}
