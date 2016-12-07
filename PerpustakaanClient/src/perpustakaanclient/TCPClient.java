package perpustakaanclient;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class TCPClient {

	Socket s = null;
	ObjectInputStream in;
	ObjectOutputStream out;

	public TCPClient() {
		try {
			String serverAddress = "192.168.1.100";
			int serverPort = 9090;
			s = new Socket(serverAddress, serverPort);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
		} catch (UnknownHostException e) {
			System.out.println("Sock: " + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
			JOptionPane.showMessageDialog(null, "Server Belum Dihidupkan");
		}
	}

	public Object send(String str) throws IOException, ClassNotFoundException {

		out.writeObject(str);
		Object data = in.readObject();
		out.flush();
		return data;

	}

}
