package perpustakaanserver;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Koneksi extends Thread {

	ObjectInputStream in;
	ObjectOutputStream out;
	Socket clientSocket;

	String[] messages;

	DataAccessBuku DAB;
	DataAccessAnggota DAA;
	DataAccessPeminjaman DAP;

	FrameServer frameServer;

	public Koneksi(Socket aClientSocket, FrameServer frameServer) throws Exception {
		try {
			clientSocket = aClientSocket;
			in = new ObjectInputStream(clientSocket.getInputStream());
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			DAB = new DataAccessBuku();
			DAA = new DataAccessAnggota();
			DAP = new DataAccessPeminjaman();
			this.start();
		} catch (IOException ex) {
			System.out.println("Connection : " + ex.getMessage());
		}

	}

	@Override
	public void run() {
		while (true) {
			try {
				String message = in.readObject().toString();
				messages = message.split("#");
				if (messages[0].equalsIgnoreCase("requestDataBuku")) {
					out.writeObject(GetDataBuku());
				} else if (messages[0].equalsIgnoreCase("requestInsertBuku")) {
					Buku buku = new Buku(messages[1], messages[2], messages[3], messages[4], messages[5],
							Integer.parseInt(messages[6]));
					insertDataBuku(buku);
					out.writeObject("Telah Diinsert");
				} else if (messages[0].equalsIgnoreCase("requestUpdateBuku")) {
					Buku buku = new Buku(messages[1], messages[2], messages[3], messages[4], messages[5], messages[6],
							Integer.parseInt(messages[7]));
					updateDataBuku(buku);
					out.writeObject("Telah Diupdate");
				} else if (messages[0].equalsIgnoreCase("requestDeleteBuku")) {
					deleteDataBuku(messages[1]);
					out.writeObject("Telah Dihapus");
				} else if (messages[0].equalsIgnoreCase("requestCariBuku")) {
					out.writeObject(GetCariDataBuku(cekKategoriBuku(messages[1]), messages[2]));
				} else if (messages[0].equalsIgnoreCase("requestDataAnggota")) {
					out.writeObject(GetDataAnggota());
				} else if (messages[0].equalsIgnoreCase("requestInsertAnggota")) {
					Anggota anggota = new Anggota(messages[1], messages[2], messages[3], messages[4]);
					insertDataAnggota(anggota);
					out.writeObject("Telah Diinsert");
				} else if (messages[0].equalsIgnoreCase("requestUpdateAnggota")) {
					Anggota anggota = new Anggota(messages[1], messages[2], messages[3], messages[4], messages[5]);
					updateDataAnggota(anggota);
					out.writeObject("Telah Diupdate");
				} else if (messages[0].equalsIgnoreCase("requestDeleteAnggota")) {
					deleteDataAnggota(messages[1]);
					out.writeObject("Telah Dihapus");
				} else if (messages[0].equalsIgnoreCase("requestCariAnggota")) {
					out.writeObject(GetCariDataAnggota(cekKategoriAnggota(messages[1]), messages[2]));
				} else if (messages[0].equalsIgnoreCase("requestDataPeminjaman")) {
					out.writeObject(GetDataPeminjaman());
				} else if (messages[0].equalsIgnoreCase("requestInsertPeminjaman")) {
					insertDataPeminjaman(messages[1], messages[2], messages[3], messages[4]);
					out.writeObject("Telah Diinsert");
				} else if (messages[0].equalsIgnoreCase("requestCekDenda")) {
					out.writeObject(GetTotalHariDenda(messages[1]));
				} else if (messages[0].equalsIgnoreCase("requestCekStokBuku")) {
					out.writeObject(GetStokBuku(messages[1]));
				} else if (messages[0].equalsIgnoreCase("requestCekKodeBuku")) {
					out.writeObject(GetKodeBuku(messages[1]));
				} else if (messages[0].equalsIgnoreCase("requestCekKodeAnggota")) {
					out.writeObject(GetKodeAnggota(messages[1]));
				} else if (messages[0].equalsIgnoreCase("requestCekTotalPinjamAnggota")) {
					out.writeObject(GetTotalPinjamAnggota(messages[1]));
				} else if (messages[0].equalsIgnoreCase("requestKembaliBuku")) {
					kembaliBuku(messages[1].toString(), messages[2]);
					out.writeObject("Buku Telah Dikembalikan");
				} else if (messages[0].equalsIgnoreCase("requestCariPeminjaman")) {
					out.writeObject(GetCariDataPeminjaman(cekKategoriPinjam(messages[1]), messages[2]));
				} else if (messages[0].equalsIgnoreCase("requestDataHistori")) {
					out.writeObject(GetDataHistori());
				} else if (messages[0].equalsIgnoreCase("requestInformasiBuku")) {
					out.writeObject(GetInformasiBuku(messages[1]));
				} else if (messages[0].equalsIgnoreCase("requestInformasiAnggota")) {
					out.writeObject(GetInformasiAnggota(messages[1]));
				} else if (messages[0].equalsIgnoreCase("requestCariHistori")) {
					out.writeObject(GetCariDataHistori(cekKategoriHistori(messages[1]), messages[2]));
				} else if (messages[0].equalsIgnoreCase("requestDataHistoriAnggota")) {
					out.writeObject(GetDataHistoriAnggota(messages[1]));
				} else if (messages[0].equalsIgnoreCase("requestDataHistoriBuku")) {
					out.writeObject(GetDataHistoriBuku(messages[1]));
				}

			} catch (EOFException e) {
				System.out.println("EOF: " + e.getMessage());
			} catch (IOException e) {
				// System.out.println("IO:s a"+e.getMessage());
				try {
					clientSocket.close();
				} catch (IOException ex) {
					System.out.println(ex.getMessage());
				}
			} catch (ClassNotFoundException | SQLException | ParseException ex) {
				System.out.println(ex.getMessage());
			}
		}

	}

	public void insertDataBuku(Buku buku) throws SQLException {
		DAB.insertBuku(buku);
	}

	public void updateDataBuku(Buku buku) throws SQLException {
		DAB.updateBuku(buku);
	}

	public void deleteDataBuku(String kodeBuku) throws SQLException {
		DAB.deleteBuku(kodeBuku);
	}

	public DefaultTableModel GetCariDataBuku(String kategori, String cari) throws SQLException {

		Vector<Buku> list = DAB.searchBuku(kategori, cari);

		DefaultTableModel model = new DefaultTableModel();

		model.setRowCount(0);
		model.addColumn("Kode Buku");
		model.addColumn("Judul Buku");
		model.addColumn("Penulis");
		model.addColumn("Penerbit");
		model.addColumn("Tahun Terbit");
		model.addColumn("Nomor Rak");
		model.addColumn("Jumlah Buku");

		Object[] row = new Object[model.getColumnCount()];

		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getKodeBuku();
			row[1] = list.get(i).getJudulBuku();
			row[2] = list.get(i).getPenulis();
			row[3] = list.get(i).getPenerbit();
			row[4] = list.get(i).getTahunTerbit();
			row[5] = list.get(i).getNomorRak();
			row[6] = list.get(i).getJumlahBuku();
			model.addRow(row);
		}

		return model;

	}

	public DefaultTableModel GetDataBuku() throws SQLException {

		Vector<Buku> list = DAB.selectBuku();

		DefaultTableModel model = new DefaultTableModel();

		model.setRowCount(0);
		model.addColumn("Kode Buku");
		model.addColumn("Judul Buku");
		model.addColumn("Penulis");
		model.addColumn("Penerbit");
		model.addColumn("Tahun Terbit");
		model.addColumn("Nomor Rak");
		model.addColumn("Jumlah Buku");

		Object[] row = new Object[model.getColumnCount()];

		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getKodeBuku();
			row[1] = list.get(i).getJudulBuku();
			row[2] = list.get(i).getPenulis();
			row[3] = list.get(i).getPenerbit();
			row[4] = list.get(i).getTahunTerbit();
			row[5] = list.get(i).getNomorRak();
			row[6] = list.get(i).getJumlahBuku();
			model.addRow(row);
		}

		return model;
	}

	public String cekKategoriBuku(String kategori) {
		String temp = "";
		if (kategori.equals("Kode Buku")) {
			temp = "kode_buku";
		} else if (kategori.equals("Judul Buku")) {
			temp = "judul_buku";
		} else if (kategori.equals("Penulis")) {
			temp = "penulis";
		} else if (kategori.equals("Penerbit")) {
			temp = "penerbit";
		} else if (kategori.equals("Tahun Terbit")) {
			temp = "tahun_terbit";
		} else if (kategori.equals("Nomor Rak")) {
			temp = "nomor_rak";
		}
		return temp;
	}

	public DefaultTableModel GetCariDataAnggota(String kategori, String cari) throws SQLException {
		Vector<Anggota> list = DAA.searchAnggota(kategori, cari);

		DefaultTableModel model = new DefaultTableModel();

		model.setRowCount(0);
		model.addColumn("Kode Anggota");
		model.addColumn("Nama");
		model.addColumn("Alamat");
		model.addColumn("Nomor Telepon");
		model.addColumn("Email");

		Object[] row = new Object[model.getColumnCount()];

		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getKodeAnggota();
			row[1] = list.get(i).getNama();
			row[2] = list.get(i).getAlamat();
			row[3] = list.get(i).getNomorTelepon();
			row[4] = list.get(i).getEmail();
			model.addRow(row);
		}

		return model;

	}

	public DefaultTableModel GetDataAnggota() throws SQLException {

		Vector<Anggota> list = DAA.selectAnggota();

		DefaultTableModel model = new DefaultTableModel();

		model.setRowCount(0);
		model.addColumn("Kode Anggota");
		model.addColumn("Nama");
		model.addColumn("Alamat");
		model.addColumn("Nomor Telepon");
		model.addColumn("Email");

		Object[] row = new Object[model.getColumnCount()];

		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getKodeAnggota();
			row[1] = list.get(i).getNama();
			row[2] = list.get(i).getAlamat();
			row[3] = list.get(i).getNomorTelepon();
			row[4] = list.get(i).getEmail();
			model.addRow(row);
		}

		return model;
	}

	public String cekKategoriAnggota(String kategori) {
		String temp = "";
		if (kategori.equals("Kode Anggota")) {
			temp = "kode_anggota";
		} else if (kategori.equals("Nama Anggota")) {
			temp = "nama";
		} else if (kategori.equals("Email")) {
			temp = "email";
		}
		return temp;
	}

	public void insertDataAnggota(Anggota anggota) throws SQLException {
		DAA.insertAnggota(anggota);
	}

	public void updateDataAnggota(Anggota anggota) throws SQLException {
		DAA.updateAnggota(anggota);
	}

	public void deleteDataAnggota(String kodeAnggota) throws SQLException {
		DAA.deleteAnggota(kodeAnggota);
	}

	public DefaultTableModel GetDataPeminjaman() throws SQLException {

		Vector<Vector<Object>> list = DAP.selectPinjam();

		DefaultTableModel model = new DefaultTableModel();

		model.setRowCount(0);
		model.addColumn("Kode Pinjam");
		model.addColumn("Tanggal Pinjam");
		model.addColumn("Tanggal Batas Pinjam");
		model.addColumn("Kode Anggota");
		model.addColumn("Kode Buku");
		model.addColumn("Status");

		for (Vector<Object> v : list) {
			model.addRow(v);
		}

		return model;
	}

	public DefaultTableModel GetCariDataPeminjaman(String kategori, String cari) throws SQLException {

		Vector<Vector<Object>> list = DAP.searchPinjam(kategori, cari);

		DefaultTableModel model = new DefaultTableModel();

		model.setRowCount(0);
		model.addColumn("Kode Pinjam");
		model.addColumn("Tanggal Pinjam");
		model.addColumn("Tanggal Batas Pinjam");
		model.addColumn("Kode Anggota");
		model.addColumn("Kode Buku");
		model.addColumn("Status");

		for (Vector<Object> v : list) {
			model.addRow(v);
		}

		return model;
	}

	public void insertDataPeminjaman(String kodeAnggota, String kodeBuku, String tanggalPinjam,
			String tanggalBatasPinjam) throws SQLException, ParseException {
		DAP.insertPinjam(kodeBuku, kodeAnggota, tanggalPinjam, tanggalBatasPinjam);
	}

	public int GetTotalHariDenda(String tanggalBatasPinjam) throws ParseException {
		int totalHariDenda = DAP.hitungDenda(tanggalBatasPinjam);
		return totalHariDenda;
	}

	public int GetStokBuku(String kodeBuku) throws SQLException {
		int totalStok = DAP.StokBuku(kodeBuku);
		return totalStok;
	}

	public int GetKodeBuku(String kodeBuku) throws SQLException {
		int cekKodeBuku = DAP.CekKodeBuku(kodeBuku);
		return cekKodeBuku;
	}

	public int GetKodeAnggota(String kodeAnggota) throws SQLException {
		int cekKodeAnggota = DAP.CekKodeAnggota(kodeAnggota);
		return cekKodeAnggota;
	}

	public int GetTotalPinjamAnggota(String kodeAnggota) throws SQLException {
		int totalPinjamAnggota = DAP.cekTotalPinjamAnggota(kodeAnggota);
		return totalPinjamAnggota;
	}

	public void kembaliBuku(String kodePinjam, String kodeBuku) throws SQLException {
		DAP.updateStatusBuku(kodePinjam, kodeBuku);
	}

	public String cekKategoriPinjam(String kategori) {
		String temp = "";
		if (kategori.equals("Kode Pinjam")) {
			temp = "kode_pinjam";
		} else if (kategori.equals("Kode Anggota")) {
			temp = "kode_anggota";
		} else if (kategori.equals("Kode Buku")) {
			temp = "kode_buku";
		}
		return temp;
	}

	public DefaultTableModel GetDataHistori() throws SQLException {

		Vector<Vector<Object>> list = DAP.selectHistori();

		DefaultTableModel model = new DefaultTableModel();

		model.setRowCount(0);
		model.addColumn("Kode Pinjam");
		model.addColumn("Pinjam");
		model.addColumn("Batas Pinjam");
		model.addColumn("Kembali");
		model.addColumn("Kode Anggota");
		model.addColumn("Kode Buku");
		model.addColumn("Status");

		for (Vector<Object> v : list) {
			model.addRow(v);
		}

		return model;
	}

	public DefaultTableModel GetCariDataHistori(String kategori, String cari) throws SQLException {

		Vector<Vector<Object>> list = DAP.searchHistori(kategori, cari);

		DefaultTableModel model = new DefaultTableModel();

		model.setRowCount(0);
		model.addColumn("Kode Pinjam");
		model.addColumn("Pinjam");
		model.addColumn("Batas Pinjam");
		model.addColumn("Kembali");
		model.addColumn("Kode Anggota");
		model.addColumn("Kode Buku");
		model.addColumn("Status");

		for (Vector<Object> v : list) {
			model.addRow(v);
		}

		return model;
	}

	public Vector<Object> GetInformasiBuku(String kodeBuku) throws SQLException {

		Vector<Object> list = DAB.informasiBuku(kodeBuku);
		return list;
	}

	public Vector<Object> GetInformasiAnggota(String kodeAnggota) throws SQLException {

		Vector<Object> list = DAA.informasiAnggota(kodeAnggota);
		return list;
	}

	public String cekKategoriHistori(String kategori) {
		String temp = "";
		if (kategori.equals("Tanggal Pinjam")) {
			temp = "tanggal_pinjam";
		} else if (kategori.equals("Tanggal Kembali")) {
			temp = "tanggal_kembali";
		}
		return temp;
	}

	public DefaultTableModel GetDataHistoriAnggota(String kodeAnggota) throws SQLException {

		Vector<Vector<Object>> list = DAP.selectHistoriAnggota(kodeAnggota);

		DefaultTableModel model = new DefaultTableModel();

		model.setRowCount(0);
		model.addColumn("Kode Pinjam");
		model.addColumn("Judul Buku");
		model.addColumn("Pinjam");
		model.addColumn("Batas Pinjam");
		model.addColumn("Kembali");
		model.addColumn("Status");

		for (Vector<Object> v : list) {
			model.addRow(v);
		}

		return model;
	}

	public DefaultTableModel GetDataHistoriBuku(String kodeBuku) throws SQLException {

		Vector<Vector<Object>> list = DAP.selectHistoriBuku(kodeBuku);

		DefaultTableModel model = new DefaultTableModel();

		model.setRowCount(0);
		model.addColumn("Kode Pinjam");
		model.addColumn("Kode Anggota");
		model.addColumn("Nama");
		model.addColumn("Pinjam");
		model.addColumn("Kembali");
		model.addColumn("Status");

		for (Vector<Object> v : list) {
			model.addRow(v);
		}

		return model;
	}

}
