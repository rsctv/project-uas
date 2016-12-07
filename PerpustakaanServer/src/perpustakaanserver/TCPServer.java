package perpustakaanserver;

import java.io.*;
import java.net.*;

public class TCPServer extends Thread {

	private Socket clientSocket;
	private String clientSocketAddress;
	FrameServer frameServer;
	private ServerSocket serverSocket;

	public TCPServer(FrameServer frameServer) throws UnknownHostException {
		this.start();
		this.frameServer = frameServer;
		frameServer.printMessageConsole("Server Sudah Jalan");
		frameServer.printMessageConsole("IP Address Server : " + InetAddress.getLocalHost().getHostAddress());

	}

	@Override
	public void run() {
		try {
			int serverPort = 9090;
			serverSocket = new ServerSocket(serverPort);
			while (true) {
				clientSocket = serverSocket.accept();
				System.out.println("Klien : " + clientSocket.getRemoteSocketAddress().toString());
				clientSocketAddress = "Klien : " + clientSocket.getRemoteSocketAddress().toString();
				frameServer.printMessageConsole(clientSocketAddress);
				Koneksi k = new Koneksi(clientSocket, frameServer);
			}

		} catch (IOException ex) {
			System.out.println("Listen : " + ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
