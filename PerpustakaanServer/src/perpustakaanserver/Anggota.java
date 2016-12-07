package perpustakaanserver;

/**
 *
 * @author rsctv
 */

public class Anggota {

	private String kodeAnggota;
	private String nama;
	private String alamat;
	private String nomorTelepon;
	private String email;

	public Anggota(String nama, String alamat, String nomorTelepon, String email) {
		this.nama = nama;
		this.alamat = alamat;
		this.nomorTelepon = nomorTelepon;
		this.email = email;
	}

	public Anggota(String kodeAnggota, String nama, String alamat, String nomorTelepon, String email) {
		this.kodeAnggota = kodeAnggota;
		this.nama = nama;
		this.alamat = alamat;
		this.nomorTelepon = nomorTelepon;
		this.email = email;
	}

	public String getKodeAnggota() {
		return kodeAnggota;
	}

	public String getNama() {
		return nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public String getNomorTelepon() {
		return nomorTelepon;
	}

	public String getEmail() {
		return email;
	}

	public void setKodeAnggota(String kodeAnggota) {
		this.kodeAnggota = kodeAnggota;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public void setNomorTelepon(String nomorTelepon) {
		this.nomorTelepon = nomorTelepon;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
