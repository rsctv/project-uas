package perpustakaanserver;

import java.net.UnknownHostException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class FrameServer extends JFrame {

	private JLabel lblJudulServerPerpustakaan;
	private JPanel panelAreaServerConsole;
	private JPanel panelJudulServer;
	private JPanel panelServerConsole;
	private JScrollPane scrollServerConsole;
	private JTextArea txtAreaServerConsole;

	TCPServer tcpServer;

	public FrameServer() throws UnknownHostException {

		panelAreaServerConsole = new javax.swing.JPanel();
		panelServerConsole = new javax.swing.JPanel();
		scrollServerConsole = new javax.swing.JScrollPane();
		txtAreaServerConsole = new javax.swing.JTextArea();
		panelJudulServer = new javax.swing.JPanel();
		lblJudulServerPerpustakaan = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		panelAreaServerConsole
				.setLayout(new javax.swing.BoxLayout(panelAreaServerConsole, javax.swing.BoxLayout.Y_AXIS));

		panelServerConsole.setBorder(javax.swing.BorderFactory.createTitledBorder("Message Console"));
		panelServerConsole.setPreferredSize(new java.awt.Dimension(400, 250));
		panelServerConsole.setLayout(new java.awt.BorderLayout());

		txtAreaServerConsole.setEditable(false);
		txtAreaServerConsole.setColumns(20);
		txtAreaServerConsole.setRows(5);
		scrollServerConsole.setViewportView(txtAreaServerConsole);

		panelServerConsole.add(scrollServerConsole, java.awt.BorderLayout.CENTER);

		panelAreaServerConsole.add(panelServerConsole);

		getContentPane().add(panelAreaServerConsole, java.awt.BorderLayout.CENTER);

		lblJudulServerPerpustakaan.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
		lblJudulServerPerpustakaan.setText("Server Perpustakaan XYZ");
		panelJudulServer.add(lblJudulServerPerpustakaan);
		lblJudulServerPerpustakaan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perpustakaanserver/Console-icon.png"))); 
		getContentPane().add(panelJudulServer, java.awt.BorderLayout.PAGE_START);

		pack();

		tcpServer = new TCPServer(this);
		System.out.println("Server Sudah Jalan");

	}

	public void printMessageConsole(String message) {
		String allMessage = txtAreaServerConsole.getText();
		allMessage += ">> " + message + " \n";
		txtAreaServerConsole.setText(allMessage);
	}

	public static void main(String[] args) throws UnknownHostException {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (InstantiationException ex) {
			System.out.println(ex.getMessage());
		} catch (IllegalAccessException ex) {
			System.out.println(ex.getMessage());
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			System.out.println(ex.getMessage());
		}

		new FrameServer().setVisible(true);
	}

}
