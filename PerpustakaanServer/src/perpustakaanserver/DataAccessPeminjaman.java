package perpustakaanserver;

/**
 *
 * @author rsctv
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class DataAccessPeminjaman {

	private Connection conn;

	public DataAccessPeminjaman() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventori", "root", "");
	}

	public boolean isConnected() {
		return (this.conn != null);
	}

	public void closeConnection() throws SQLException {
		this.conn.close();
	}

	public Vector<Vector<Object>> selectPinjam() throws SQLException {

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		Statement stmt = this.conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM peminjaman where status_pinjam = 'pinjam'");
		while (rs.next()) {
			Vector<Object> v = new Vector<Object>();
			v.add(rs.getString("kode_pinjam"));
			v.add(rs.getString("tanggal_pinjam"));
			v.add(rs.getString("tanggal_batas_pinjam"));
			v.add(rs.getString("kode_anggota"));
			v.add(rs.getString("kode_buku"));
			v.add(rs.getString("status_pinjam"));
			data.add(v);
		}
		return data;
	}

	public Vector<Vector<Object>> selectKembali() throws SQLException {

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		Statement stmt = this.conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM peminjaman where status_pinjam = 'kembali'");
		while (rs.next()) {
			Vector<Object> v = new Vector<Object>();
			v.add(rs.getString("kode_pinjam"));
			v.add(rs.getString("tanggal_pinjam"));
			v.add(rs.getString("tanggal_batas_pinjam"));
			v.add(rs.getString("tanggal_kembali"));
			v.add(rs.getString("kode_anggota"));
			v.add(rs.getString("kode_buku"));
			v.add(rs.getString("status_pinjam"));
			data.add(v);
		}
		return data;
	}

	public Vector<Vector<Object>> selectHistori() throws SQLException {

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		Statement stmt = this.conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM peminjaman");
		while (rs.next()) {
			Vector<Object> v = new Vector<Object>();
			v.add(rs.getString("kode_pinjam"));
			v.add(rs.getString("tanggal_pinjam"));
			v.add(rs.getString("tanggal_batas_pinjam"));
			v.add(rs.getString("tanggal_kembali"));
			v.add(rs.getString("kode_anggota"));
			v.add(rs.getString("kode_buku"));
			v.add(rs.getString("status_pinjam"));
			data.add(v);
		}
		return data;
	}

	public Vector<Vector<Object>> searchHistori(String kategori, String cari) throws SQLException {

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		String query = "SELECT * FROM peminjaman where " + kategori + " LIKE ?";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, "%" + cari + "%");

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Vector<Object> v = new Vector<Object>();
			v.add(rs.getString("kode_pinjam"));
			v.add(rs.getString("tanggal_pinjam"));
			v.add(rs.getString("tanggal_batas_pinjam"));
			v.add(rs.getString("tanggal_kembali"));
			v.add(rs.getString("kode_anggota"));
			v.add(rs.getString("kode_buku"));
			v.add(rs.getString("status_pinjam"));
			data.add(v);
		}
		return data;

	}

	public Vector<Vector<Object>> selectHistoriAnggota(String kodeAnggota) throws SQLException {

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		String query = "SELECT peminjaman.kode_pinjam, buku_master.judul_buku, peminjaman.tanggal_pinjam, "
				+ " peminjaman.tanggal_batas_pinjam, peminjaman.tanggal_kembali, peminjaman.status_pinjam "
				+ " from peminjaman INNER JOIN buku_master "
				+ " ON peminjaman.kode_buku = buku_master.kode_buku where peminjaman.kode_anggota = ?";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, kodeAnggota);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Vector<Object> v = new Vector<Object>();
			v.add(rs.getString("peminjaman.kode_pinjam"));
			v.add(rs.getString("buku_master.judul_buku"));
			v.add(rs.getString("peminjaman.tanggal_pinjam"));
			v.add(rs.getString("peminjaman.tanggal_batas_pinjam"));
			v.add(rs.getString("peminjaman.tanggal_kembali"));
			v.add(rs.getString("peminjaman.status_pinjam"));
			data.add(v);
		}
		return data;
	}

	public Vector<Vector<Object>> selectHistoriBuku(String kodeBuku) throws SQLException {

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		String query = "SELECT peminjaman.kode_pinjam, anggota_master.kode_anggota, anggota_master.nama, "
				+ " peminjaman.tanggal_pinjam, peminjaman.tanggal_kembali, peminjaman.status_pinjam "
				+ " from peminjaman INNER JOIN anggota_master "
				+ " ON peminjaman.kode_anggota = anggota_master.kode_anggota where peminjaman.kode_buku = ?";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, kodeBuku);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Vector<Object> v = new Vector<Object>();
			v.add(rs.getString("peminjaman.kode_pinjam"));
			v.add(rs.getString("anggota_master.kode_anggota"));
			v.add(rs.getString("anggota_master.nama"));
			v.add(rs.getString("peminjaman.tanggal_pinjam"));
			v.add(rs.getString("peminjaman.tanggal_kembali"));
			v.add(rs.getString("peminjaman.status_pinjam"));
			data.add(v);
		}
		return data;
	}

	public Vector<Vector<Object>> informasiBuku() throws SQLException {

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		Statement stmt = this.conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM peminjaman");
		while (rs.next()) {
			Vector<Object> v = new Vector<Object>();
			v.add(rs.getString("kode_pinjam"));
			v.add(rs.getString("tanggal_pinjam"));
			v.add(rs.getString("tanggal_batas_pinjam"));
			v.add(rs.getString("tanggal_kembali"));
			v.add(rs.getString("kode_anggota"));
			v.add(rs.getString("kode_buku"));
			v.add(rs.getString("status_pinjam"));
			data.add(v);
		}
		return data;
	}

	public Vector<Vector<Object>> searchPinjam(String kategori, String cari) throws SQLException {

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		String query = "SELECT * FROM peminjaman where status_pinjam = 'pinjam' AND " + kategori + " LIKE ?";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, "%" + cari + "%");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Vector<Object> v = new Vector<Object>();
			v.add(rs.getString("kode_pinjam"));
			v.add(rs.getString("tanggal_pinjam"));
			v.add(rs.getString("tanggal_batas_pinjam"));
			v.add(rs.getString("kode_anggota"));
			v.add(rs.getString("kode_buku"));
			v.add(rs.getString("status_pinjam"));
			data.add(v);
		}
		return data;
	}

	public void insertPinjam(String kodeBuku, String kodeAnggota, String tanggalPinjam, String tanggalBatasPinjam)
			throws SQLException, ParseException {
		PreparedStatement stmt = null, stmt2 = null;
		try {
			conn.setAutoCommit(false);
			String query = "insert into peminjaman (id_pinjam, kode_pinjam, tanggal_pinjam, tanggal_batas_pinjam, tanggal_kembali, status_pinjam, kode_anggota, kode_buku) values(?,?,?,?,?,?,?,?)";
			stmt = this.conn.prepareStatement(query);
			stmt.setInt(1, getLastIdPinjam());
			stmt.setString(2, getLastKodePinjam());
			stmt.setString(3, tanggalPinjam);
			stmt.setString(4, tanggalBatasPinjam);
			stmt.setString(5, "-");
			stmt.setString(6, "pinjam");
			stmt.setString(7, kodeAnggota);
			stmt.setString(8, kodeBuku);
			stmt.executeUpdate();

			String query2 = "update buku_master set jumlah_buku = jumlah_buku - ? where kode_buku = ?";
			stmt2 = this.conn.prepareStatement(query2);
			stmt2.setInt(1, 1);
			stmt2.setString(2, kodeBuku);
			stmt2.executeUpdate();

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			System.out.println(e);
		}
		conn.setAutoCommit(true);
	}

	public int getLastIdPinjam() throws SQLException {
		int idPinjam = 0;
		String query = "SELECT COALESCE(MAX(id_pinjam),0) FROM peminjaman;";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			idPinjam = rs.getInt(1);
		}
		idPinjam = idPinjam + 1;
		return idPinjam;
	}

	public String getLastKodePinjam() throws SQLException {
		int idPinjam = 0;
		String kodePinjam = "";
		String query = "SELECT COALESCE(MAX(id_pinjam),0) FROM peminjaman;";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			idPinjam = rs.getInt(1);
		}
		idPinjam = idPinjam + 1;
		kodePinjam = "KP00" + String.valueOf(idPinjam);
		return kodePinjam;
	}

	public int StokBuku(String kodeBuku) throws SQLException {
		int totalStok = 0;
		String query = "select jumlah_buku from buku_master where kode_buku = ?";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, kodeBuku);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			totalStok = rs.getInt(1);
		}
		return totalStok;
	}

	public int CekKodeBuku(String kodeBuku) throws SQLException {
		int cek = 0;
		String query = "select count(*) from buku_master where kode_buku = ?";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, kodeBuku);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			cek = rs.getInt(1);
		}
		return cek;
	}

	public int CekKodeAnggota(String kodeAnggota) throws SQLException {
		int cek = 0;
		String query = "select count(*) from anggota_master where kode_anggota = ?";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, kodeAnggota);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			cek = rs.getInt(1);
		}
		return cek;
	}

	public int cekTotalPinjamAnggota(String kodeAnggota) throws SQLException {
		int jumlah = 0;
		String query = "select * from peminjaman where kode_anggota = ? AND status_pinjam ='pinjam'";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, kodeAnggota);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			jumlah = jumlah + 1;
		}
		return jumlah;
	}

	public void updateStatusBuku(String kodePinjam, String kodeBuku) throws SQLException {
		PreparedStatement stmt = null, stmt2 = null;
		try {

			Calendar cal = Calendar.getInstance();
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String tglSekarang = dateFormat.format(cal.getTime());

			conn.setAutoCommit(false);
			String query = "update peminjaman set status_pinjam = ?, tanggal_kembali = ? where kode_pinjam = ?";
			stmt = this.conn.prepareStatement(query);
			stmt.setString(1, "kembali");
			stmt.setString(2, tglSekarang);
			stmt.setString(3, kodePinjam);
			stmt.executeUpdate();

			String query2 = "update buku_master set jumlah_buku = jumlah_buku + ? where kode_buku = ?";
			stmt2 = this.conn.prepareStatement(query2);
			stmt2.setInt(1, 1);
			stmt2.setString(2, kodeBuku);
			stmt2.executeUpdate();

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			System.out.println(e);
		}
		conn.setAutoCommit(true);
	}

	public int hitungDenda(String tanggalAkhir) throws ParseException {
		int hasil;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String temp = dateFormat.format(cal.getTime());
		Date tglSekarang = dateFormat.parse(temp);
		Date tglAkhir = dateFormat.parse(tanggalAkhir);
		long selisih = (tglSekarang.getTime() - tglAkhir.getTime());
		if (TimeUnit.MILLISECONDS.toDays(selisih) > 0) {
			hasil = (int) TimeUnit.MILLISECONDS.toDays(selisih);
		} else {
			hasil = 0;
		}
		return hasil;
	}

}
