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
import java.util.Vector;

public class DataAccessBuku {

	private Connection conn;

	public DataAccessBuku() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventori", "root", "");
	}

	public boolean isConnected() {
		return (this.conn != null);
	}

	public void closeConnection() throws SQLException {
		this.conn.close();
	}

	public void insertBuku(Buku buku) throws SQLException {
		String query = "insert into buku_master(id_buku, kode_buku, judul_buku, penulis, penerbit, tahun_terbit, nomor_rak, jumlah_buku) values(?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setInt(1, getLastIdBuku());
		stmt.setString(2, getLastKodeBuku());
		stmt.setString(3, buku.getJudulBuku());
		stmt.setString(4, buku.getPenulis());
		stmt.setString(5, buku.getPenerbit());
		stmt.setString(6, buku.getTahunTerbit());
		stmt.setString(7, buku.getNomorRak());
		stmt.setInt(8, buku.getJumlahBuku());
		stmt.execute();
		stmt.close();
	}

	public int getLastIdBuku() throws SQLException {
		int idBuku = 0;

		String query = "SELECT COALESCE(MAX(id_buku),0) FROM buku_master;";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			idBuku = rs.getInt(1);
		}
		idBuku = idBuku + 1;

		return idBuku;
	}

	public String getLastKodeBuku() throws SQLException {
		int idBuku = 0;
		String kodeBuku = "";
		String query = "SELECT COALESCE(MAX(id_buku),0) FROM buku_master;";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			idBuku = rs.getInt(1);
		}
		idBuku = idBuku + 1;
		kodeBuku = "KB00" + String.valueOf(idBuku);
		return kodeBuku;
	}

	public void updateBuku(Buku buku) throws SQLException {
		String query = "update buku_master set judul_buku = ?, penulis = ?, penerbit = ?, tahun_terbit = ?, nomor_rak = ?, jumlah_buku = ? where kode_buku = ?";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, buku.getJudulBuku());
		stmt.setString(2, buku.getPenulis());
		stmt.setString(3, buku.getPenerbit());
		stmt.setString(4, buku.getTahunTerbit());
		stmt.setString(5, buku.getNomorRak());
		stmt.setInt(6, buku.getJumlahBuku());
		stmt.setString(7, buku.getKodeBuku());
		stmt.executeUpdate();
		stmt.close();
	}

	public void deleteBuku(String kodeBuku) throws SQLException {
		String query = "delete from buku_master where kode_buku = ?";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, kodeBuku);
		stmt.executeUpdate();
		stmt.close();
	}

	public Vector<Buku> searchBuku(String kategori, String cari) throws SQLException {

		Vector<Buku> bukuList = new Vector<Buku>();

		String query = "select * from buku_master where " + kategori + " LIKE ?";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, "%" + cari + "%");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Buku buku = getBuku(rs);
			bukuList.add(buku);
		}
		return bukuList;
	}

	public Vector<Buku> selectBuku() throws SQLException {

		Vector<Buku> bukuList = new Vector<Buku>();

		String query = "select * from buku_master";
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			Buku buku = getBuku(rs);
			bukuList.add(buku);
		}
		return bukuList;
	}

	public Buku getBuku(ResultSet rs) throws SQLException {
		String kodeBuku = rs.getString("kode_buku");
		String judulBuku = rs.getString("judul_buku");
		String penulis = rs.getString("penulis");
		String penerbit = rs.getString("penerbit");
		String tahunTerbit = rs.getString("tahun_terbit");
		String nomorRak = rs.getString("nomor_rak");
		int jumlahBuku = rs.getInt("jumlah_buku");

		Buku tempBuku = new Buku(kodeBuku, judulBuku, penulis, penerbit, tahunTerbit, nomorRak, jumlahBuku);

		return tempBuku;
	}

	public Vector<Object> informasiBuku(String kodeBuku) throws SQLException {

		Vector<Object> v = new Vector<Object>();

		String query = "SELECT * FROM buku_master where kode_buku = ?";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, kodeBuku);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			v.add(rs.getString("judul_buku"));
			v.add(rs.getString("penulis"));
			v.add(rs.getString("penerbit"));
			v.add(rs.getString("tahun_terbit"));
			v.add(rs.getString("nomor_rak"));
		}
		return v;
	}

}
