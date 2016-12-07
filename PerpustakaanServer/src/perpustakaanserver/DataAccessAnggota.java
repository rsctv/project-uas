package perpustakaanserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DataAccessAnggota {

	private Connection conn;

	public DataAccessAnggota() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventori", "root", "");
	}

	public boolean isConnected() {
		return (this.conn != null);
	}

	public void closeConnection() throws SQLException {
		this.conn.close();
	}

	public void insertAnggota(Anggota anggota) throws SQLException {
		String query = "insert into anggota_master(id_anggota, kode_anggota, nama, alamat, telepon, email) values(?,?,?,?,?,?)";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setInt(1, getLastIdAnggota());
		stmt.setString(2, getLastKodeAnggota());
		stmt.setString(3, anggota.getNama());
		stmt.setString(4, anggota.getAlamat());
		stmt.setString(5, anggota.getNomorTelepon());
		stmt.setString(6, anggota.getEmail());
		stmt.execute();
		stmt.close();
	}

	public void updateAnggota(Anggota anggota) throws SQLException {
		String query = "update anggota_master set nama = ?, alamat = ?, telepon = ?, email = ? where kode_anggota = ?";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, anggota.getNama());
		stmt.setString(2, anggota.getAlamat());
		stmt.setString(3, anggota.getNomorTelepon());
		stmt.setString(4, anggota.getEmail());
		stmt.setString(5, anggota.getKodeAnggota());
		stmt.executeUpdate();
		stmt.close();
	}

	public void deleteAnggota(String kodeAnggota) throws SQLException {
		String query = "delete from anggota_master where kode_anggota = ?";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, kodeAnggota);
		stmt.executeUpdate();
		stmt.close();
	}

	public int getLastIdAnggota() throws SQLException {
		int idAnggota = 0;
		String query = "SELECT COALESCE(MAX(id_anggota),0) FROM anggota_master;";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			idAnggota = rs.getInt(1);
		}
		idAnggota = idAnggota + 1;
		return idAnggota;
	}

	public String getLastKodeAnggota() throws SQLException {
		int idAnggota = 0;
		String kodeAnggota = "";
		String query = "SELECT COALESCE(MAX(id_anggota),0) FROM anggota_master;";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			idAnggota = rs.getInt(1);
		}
		idAnggota = idAnggota + 1;
		kodeAnggota = "KA00" + String.valueOf(idAnggota);
		return kodeAnggota;
	}

	public Vector<Anggota> searchAnggota(String kategori, String cari) throws SQLException {

		Vector<Anggota> anggotaList = new Vector<Anggota>();

		String query = "select * from anggota_master where " + kategori + " LIKE ?";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, "%" + cari + "%");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Anggota anggota = getAnggota(rs);
			anggotaList.add(anggota);
		}
		return anggotaList;
	}

	public Vector<Anggota> selectAnggota() throws SQLException {

		Vector<Anggota> anggotaList = new Vector<Anggota>();

		String query = "select * from anggota_master";
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			Anggota anggota = getAnggota(rs);
			anggotaList.add(anggota);
		}
		return anggotaList;
	}

	public Anggota getAnggota(ResultSet rs) throws SQLException {
		String kodeAnggota = rs.getString("kode_anggota");
		String nama = rs.getString("nama");
		String alamat = rs.getString("alamat");
		String nomorTelepon = rs.getString("telepon");
		String email = rs.getString("email");

		Anggota tempAnggota = new Anggota(kodeAnggota, nama, alamat, nomorTelepon, email);

		return tempAnggota;
	}

	public Vector<Object> informasiAnggota(String kodeAnggota) throws SQLException {

		Vector<Object> v = new Vector<Object>();

		String query = "SELECT * FROM anggota_master where kode_anggota = ?";
		PreparedStatement stmt = this.conn.prepareStatement(query);
		stmt.setString(1, kodeAnggota);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			v.add(rs.getString("nama"));
			v.add(rs.getString("alamat"));
			v.add(rs.getString("telepon"));
			v.add(rs.getString("email"));
		}
		return v;
	}

}
