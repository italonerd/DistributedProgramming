package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketServer {
	public static void main(String[] args) {		
		try {
			int port = 9999;
			int backlog = 2;
			int socketlimit = 3;
			int count = 0;
			
			ServerSocket serverSocket = new ServerSocket(port, backlog);
			System.out.println("Server "+port+" started");

			do {
				
				Socket socket = serverSocket.accept();
				System.out.println("Socket accepted");
				SocketHandler socketHandler = new SocketHandler(socket);
				socketHandler.start();				
				count++;
				System.out.println("Socket send to handler - "+count);
			} while ( count < socketlimit );
						
			serverSocket.close();
			System.out.println("Server "+port+" closed");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
