package perpustakaanserver;

/**
 *
 * @author rsctv
 */
public class Buku {

	private String kodeBuku;
	private String judulBuku;
	private String penulis;
	private String penerbit;
	private String tahunTerbit;
	private String nomorRak;
	private int jumlahBuku;

	public Buku(String judulBuku, String penulis, String penerbit, String tahunTerbit, String nomorRak,
			int jumlahBuku) {
		this.judulBuku = judulBuku;
		this.penulis = penulis;
		this.penerbit = penerbit;
		this.tahunTerbit = tahunTerbit;
		this.nomorRak = nomorRak;
		this.jumlahBuku = jumlahBuku;
	}

	public Buku(String kodeBuku, String judulBuku, String penulis, String penerbit, String tahunTerbit, String nomorRak,
			int jumlahBuku) {
		this.kodeBuku = kodeBuku;
		this.judulBuku = judulBuku;
		this.penulis = penulis;
		this.penerbit = penerbit;
		this.tahunTerbit = tahunTerbit;
		this.nomorRak = nomorRak;
		this.jumlahBuku = jumlahBuku;
	}

	public String getKodeBuku() {
		return kodeBuku;
	}

	public String getJudulBuku() {
		return judulBuku;
	}

	public String getPenulis() {
		return penulis;
	}

	public String getPenerbit() {
		return penerbit;
	}

	public String getTahunTerbit() {
		return tahunTerbit;
	}

	public String getNomorRak() {
		return nomorRak;
	}

	public int getJumlahBuku() {
		return jumlahBuku;
	}

	public void setKodeBuku(String kodeBuku) {
		this.kodeBuku = kodeBuku;
	}

	public void setJudulBuku(String judulBuku) {
		this.judulBuku = judulBuku;
	}

	public void setPenulis(String penulis) {
		this.penulis = penulis;
	}

	public void setPenerbit(String penerbit) {
		this.penerbit = penerbit;
	}

	public void setTahunTerbit(String tahunTerbit) {
		this.tahunTerbit = tahunTerbit;
	}

	public void setNomorRak(String nomorRak) {
		this.nomorRak = nomorRak;
	}

	public void setJumlahBuku(int jumlahBuku) {
		this.jumlahBuku = jumlahBuku;
	}

}
