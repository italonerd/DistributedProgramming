package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SimpleThreadSocketClient extends Thread{
	
	private String address;
	private int port;
	private String message;
	
	public SimpleThreadSocketClient(String address, int port, String message){
		this.address = address;
		this.port = port;
		this.message = message;  
	}
	
	public void run(){
		try {
			Socket socket = new Socket(address, port);
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
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}
	public static void main(String[] args) {
		SimpleThreadSocketClient socket1 = new SimpleThreadSocketClient("localhost", 9999, "Message1 ");
		socket1.start();
		SimpleThreadSocketClient socket2 = new SimpleThreadSocketClient("localhost", 9999, "Message2 ");
		socket2.start();
		SimpleThreadSocketClient socket3 = new SimpleThreadSocketClient("localhost", 9999, "Message3 ");
		socket3.start();
		SimpleThreadSocketClient socket4 = new SimpleThreadSocketClient("localhost", 9999, "Message4 ");
		socket4.start();
		SimpleThreadSocketClient socket5 = new SimpleThreadSocketClient("localhost", 9999, "Message5 ");
		socket5.start();
	}
}
