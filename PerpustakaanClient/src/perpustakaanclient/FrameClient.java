package perpustakaanclient;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author rsctv
 */
public class FrameClient extends javax.swing.JFrame {

	TCPClient tcpClient;

	DefaultTableModel modelBuku = new DefaultTableModel();
	DefaultTableModel modelAnggota = new DefaultTableModel();
	DefaultTableModel modelPeminjaman = new DefaultTableModel();
	DefaultTableModel modelHistoriPeminjaman = new DefaultTableModel();
	DefaultTableModel modelDataAnggotaHistori = new DefaultTableModel();
	DefaultTableModel modelHistoriAnggota = new DefaultTableModel();
	DefaultTableModel modelDataBukuHistori = new DefaultTableModel();
	DefaultTableModel modelHistoriBuku = new DefaultTableModel();

	private static String KodeBuku;
	private static String KodeAnggota;
	private static String KodePinjam;
	private static String KodeBukuPeminjaman;

	private static ArrayList<String> DataAnggota;
	private static ArrayList<String> DataBuku;

	private javax.swing.JPanel PanelButtonPeminjaman;
	private javax.swing.JPanel PanelButtonReportHistoriPeminjaman;
	private javax.swing.JButton btnCariHistoriPeminjaman;
	private javax.swing.JButton btnEditAnggota;
	private javax.swing.JButton btnEditBuku;
	private javax.swing.JButton btnHapusAnggota;
	private javax.swing.JButton btnHapusBuku;
	private javax.swing.JButton btnPeminjaman;
	private javax.swing.JButton btnPengembalian;
	private javax.swing.JButton btnReport;
	private javax.swing.JButton btnReportHistoriAnggota;
	private javax.swing.JButton btnReportHistoriBuku;
	private javax.swing.JButton btnReportHistoriPeminjaman;
	private javax.swing.JButton btnResetAnggota;
	private javax.swing.JButton btnResetBuku;
	private javax.swing.JButton btnResetPeminjaman;
	private javax.swing.JButton btnTambahAnggota;
	private javax.swing.JButton btnTambahBuku;
	private javax.swing.JComboBox<String> cbCariAnggota;
	private javax.swing.JComboBox<String> cbCariAnggotaHistori;
	private javax.swing.JComboBox<String> cbCariBuku;
	private javax.swing.JComboBox<String> cbCariBukuHistori;
	private javax.swing.JComboBox<String> cbCariHistoriPeminjaman;
	private javax.swing.JComboBox<String> cbCariPeminjaman;
	private com.toedter.calendar.JDateChooser dcCariHistoriPeminjaman;
	private com.toedter.calendar.JDateChooser dcTanggalBatasPinjam;
	private com.toedter.calendar.JDateChooser dcTanggalPinjam;
	private javax.swing.JLabel lblAlamat;
	private javax.swing.JLabel lblAlamatInfo;
	private javax.swing.JLabel lblCariAnggota;
	private javax.swing.JLabel lblCariAnggotaHistori;
	private javax.swing.JLabel lblCariBuku;
	private javax.swing.JLabel lblCariBukuHistori;
	private javax.swing.JLabel lblCariHistoriPeminjaman;
	private javax.swing.JLabel lblCariPeminjaman;
	private javax.swing.JLabel lblEmail;
	private javax.swing.JLabel lblEmailInfo;
	private javax.swing.JLabel lblJudul;
	private javax.swing.JLabel lblJudulBuku;
	private javax.swing.JLabel lblJudulBukuInfo;
	private javax.swing.JLabel lblJudulTotalHargaDenda;
	private javax.swing.JLabel lblJudulTotalHariDenda;
	private javax.swing.JLabel lblJumlahBuku;
	private javax.swing.JLabel lblKodeAnggota;
	private javax.swing.JLabel lblKodeBuku;
	private javax.swing.JLabel lblNamaAnggota;
	private javax.swing.JLabel lblNamaInfo;
	private javax.swing.JLabel lblNomorRak;
	private javax.swing.JLabel lblNomorRakInfo;
	private javax.swing.JLabel lblNomorTelepon;
	private javax.swing.JLabel lblPenerbit;
	private javax.swing.JLabel lblPenerbitInfo;
	private javax.swing.JLabel lblPenulis;
	private javax.swing.JLabel lblPenulisInfo;
	private javax.swing.JLabel lblTahunTerbit;
	private javax.swing.JLabel lblTahunTerbitInfo;
	private javax.swing.JLabel lblTanggalBatasPinjam;
	private javax.swing.JLabel lblTanggalPinjam;
	private javax.swing.JLabel lblTeleponInfo;
	private javax.swing.JLabel lblTotalHargaDenda;
	private javax.swing.JLabel lblTotalHariDenda;
	private javax.swing.JLabel lbljudulAlamatInfo;
	private javax.swing.JLabel lbljudulEmailInfo;
	private javax.swing.JLabel lbljudulJudulBukuInfo;
	private javax.swing.JLabel lbljudulNamaInfo;
	private javax.swing.JLabel lbljudulNomorRakInfo;
	private javax.swing.JLabel lbljudulPenerbitInfo;
	private javax.swing.JLabel lbljudulPenulisInfo;
	private javax.swing.JLabel lbljudulTahunTerbitInfo;
	private javax.swing.JLabel lbljudulTeleponInfo;
	private javax.swing.JPanel panelAnggota;
	private javax.swing.JPanel panelAreaTabelHistoriAnggota;
	private javax.swing.JPanel panelAreaTabelHistoriBuku;
	private javax.swing.JPanel panelButtonAnggota;
	private javax.swing.JPanel panelButtonBuku;
	private javax.swing.JPanel panelButtonReportHistoriAnggota;
	private javax.swing.JPanel panelButtonReportHistoriBuku;
	private javax.swing.JPanel panelCariAnggota;
	private javax.swing.JPanel panelCariBuku;
	private javax.swing.JPanel panelCariHistoriAnggota;
	private javax.swing.JPanel panelCariHistoriBuku;
	private javax.swing.JPanel panelCariHistoriPeminjaman;
	private javax.swing.JPanel panelCariPeminjaman;
	private javax.swing.JPanel panelDataKembaliBuku;
	private javax.swing.JPanel panelDataPinjamBuku;
	private javax.swing.JPanel panelHistoriAnggota;
	private javax.swing.JPanel panelHistoriBuku;
	private javax.swing.JPanel panelHistoriPeminjaman;
	private javax.swing.JPanel panelInformasiAnggota;
	private javax.swing.JPanel panelInformasiBuku;
	private javax.swing.JPanel panelInformasiHistoriPeminjaman;
	private javax.swing.JPanel panelInventoriBuku;
	private javax.swing.JPanel panelJudul;
	private javax.swing.JPanel panelMenuUtama;
	private javax.swing.JPanel panelPeminjaman;
	private javax.swing.JPanel panelRecordAnggota;
	private javax.swing.JPanel panelRecordBuku;
	private javax.swing.JPanel panelRecordPeminjaman;
	private javax.swing.JPanel panelTabelAnggota;
	private javax.swing.JPanel panelTabelBuku;
	private javax.swing.JPanel panelTabelDataAnggotaHistori;
	private javax.swing.JPanel panelTabelDataBukuHistori;
	private javax.swing.JPanel panelTabelHistoriAnggota;
	private javax.swing.JPanel panelTabelHistoriBuku;
	private javax.swing.JPanel panelTabelHistoriPeminjaman;
	private javax.swing.JPanel panelTabelPeminjaman;
	private javax.swing.JScrollPane scollHistoriBuku;
	private javax.swing.JScrollPane scrollAnggota;
	private javax.swing.JScrollPane scrollBuku;
	private javax.swing.JScrollPane scrollDataAnggotaHistori;
	private javax.swing.JScrollPane scrollDataBukuHistori;
	private javax.swing.JScrollPane scrollHistoriAnggota;
	private javax.swing.JScrollPane scrollHistoriPeminjaman;
	private javax.swing.JScrollPane scrollPeminjaman;
	private javax.swing.JTabbedPane tabMenuUtama;
	private javax.swing.JTable tableAnggota;
	private javax.swing.JTable tableBuku;
	private javax.swing.JTable tableDataAnggotaHistori;
	private javax.swing.JTable tableDataBukuHistori;
	private javax.swing.JTable tableHistoriAnggota;
	private javax.swing.JTable tableHistoriBuku;
	private javax.swing.JTable tableHistoriPeminjaman;
	private javax.swing.JTable tablePeminjaman;
	private javax.swing.JTextField txtAlamat;
	private javax.swing.JTextField txtCariAnggota;
	private javax.swing.JTextField txtCariAnggotaHistori;
	private javax.swing.JTextField txtCariBuku;
	private javax.swing.JTextField txtCariBukuHistori;
	private javax.swing.JTextField txtCariPeminjaman;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtJudulBuku;
	private javax.swing.JTextField txtJumlahBuku;
	private javax.swing.JTextField txtKodeAnggota;
	private javax.swing.JTextField txtKodeBuku;
	private javax.swing.JTextField txtNamaAnggota;
	private javax.swing.JTextField txtNomorRak;
	private javax.swing.JTextField txtNomorTelepon;
	private javax.swing.JTextField txtPenerbit;
	private javax.swing.JTextField txtPenulis;
	private javax.swing.JTextField txtTahunTerbit;
	
	public FrameClient() throws IOException, ClassNotFoundException {

		initSwingControl();

		tcpClient = new TCPClient();
		DataAnggota = new ArrayList<String>();
		DataBuku = new ArrayList<String>();

		CreateTableBuku();
		LoadTableBuku(tcpClient.send("requestDataBuku"));

		CreateTableAnggota();
		LoadTableAnggota(tcpClient.send("requestDataAnggota"));

		CreateTablePeminjaman();
		LoadTablePeminjaman(tcpClient.send("requestDataPeminjaman"));

		CreateTableHistori();
		LoadTableHistori(tcpClient.send("requestDataHistori"));

		CreateTableDataAnggotaHistori();
		LoadTableDataAnggotaHistori(tcpClient.send("requestDataAnggota"));

		CreateTableHistoriAnggota();

		CreateTableDataBukuHistori();
		LoadTableDataBukuHistori(tcpClient.send("requestDataBuku"));

		CreateTableHistoriBuku();
	}

	private void CreateTableBuku() {
		modelBuku.addColumn("Kode Buku");
		modelBuku.addColumn("Judul Buku");
		modelBuku.addColumn("Penulis");
		modelBuku.addColumn("Penerbit");
		modelBuku.addColumn("Tahun Terbit");
		modelBuku.addColumn("Nomor Rak");
		modelBuku.addColumn("Jumlah Buku");
		tableBuku.setModel(modelBuku);
	}

	private void CreateTableAnggota() {
		modelAnggota.addColumn("Kode Anggota");
		modelAnggota.addColumn("Nama Anggota");
		modelAnggota.addColumn("Alamat");
		modelAnggota.addColumn("Nomor Telepon");
		modelAnggota.addColumn("Email");
		tableAnggota.setModel(modelAnggota);
	}

	private void CreateTablePeminjaman() {
		modelPeminjaman.addColumn("Kode Pinjam");
		modelPeminjaman.addColumn("Tanggal Pinjam");
		modelPeminjaman.addColumn("Tanggal Batas Pinjam");
		modelPeminjaman.addColumn("Kode Anggota");
		modelPeminjaman.addColumn("Kode Buku");
		modelPeminjaman.addColumn("Status");
		tablePeminjaman.setModel(modelPeminjaman);
	}

	private void CreateTableHistori() {

		modelHistoriPeminjaman.addColumn("Kode Pinjam");
		modelHistoriPeminjaman.addColumn("Pinjam");
		modelHistoriPeminjaman.addColumn("Batas Pinjam");
		modelHistoriPeminjaman.addColumn("Kembali");
		modelHistoriPeminjaman.addColumn("Kode Anggota");
		modelHistoriPeminjaman.addColumn("Kode Buku");
		modelHistoriPeminjaman.addColumn("Status");
		tableHistoriPeminjaman.setModel(modelHistoriPeminjaman);
	}

	private void CreateTableDataAnggotaHistori() {
		modelDataAnggotaHistori.addColumn("Kode Anggota");
		modelDataAnggotaHistori.addColumn("Nama Anggota");
		modelDataAnggotaHistori.addColumn("Alamat");
		modelDataAnggotaHistori.addColumn("Nomor Telepon");
		modelDataAnggotaHistori.addColumn("Email");
		tableDataAnggotaHistori.setModel(modelDataAnggotaHistori);
	}

	private void CreateTableHistoriAnggota() {
		modelHistoriAnggota.addColumn("Kode Pinjam");
		modelHistoriAnggota.addColumn("Judul Buku");
		modelHistoriAnggota.addColumn("Pinjam");
		modelHistoriAnggota.addColumn("Batas Pinjam");
		modelHistoriAnggota.addColumn("Kembali");
		modelHistoriAnggota.addColumn("Status");
		tableHistoriAnggota.setModel(modelHistoriAnggota);
	}

	private void CreateTableDataBukuHistori() {
		modelDataBukuHistori.addColumn("Kode Buku");
		modelDataBukuHistori.addColumn("Judul Buku");
		modelDataBukuHistori.addColumn("Penulis");
		modelDataBukuHistori.addColumn("Penerbit");
		modelDataBukuHistori.addColumn("Tahun Terbit");
		modelDataBukuHistori.addColumn("Nomor Rak");
		modelDataBukuHistori.addColumn("Jumlah Buku");
		tableDataBukuHistori.setModel(modelDataBukuHistori);
	}

	private void CreateTableHistoriBuku() {
		modelHistoriBuku.addColumn("Kode Pinjam");
		modelHistoriBuku.addColumn("Kode Anggota");
		modelHistoriBuku.addColumn("Nama");
		modelHistoriBuku.addColumn("Pinjam");
		modelHistoriBuku.addColumn("Kembali");
		modelHistoriBuku.addColumn("Status");
		tableHistoriBuku.setModel(modelHistoriBuku);
	}

	private void ClearTextFieldBuku() {
		txtJudulBuku.setText("");
		txtPenulis.setText("");
		txtPenerbit.setText("");
		txtTahunTerbit.setText("");
		txtNomorRak.setText("");
		txtJumlahBuku.setText("");
	}

	private void ClearTextFieldAnggota() {
		txtNamaAnggota.setText("");
		txtAlamat.setText("");
		txtNomorTelepon.setText("");
		txtEmail.setText("");
	}

	private void ClearTextFieldPeminjaman() {
		txtKodeBuku.setText("");
		txtKodeAnggota.setText("");
		dcTanggalPinjam.setDate(null);
		dcTanggalBatasPinjam.setDate(null);
	}

	private void LoadTableBuku(Object object) {
		tableBuku.setModel((TableModel) object);
	}

	private void LoadCariTableBuku(Object object) {
		tableBuku.setModel((TableModel) object);
	}

	private void InsertDataBuku(Object object) throws IOException, ClassNotFoundException {
		JOptionPane.showMessageDialog(null, object.toString());
		LoadTableBuku(tcpClient.send("requestDataBuku"));
		LoadTableDataBukuHistori(tcpClient.send("requestDataBuku"));
		ClearTextFieldBuku();
	}

	private void UpdateDataBuku(Object object) throws IOException, ClassNotFoundException {
		JOptionPane.showMessageDialog(null, object.toString());
		LoadTableBuku(tcpClient.send("requestDataBuku"));
		LoadTableDataBukuHistori(tcpClient.send("requestDataBuku"));
		ClearTextFieldBuku();
	}

	private void DeleteDataBuku(Object object) throws IOException, ClassNotFoundException {
		JOptionPane.showMessageDialog(null, object.toString());
		LoadTableBuku(tcpClient.send("requestDataBuku"));
		LoadTableDataBukuHistori(tcpClient.send("requestDataBuku"));
		ClearTextFieldBuku();
	}

	private void LoadTableAnggota(Object object) {
		tableAnggota.setModel((TableModel) object);
	}

	private void LoadCariTableAnggota(Object object) {
		tableAnggota.setModel((TableModel) object);
	}

	private void InsertDataAnggota(Object object) throws IOException, ClassNotFoundException {
		JOptionPane.showMessageDialog(null, object.toString());
		LoadTableAnggota(tcpClient.send("requestDataAnggota"));
		LoadTableDataAnggotaHistori(tcpClient.send("requestDataAnggota"));
		ClearTextFieldAnggota();
	}

	private void UpdateDataAnggota(Object object) throws IOException, ClassNotFoundException {
		JOptionPane.showMessageDialog(null, object.toString());
		LoadTableAnggota(tcpClient.send("requestDataAnggota"));
		LoadTableDataAnggotaHistori(tcpClient.send("requestDataAnggota"));
		ClearTextFieldAnggota();
	}

	private void DeleteDataAnggota(Object object) throws IOException, ClassNotFoundException {
		JOptionPane.showMessageDialog(null, object.toString());
		LoadTableAnggota(tcpClient.send("requestDataAnggota"));
		LoadTableDataAnggotaHistori(tcpClient.send("requestDataAnggota"));
		ClearTextFieldAnggota();
	}

	private void LoadTablePeminjaman(Object object) {
		tablePeminjaman.setModel((TableModel) object);
	}

	private void LoadCariTablePeminjaman(Object object) {
		tablePeminjaman.setModel((TableModel) object);
	}

	private void InsertDataPeminjaman(Object object) throws IOException, ClassNotFoundException {
		JOptionPane.showMessageDialog(null, object.toString());
		LoadTablePeminjaman(tcpClient.send("requestDataPeminjaman"));
		ClearTextFieldPeminjaman();
	}

	private void LoadTotalHariDenda(Object object) {
		Integer totalHariDenda = (Integer) object;
		lblTotalHariDenda.setText(totalHariDenda.toString() + " Hari");
		lblTotalHargaDenda.setText("Rp " + totalHariDenda * 1000 + ",00");
	}

	private int LoadJumlahStokBuku(Object object) {
		return (int) object;
	}

	private int LoadCekKodeBuku(Object object) {
		return (int) object;
	}

	private int LoadCekKodeAnggota(Object object) {
		return (int) object;
	}

	private int LoadCekTotalPinjamAnggota(Object object) {
		return (int) object;
	}

	private void LoadKembaliBuku(Object object) throws IOException, ClassNotFoundException {
		JOptionPane.showMessageDialog(null, object.toString());
		LoadTablePeminjaman(tcpClient.send("requestDataPeminjaman"));
	}

	private void LoadTableHistori(Object object) {
		tableHistoriPeminjaman.setModel((TableModel) object);
	}

	private void LoadCariTableHistori(Object object) {
		tableHistoriPeminjaman.setModel((TableModel) object);
	}

	private void LoadInformasiBuku(Object object) {
		Vector<Object> info = (Vector<Object>) object;
		lblJudulBukuInfo.setText((String) info.get(0));
		lblPenulisInfo.setText((String) info.get(1));
		lblPenerbitInfo.setText((String) info.get(2));
		lblTahunTerbitInfo.setText((String) info.get(3));
		lblNomorRakInfo.setText((String) info.get(4));

	}

	private void LoadInformasiAnggota(Object object) {
		Vector<Object> info = (Vector<Object>) object;
		lblNamaInfo.setText((String) info.get(0));
		lblAlamatInfo.setText((String) info.get(1));
		lblTeleponInfo.setText((String) info.get(2));
		lblEmailInfo.setText((String) info.get(3));
	}

	private void LoadTableDataAnggotaHistori(Object object) {
		tableDataAnggotaHistori.setModel((TableModel) object);
	}

	private void LoadCariTableDataAnggotaHistori(Object object) {
		tableDataAnggotaHistori.setModel((TableModel) object);
	}

	private void LoadTableHistoriAnggota(Object object) {
		tableHistoriAnggota.setModel((TableModel) object);
	}

	private void LoadTableDataBukuHistori(Object object) {
		tableDataBukuHistori.setModel((TableModel) object);
	}

	private void LoadCariTableDataBukuHistori(Object object) {
		tableDataBukuHistori.setModel((TableModel) object);
	}

	private void LoadTableHistoriBuku(Object object) {
		tableHistoriBuku.setModel((TableModel) object);
	}

	private void LoadAllTable() {
		try {
			LoadTableBuku(tcpClient.send("requestDataBuku"));
			LoadTableAnggota(tcpClient.send("requestDataAnggota"));
			LoadTablePeminjaman(tcpClient.send("requestDataPeminjaman"));
			LoadTableHistori(tcpClient.send("requestDataHistori"));
			LoadTableDataAnggotaHistori(tcpClient.send("requestDataAnggota"));
			LoadTableDataBukuHistori(tcpClient.send("requestDataBuku"));
		} catch (IOException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	

	private void initSwingControl() {

		panelJudul = new javax.swing.JPanel();
		lblJudul = new javax.swing.JLabel();
		panelMenuUtama = new javax.swing.JPanel();
		tabMenuUtama = new javax.swing.JTabbedPane();
		panelInventoriBuku = new javax.swing.JPanel();
		panelCariBuku = new javax.swing.JPanel();
		lblCariBuku = new javax.swing.JLabel();
		cbCariBuku = new javax.swing.JComboBox<>();
		txtCariBuku = new javax.swing.JTextField();
		panelTabelBuku = new javax.swing.JPanel();
		scrollBuku = new javax.swing.JScrollPane();
		tableBuku = new javax.swing.JTable();
		panelRecordBuku = new javax.swing.JPanel();
		lblJudulBuku = new javax.swing.JLabel();
		txtJudulBuku = new javax.swing.JTextField();
		lblPenulis = new javax.swing.JLabel();
		txtPenulis = new javax.swing.JTextField();
		lblPenerbit = new javax.swing.JLabel();
		txtPenerbit = new javax.swing.JTextField();
		lblTahunTerbit = new javax.swing.JLabel();
		txtTahunTerbit = new javax.swing.JTextField();
		lblNomorRak = new javax.swing.JLabel();
		txtNomorRak = new javax.swing.JTextField();
		lblJumlahBuku = new javax.swing.JLabel();
		txtJumlahBuku = new javax.swing.JTextField();
		panelButtonBuku = new javax.swing.JPanel();
		btnTambahBuku = new javax.swing.JButton();
		btnEditBuku = new javax.swing.JButton();
		btnHapusBuku = new javax.swing.JButton();
		btnResetBuku = new javax.swing.JButton();
		panelAnggota = new javax.swing.JPanel();
		panelCariAnggota = new javax.swing.JPanel();
		lblCariAnggota = new javax.swing.JLabel();
		cbCariAnggota = new javax.swing.JComboBox<>();
		txtCariAnggota = new javax.swing.JTextField();
		panelTabelAnggota = new javax.swing.JPanel();
		scrollAnggota = new javax.swing.JScrollPane();
		tableAnggota = new javax.swing.JTable();
		panelRecordAnggota = new javax.swing.JPanel();
		lblNamaAnggota = new javax.swing.JLabel();
		txtNamaAnggota = new javax.swing.JTextField();
		lblAlamat = new javax.swing.JLabel();
		txtAlamat = new javax.swing.JTextField();
		lblNomorTelepon = new javax.swing.JLabel();
		txtNomorTelepon = new javax.swing.JTextField();
		lblEmail = new javax.swing.JLabel();
		txtEmail = new javax.swing.JTextField();
		panelButtonAnggota = new javax.swing.JPanel();
		btnTambahAnggota = new javax.swing.JButton();
		btnEditAnggota = new javax.swing.JButton();
		btnHapusAnggota = new javax.swing.JButton();
		btnResetAnggota = new javax.swing.JButton();
		panelPeminjaman = new javax.swing.JPanel();
		panelCariPeminjaman = new javax.swing.JPanel();
		lblCariPeminjaman = new javax.swing.JLabel();
		cbCariPeminjaman = new javax.swing.JComboBox<>();
		txtCariPeminjaman = new javax.swing.JTextField();
		panelTabelPeminjaman = new javax.swing.JPanel();
		scrollPeminjaman = new javax.swing.JScrollPane();
		tablePeminjaman = new javax.swing.JTable();
		panelRecordPeminjaman = new javax.swing.JPanel();
		panelDataPinjamBuku = new javax.swing.JPanel();
		lblKodeBuku = new javax.swing.JLabel();
		txtKodeBuku = new javax.swing.JTextField();
		lblKodeAnggota = new javax.swing.JLabel();
		txtKodeAnggota = new javax.swing.JTextField();
		lblTanggalPinjam = new javax.swing.JLabel();
		dcTanggalPinjam = new com.toedter.calendar.JDateChooser();
		lblTanggalBatasPinjam = new javax.swing.JLabel();
		dcTanggalBatasPinjam = new com.toedter.calendar.JDateChooser();
		panelDataKembaliBuku = new javax.swing.JPanel();
		lblJudulTotalHariDenda = new javax.swing.JLabel();
		lblTotalHariDenda = new javax.swing.JLabel();
		lblJudulTotalHargaDenda = new javax.swing.JLabel();
		lblTotalHargaDenda = new javax.swing.JLabel();
		PanelButtonPeminjaman = new javax.swing.JPanel();
		btnPeminjaman = new javax.swing.JButton();
		btnPengembalian = new javax.swing.JButton();
		btnReport = new javax.swing.JButton();
		btnResetPeminjaman = new javax.swing.JButton();
		panelHistoriPeminjaman = new javax.swing.JPanel();
		panelCariHistoriPeminjaman = new javax.swing.JPanel();
		lblCariHistoriPeminjaman = new javax.swing.JLabel();
		cbCariHistoriPeminjaman = new javax.swing.JComboBox<>();
		dcCariHistoriPeminjaman = new com.toedter.calendar.JDateChooser();
		btnCariHistoriPeminjaman = new javax.swing.JButton();
		panelTabelHistoriPeminjaman = new javax.swing.JPanel();
		scrollHistoriPeminjaman = new javax.swing.JScrollPane();
		tableHistoriPeminjaman = new javax.swing.JTable();
		PanelButtonReportHistoriPeminjaman = new javax.swing.JPanel();
		btnReportHistoriPeminjaman = new javax.swing.JButton();
		panelInformasiHistoriPeminjaman = new javax.swing.JPanel();
		panelInformasiBuku = new javax.swing.JPanel();
		lbljudulJudulBukuInfo = new javax.swing.JLabel();
		lblJudulBukuInfo = new javax.swing.JLabel();
		lbljudulPenulisInfo = new javax.swing.JLabel();
		lblPenulisInfo = new javax.swing.JLabel();
		lbljudulPenerbitInfo = new javax.swing.JLabel();
		lblPenerbitInfo = new javax.swing.JLabel();
		lbljudulTahunTerbitInfo = new javax.swing.JLabel();
		lblTahunTerbitInfo = new javax.swing.JLabel();
		lbljudulNomorRakInfo = new javax.swing.JLabel();
		lblNomorRakInfo = new javax.swing.JLabel();
		panelInformasiAnggota = new javax.swing.JPanel();
		lbljudulNamaInfo = new javax.swing.JLabel();
		lblNamaInfo = new javax.swing.JLabel();
		lbljudulAlamatInfo = new javax.swing.JLabel();
		lblAlamatInfo = new javax.swing.JLabel();
		lbljudulTeleponInfo = new javax.swing.JLabel();
		lblTeleponInfo = new javax.swing.JLabel();
		lbljudulEmailInfo = new javax.swing.JLabel();
		lblEmailInfo = new javax.swing.JLabel();
		panelHistoriAnggota = new javax.swing.JPanel();
		panelCariHistoriAnggota = new javax.swing.JPanel();
		lblCariAnggotaHistori = new javax.swing.JLabel();
		cbCariAnggotaHistori = new javax.swing.JComboBox<>();
		txtCariAnggotaHistori = new javax.swing.JTextField();
		panelTabelDataAnggotaHistori = new javax.swing.JPanel();
		scrollDataAnggotaHistori = new javax.swing.JScrollPane();
		tableDataAnggotaHistori = new javax.swing.JTable();
		panelAreaTabelHistoriAnggota = new javax.swing.JPanel();
		panelTabelHistoriAnggota = new javax.swing.JPanel();
		scrollHistoriAnggota = new javax.swing.JScrollPane();
		tableHistoriAnggota = new javax.swing.JTable();
		panelButtonReportHistoriAnggota = new javax.swing.JPanel();
		btnReportHistoriAnggota = new javax.swing.JButton();
		panelHistoriBuku = new javax.swing.JPanel();
		panelCariHistoriBuku = new javax.swing.JPanel();
		lblCariBukuHistori = new javax.swing.JLabel();
		cbCariBukuHistori = new javax.swing.JComboBox<>();
		txtCariBukuHistori = new javax.swing.JTextField();
		panelTabelDataBukuHistori = new javax.swing.JPanel();
		scrollDataBukuHistori = new javax.swing.JScrollPane();
		tableDataBukuHistori = new javax.swing.JTable();
		panelAreaTabelHistoriBuku = new javax.swing.JPanel();
		panelTabelHistoriBuku = new javax.swing.JPanel();
		scollHistoriBuku = new javax.swing.JScrollPane();
		tableHistoriBuku = new javax.swing.JTable();
		panelButtonReportHistoriBuku = new javax.swing.JPanel();
		btnReportHistoriBuku = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Sistem Perpustakaan XYZ");
		getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

		panelJudul.setBackground(new java.awt.Color(204, 204, 204));
		panelJudul.setPreferredSize(new java.awt.Dimension(612, 50));

		lblJudul.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblJudul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perpustakaanclient/library-icon.png")));
		lblJudul.setText("Sistem Perpustakaan XYZ");
		panelJudul.add(lblJudul);

		getContentPane().add(panelJudul);

		panelMenuUtama.setLayout(new java.awt.BorderLayout());

		panelInventoriBuku.setLayout(new javax.swing.BoxLayout(panelInventoriBuku, javax.swing.BoxLayout.Y_AXIS));

		panelCariBuku.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian"));
		panelCariBuku.setPreferredSize(new java.awt.Dimension(607, 70));
		panelCariBuku.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

		lblCariBuku.setText("Cari Buku");
		panelCariBuku.add(lblCariBuku);

		cbCariBuku.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Kode Buku", "Judul Buku", "Penulis", "Penerbit", "Tahun Terbit", "Nomor Rak" }));
		panelCariBuku.add(cbCariBuku);

		txtCariBuku.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtCariBukuKeyReleased(evt);
			}
		});
		panelCariBuku.add(txtCariBuku);

		panelInventoriBuku.add(panelCariBuku);

		panelTabelBuku.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Buku"));
		panelTabelBuku.setPreferredSize(new java.awt.Dimension(539, 150));
		panelTabelBuku.setLayout(new java.awt.GridLayout(1, 1));

		tableBuku
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		tableBuku.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tableBuku.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableBukuMouseClicked(evt);
			}
		});
		scrollBuku.setViewportView(tableBuku);

		panelTabelBuku.add(scrollBuku);

		panelInventoriBuku.add(panelTabelBuku);

		panelRecordBuku.setBorder(javax.swing.BorderFactory.createTitledBorder("Buku Record Editor"));
		panelRecordBuku.setLayout(new java.awt.GridLayout(6, 2, 10, 10));

		lblJudulBuku.setText("Judul Buku");
		panelRecordBuku.add(lblJudulBuku);
		panelRecordBuku.add(txtJudulBuku);

		lblPenulis.setText("Penulis");
		panelRecordBuku.add(lblPenulis);
		panelRecordBuku.add(txtPenulis);

		lblPenerbit.setText("Penerbit");
		panelRecordBuku.add(lblPenerbit);
		panelRecordBuku.add(txtPenerbit);

		lblTahunTerbit.setText("Tahun Terbit");
		panelRecordBuku.add(lblTahunTerbit);
		panelRecordBuku.add(txtTahunTerbit);

		lblNomorRak.setText("Nomor Rak");
		panelRecordBuku.add(lblNomorRak);
		panelRecordBuku.add(txtNomorRak);

		lblJumlahBuku.setText("Jumlah Buku");
		panelRecordBuku.add(lblJumlahBuku);
		panelRecordBuku.add(txtJumlahBuku);

		panelInventoriBuku.add(panelRecordBuku);

		panelButtonBuku.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));
		panelButtonBuku.setLayout(new java.awt.GridLayout(1, 4, 10, 10));

		btnTambahBuku.setText("Tambah");
		btnTambahBuku.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTambahBukuActionPerformed(evt);
			}
		});
		panelButtonBuku.add(btnTambahBuku);

		btnEditBuku.setText("Edit");
		btnEditBuku.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEditBukuActionPerformed(evt);
			}
		});
		panelButtonBuku.add(btnEditBuku);

		btnHapusBuku.setText("Hapus");
		btnHapusBuku.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHapusBukuActionPerformed(evt);
			}
		});
		panelButtonBuku.add(btnHapusBuku);

		btnResetBuku.setText("Reset");
		btnResetBuku.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnResetBukuActionPerformed(evt);
			}
		});
		panelButtonBuku.add(btnResetBuku);

		panelInventoriBuku.add(panelButtonBuku);

		tabMenuUtama.addTab("Inventori Buku", panelInventoriBuku);

		panelAnggota.setLayout(new javax.swing.BoxLayout(panelAnggota, javax.swing.BoxLayout.Y_AXIS));

		panelCariAnggota.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian"));
		panelCariAnggota.setPreferredSize(new java.awt.Dimension(577, 70));
		panelCariAnggota.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

		lblCariAnggota.setText("Cari Anggota");
		panelCariAnggota.add(lblCariAnggota);

		cbCariAnggota.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Kode Anggota", "Nama Anggota", "Email" }));
		panelCariAnggota.add(cbCariAnggota);

		txtCariAnggota.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtCariAnggotaKeyReleased(evt);
			}
		});
		panelCariAnggota.add(txtCariAnggota);

		panelAnggota.add(panelCariAnggota);

		panelTabelAnggota.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Anggota"));
		panelTabelAnggota.setPreferredSize(new java.awt.Dimension(577, 200));
		panelTabelAnggota.setLayout(new java.awt.GridLayout(1, 1));

		tableAnggota
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		tableAnggota.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tableAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableAnggotaMouseClicked(evt);
			}
		});
		scrollAnggota.setViewportView(tableAnggota);

		panelTabelAnggota.add(scrollAnggota);

		panelAnggota.add(panelTabelAnggota);

		panelRecordAnggota.setBorder(javax.swing.BorderFactory.createTitledBorder("Anggota Record Editor"));
		panelRecordAnggota.setLayout(new java.awt.GridLayout(4, 2, 10, 10));

		lblNamaAnggota.setText("Nama Anggota");
		panelRecordAnggota.add(lblNamaAnggota);
		panelRecordAnggota.add(txtNamaAnggota);

		lblAlamat.setText("Alamat");
		panelRecordAnggota.add(lblAlamat);
		panelRecordAnggota.add(txtAlamat);

		lblNomorTelepon.setText("Nomor Telepon");
		panelRecordAnggota.add(lblNomorTelepon);
		panelRecordAnggota.add(txtNomorTelepon);

		lblEmail.setText("Email");
		panelRecordAnggota.add(lblEmail);
		panelRecordAnggota.add(txtEmail);

		panelAnggota.add(panelRecordAnggota);

		panelButtonAnggota.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));
		panelButtonAnggota.setLayout(new java.awt.GridLayout(1, 4, 10, 10));

		btnTambahAnggota.setText("Tambah");
		btnTambahAnggota.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTambahAnggotaActionPerformed(evt);
			}
		});
		panelButtonAnggota.add(btnTambahAnggota);

		btnEditAnggota.setText("Edit");
		btnEditAnggota.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEditAnggotaActionPerformed(evt);
			}
		});
		panelButtonAnggota.add(btnEditAnggota);

		btnHapusAnggota.setText("Hapus");
		btnHapusAnggota.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHapusAnggotaActionPerformed(evt);
			}
		});
		panelButtonAnggota.add(btnHapusAnggota);

		btnResetAnggota.setText("Reset");
		btnResetAnggota.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnResetAnggotaActionPerformed(evt);
			}
		});
		panelButtonAnggota.add(btnResetAnggota);

		panelAnggota.add(panelButtonAnggota);

		tabMenuUtama.addTab("Anggota", panelAnggota);

		panelPeminjaman.setLayout(new javax.swing.BoxLayout(panelPeminjaman, javax.swing.BoxLayout.Y_AXIS));

		panelCariPeminjaman.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian"));
		panelCariPeminjaman.setPreferredSize(new java.awt.Dimension(311, 70));
		panelCariPeminjaman.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

		lblCariPeminjaman.setText("Cari Peminjaman");
		panelCariPeminjaman.add(lblCariPeminjaman);

		cbCariPeminjaman.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Kode Pinjam", "Kode Buku", "Kode Anggota" }));
		panelCariPeminjaman.add(cbCariPeminjaman);

		txtCariPeminjaman.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtCariPeminjamanKeyReleased(evt);
			}
		});
		panelCariPeminjaman.add(txtCariPeminjaman);

		panelPeminjaman.add(panelCariPeminjaman);

		panelTabelPeminjaman.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Peminjaman"));
		panelTabelPeminjaman.setPreferredSize(new java.awt.Dimension(464, 200));
		panelTabelPeminjaman.setLayout(new java.awt.GridLayout(1, 1));

		tablePeminjaman
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		tablePeminjaman.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tablePeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tablePeminjamanMouseClicked(evt);
			}
		});
		scrollPeminjaman.setViewportView(tablePeminjaman);

		panelTabelPeminjaman.add(scrollPeminjaman);

		panelPeminjaman.add(panelTabelPeminjaman);

		panelRecordPeminjaman.setLayout(new javax.swing.BoxLayout(panelRecordPeminjaman, javax.swing.BoxLayout.X_AXIS));

		panelDataPinjamBuku.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pinjam Buku"));
		panelDataPinjamBuku.setLayout(new java.awt.GridLayout(4, 2, 10, 10));

		lblKodeBuku.setText("Kode Buku");
		panelDataPinjamBuku.add(lblKodeBuku);
		panelDataPinjamBuku.add(txtKodeBuku);

		lblKodeAnggota.setText("Kode Anggota");
		panelDataPinjamBuku.add(lblKodeAnggota);
		panelDataPinjamBuku.add(txtKodeAnggota);

		lblTanggalPinjam.setText("Tanggal Pinjam");
		panelDataPinjamBuku.add(lblTanggalPinjam);

		dcTanggalPinjam.setDateFormatString("dd-MM-yyyy");
		panelDataPinjamBuku.add(dcTanggalPinjam);

		lblTanggalBatasPinjam.setText("Tanggal Batas Pinjam");
		panelDataPinjamBuku.add(lblTanggalBatasPinjam);

		dcTanggalBatasPinjam.setDateFormatString("dd-MM-yyyy");
		panelDataPinjamBuku.add(dcTanggalBatasPinjam);

		panelRecordPeminjaman.add(panelDataPinjamBuku);

		panelDataKembaliBuku.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Kembali Buku"));
		panelDataKembaliBuku.setLayout(new java.awt.GridLayout(2, 2, 50, 10));

		lblJudulTotalHariDenda.setText("Total Hari Denda");
		panelDataKembaliBuku.add(lblJudulTotalHariDenda);

		lblTotalHariDenda.setText("-");
		panelDataKembaliBuku.add(lblTotalHariDenda);

		lblJudulTotalHargaDenda.setText("Total Harga Denda");
		panelDataKembaliBuku.add(lblJudulTotalHargaDenda);

		lblTotalHargaDenda.setText("-");
		panelDataKembaliBuku.add(lblTotalHargaDenda);

		panelRecordPeminjaman.add(panelDataKembaliBuku);

		panelPeminjaman.add(panelRecordPeminjaman);

		PanelButtonPeminjaman.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));
		PanelButtonPeminjaman.setLayout(new java.awt.GridLayout(1, 4, 10, 10));

		btnPeminjaman.setText("Peminjaman");
		btnPeminjaman.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPeminjamanActionPerformed(evt);
			}
		});
		PanelButtonPeminjaman.add(btnPeminjaman);

		btnPengembalian.setText("Pengembalian");
		btnPengembalian.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPengembalianActionPerformed(evt);
			}
		});
		PanelButtonPeminjaman.add(btnPengembalian);

		btnReport.setText("Report");
		btnReport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnReportActionPerformed(evt);
			}
		});
		PanelButtonPeminjaman.add(btnReport);

		btnResetPeminjaman.setText("Reset");
		btnResetPeminjaman.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnResetPeminjamanActionPerformed(evt);
			}
		});
		PanelButtonPeminjaman.add(btnResetPeminjaman);

		panelPeminjaman.add(PanelButtonPeminjaman);

		tabMenuUtama.addTab("Sistem Peminjaman", panelPeminjaman);

		panelHistoriPeminjaman
				.setLayout(new javax.swing.BoxLayout(panelHistoriPeminjaman, javax.swing.BoxLayout.Y_AXIS));

		panelCariHistoriPeminjaman.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian"));
		panelCariHistoriPeminjaman.setMinimumSize(new java.awt.Dimension(450, 50));
		panelCariHistoriPeminjaman.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

		lblCariHistoriPeminjaman.setText("Cari Histori");
		panelCariHistoriPeminjaman.add(lblCariHistoriPeminjaman);

		cbCariHistoriPeminjaman
				.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tanggal Pinjam", "Tanggal Kembali" }));
		panelCariHistoriPeminjaman.add(cbCariHistoriPeminjaman);

		dcCariHistoriPeminjaman.setDateFormatString("dd-MM-yyyy");
		panelCariHistoriPeminjaman.add(dcCariHistoriPeminjaman);

		btnCariHistoriPeminjaman.setText("Cari");
		btnCariHistoriPeminjaman.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCariHistoriPeminjamanActionPerformed(evt);
			}
		});
		panelCariHistoriPeminjaman.add(btnCariHistoriPeminjaman);

		panelHistoriPeminjaman.add(panelCariHistoriPeminjaman);

		panelTabelHistoriPeminjaman.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Histori"));
		panelTabelHistoriPeminjaman.setPreferredSize(new java.awt.Dimension(464, 300));
		panelTabelHistoriPeminjaman
				.setLayout(new javax.swing.BoxLayout(panelTabelHistoriPeminjaman, javax.swing.BoxLayout.Y_AXIS));

		tableHistoriPeminjaman
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		tableHistoriPeminjaman.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tableHistoriPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableHistoriPeminjamanMouseClicked(evt);
			}
		});
		scrollHistoriPeminjaman.setViewportView(tableHistoriPeminjaman);

		panelTabelHistoriPeminjaman.add(scrollHistoriPeminjaman);

		PanelButtonReportHistoriPeminjaman.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

		btnReportHistoriPeminjaman.setText("Cetak Report");
		btnReportHistoriPeminjaman.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnReportHistoriPeminjamanActionPerformed(evt);
			}
		});
		PanelButtonReportHistoriPeminjaman.add(btnReportHistoriPeminjaman);

		panelTabelHistoriPeminjaman.add(PanelButtonReportHistoriPeminjaman);

		panelHistoriPeminjaman.add(panelTabelHistoriPeminjaman);

		panelInformasiHistoriPeminjaman.setBorder(javax.swing.BorderFactory.createTitledBorder("Informasi Histori"));
		panelInformasiHistoriPeminjaman
				.setLayout(new javax.swing.BoxLayout(panelInformasiHistoriPeminjaman, javax.swing.BoxLayout.LINE_AXIS));

		panelInformasiBuku.setBorder(javax.swing.BorderFactory.createTitledBorder("Informasi Buku"));
		panelInformasiBuku.setLayout(new java.awt.GridLayout(5, 2));

		lbljudulJudulBukuInfo.setText("Judul Buku");
		panelInformasiBuku.add(lbljudulJudulBukuInfo);

		lblJudulBukuInfo.setText("-");
		panelInformasiBuku.add(lblJudulBukuInfo);

		lbljudulPenulisInfo.setText("Penulis");
		panelInformasiBuku.add(lbljudulPenulisInfo);

		lblPenulisInfo.setText("-");
		panelInformasiBuku.add(lblPenulisInfo);

		lbljudulPenerbitInfo.setText("Penerbit");
		panelInformasiBuku.add(lbljudulPenerbitInfo);

		lblPenerbitInfo.setText("-");
		panelInformasiBuku.add(lblPenerbitInfo);

		lbljudulTahunTerbitInfo.setText("Tahun Terbit");
		panelInformasiBuku.add(lbljudulTahunTerbitInfo);

		lblTahunTerbitInfo.setText("-");
		panelInformasiBuku.add(lblTahunTerbitInfo);

		lbljudulNomorRakInfo.setText("Nomor Rak");
		panelInformasiBuku.add(lbljudulNomorRakInfo);

		lblNomorRakInfo.setText("-");
		panelInformasiBuku.add(lblNomorRakInfo);

		panelInformasiHistoriPeminjaman.add(panelInformasiBuku);

		panelInformasiAnggota.setBorder(javax.swing.BorderFactory.createTitledBorder("Informasi Anggota"));
		panelInformasiAnggota.setLayout(new java.awt.GridLayout(4, 2, 10, 10));

		lbljudulNamaInfo.setText("Nama");
		panelInformasiAnggota.add(lbljudulNamaInfo);

		lblNamaInfo.setText("-");
		panelInformasiAnggota.add(lblNamaInfo);

		lbljudulAlamatInfo.setText("Alamat");
		panelInformasiAnggota.add(lbljudulAlamatInfo);

		lblAlamatInfo.setText("-");
		panelInformasiAnggota.add(lblAlamatInfo);

		lbljudulTeleponInfo.setText("Telepon");
		panelInformasiAnggota.add(lbljudulTeleponInfo);

		lblTeleponInfo.setText("-");
		panelInformasiAnggota.add(lblTeleponInfo);

		lbljudulEmailInfo.setText("Email");
		panelInformasiAnggota.add(lbljudulEmailInfo);

		lblEmailInfo.setText("-");
		panelInformasiAnggota.add(lblEmailInfo);

		panelInformasiHistoriPeminjaman.add(panelInformasiAnggota);

		panelHistoriPeminjaman.add(panelInformasiHistoriPeminjaman);

		tabMenuUtama.addTab("Histori Peminjaman", panelHistoriPeminjaman);

		panelHistoriAnggota.setLayout(new javax.swing.BoxLayout(panelHistoriAnggota, javax.swing.BoxLayout.Y_AXIS));

		panelCariHistoriAnggota.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian"));
		panelCariHistoriAnggota.setPreferredSize(new java.awt.Dimension(320, 50));
		panelCariHistoriAnggota.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

		lblCariAnggotaHistori.setText("Cari Anggota");
		panelCariHistoriAnggota.add(lblCariAnggotaHistori);

		cbCariAnggotaHistori.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Kode Anggota", "Nama Anggota", "Email" }));
		panelCariHistoriAnggota.add(cbCariAnggotaHistori);

		txtCariAnggotaHistori.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtCariAnggotaHistoriKeyReleased(evt);
			}
		});
		panelCariHistoriAnggota.add(txtCariAnggotaHistori);

		panelHistoriAnggota.add(panelCariHistoriAnggota);

		panelTabelDataAnggotaHistori.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Anggota"));
		panelTabelDataAnggotaHistori.setPreferredSize(new java.awt.Dimension(464, 200));
		panelTabelDataAnggotaHistori.setLayout(new java.awt.GridLayout(1, 0));

		tableDataAnggotaHistori
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		tableDataAnggotaHistori.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tableDataAnggotaHistori.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableDataAnggotaHistoriMouseClicked(evt);
			}
		});
		scrollDataAnggotaHistori.setViewportView(tableDataAnggotaHistori);

		panelTabelDataAnggotaHistori.add(scrollDataAnggotaHistori);

		panelHistoriAnggota.add(panelTabelDataAnggotaHistori);

		panelAreaTabelHistoriAnggota.setBorder(javax.swing.BorderFactory.createTitledBorder("Histori Anggota"));
		panelAreaTabelHistoriAnggota.setPreferredSize(new java.awt.Dimension(464, 200));
		panelAreaTabelHistoriAnggota
				.setLayout(new javax.swing.BoxLayout(panelAreaTabelHistoriAnggota, javax.swing.BoxLayout.Y_AXIS));

		panelTabelHistoriAnggota.setLayout(new java.awt.GridLayout(1, 0));

		tableHistoriAnggota
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		scrollHistoriAnggota.setViewportView(tableHistoriAnggota);

		panelTabelHistoriAnggota.add(scrollHistoriAnggota);

		panelAreaTabelHistoriAnggota.add(panelTabelHistoriAnggota);

		panelButtonReportHistoriAnggota.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

		btnReportHistoriAnggota.setText("Cetak Report");
		btnReportHistoriAnggota.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnReportHistoriAnggotaActionPerformed(evt);
			}
		});
		panelButtonReportHistoriAnggota.add(btnReportHistoriAnggota);

		panelAreaTabelHistoriAnggota.add(panelButtonReportHistoriAnggota);

		panelHistoriAnggota.add(panelAreaTabelHistoriAnggota);

		tabMenuUtama.addTab("Histori Anggota", panelHistoriAnggota);

		panelHistoriBuku.setLayout(new javax.swing.BoxLayout(panelHistoriBuku, javax.swing.BoxLayout.Y_AXIS));

		panelCariHistoriBuku.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian"));
		panelCariHistoriBuku.setPreferredSize(new java.awt.Dimension(290, 50));
		panelCariHistoriBuku.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

		lblCariBukuHistori.setText("Cari Buku");
		panelCariHistoriBuku.add(lblCariBukuHistori);

		cbCariBukuHistori.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Kode Buku", "Judul Buku", "Penulis", "Penerbit", "Tahun Terbit", "Nomor Rak" }));
		panelCariHistoriBuku.add(cbCariBukuHistori);

		txtCariBukuHistori.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtCariBukuHistoriKeyReleased(evt);
			}
		});
		panelCariHistoriBuku.add(txtCariBukuHistori);

		panelHistoriBuku.add(panelCariHistoriBuku);

		panelTabelDataBukuHistori.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Buku"));
		panelTabelDataBukuHistori.setPreferredSize(new java.awt.Dimension(464, 200));
		panelTabelDataBukuHistori.setLayout(new java.awt.GridLayout(1, 0));

		tableDataBukuHistori
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		tableDataBukuHistori.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tableDataBukuHistori.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableDataBukuHistoriMouseClicked(evt);
			}
		});
		scrollDataBukuHistori.setViewportView(tableDataBukuHistori);

		panelTabelDataBukuHistori.add(scrollDataBukuHistori);

		panelHistoriBuku.add(panelTabelDataBukuHistori);

		panelAreaTabelHistoriBuku.setBorder(javax.swing.BorderFactory.createTitledBorder("Histori Buku"));
		panelAreaTabelHistoriBuku.setPreferredSize(new java.awt.Dimension(464, 200));
		panelAreaTabelHistoriBuku
				.setLayout(new javax.swing.BoxLayout(panelAreaTabelHistoriBuku, javax.swing.BoxLayout.Y_AXIS));

		panelTabelHistoriBuku.setLayout(new java.awt.GridLayout(1, 0));

		tableHistoriBuku
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		scollHistoriBuku.setViewportView(tableHistoriBuku);

		panelTabelHistoriBuku.add(scollHistoriBuku);

		panelAreaTabelHistoriBuku.add(panelTabelHistoriBuku);

		panelButtonReportHistoriBuku.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

		btnReportHistoriBuku.setText("Cetak Report");
		btnReportHistoriBuku.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnReportHistoriBukuActionPerformed(evt);
			}
		});
		panelButtonReportHistoriBuku.add(btnReportHistoriBuku);

		panelAreaTabelHistoriBuku.add(panelButtonReportHistoriBuku);

		panelHistoriBuku.add(panelAreaTabelHistoriBuku);

		tabMenuUtama.addTab("Histori Buku", panelHistoriBuku);

		panelMenuUtama.add(tabMenuUtama, java.awt.BorderLayout.PAGE_START);

		getContentPane().add(panelMenuUtama);

		pack();
	}

	private void btnReportHistoriBukuActionPerformed(java.awt.event.ActionEvent evt) {

		if (tableHistoriBuku.getRowCount() > 1) {
			try {
				Document doc = new Document();
				PdfWriter.getInstance(doc, new FileOutputStream("report-histori-buku.pdf"));
				doc.open();
				doc.add(new Paragraph("SISTEM PERPUSTAKAAN XYZ",
						FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD)));
				doc.add(new Paragraph(
						"----------------------------------------------------------------------------------------------------------------------------------"));
				doc.add(new Paragraph("Histori Buku", FontFactory.getFont(FontFactory.TIMES_BOLD, 12, Font.BOLD)));
				PdfPTable pdfTable = new PdfPTable(tableHistoriBuku.getColumnCount());
				PdfPTable pdfTableDataBuku = new PdfPTable(2);

				pdfTable.setWidthPercentage(100);
				// adding table headers
				for (int i = 0; i < tableHistoriBuku.getColumnCount(); i++) {
					pdfTable.addCell(tableHistoriBuku.getColumnName(i));
				}
				// extracting data from the JTable and inserting it to PdfPTable
				for (int rows = 0; rows < tableHistoriBuku.getRowCount(); rows++) {
					for (int cols = 0; cols < tableHistoriBuku.getColumnCount(); cols++) {
						pdfTable.addCell(tableHistoriBuku.getModel().getValueAt(rows, cols).toString());

					}
				}

				pdfTableDataBuku.setHorizontalAlignment(0);
				pdfTableDataBuku.setSpacingBefore(10);
				pdfTableDataBuku.setSpacingAfter(10);
				pdfTableDataBuku.getDefaultCell().setBorder(0);
				pdfTableDataBuku.setWidths(new int[] { 2, 8 });

				pdfTableDataBuku.addCell(new Phrase("Kode Buku"));
				pdfTableDataBuku.addCell(": " + DataBuku.get(0));
				pdfTableDataBuku.addCell(new Phrase("Judul Buku"));
				pdfTableDataBuku.addCell(": " + DataBuku.get(1));
				pdfTableDataBuku.addCell(new Phrase("Penulis"));
				pdfTableDataBuku.addCell(": " + DataBuku.get(2));
				pdfTableDataBuku.addCell(new Phrase("Penerbit"));
				pdfTableDataBuku.addCell(": " + DataBuku.get(3));
				pdfTableDataBuku.addCell(new Phrase("Tahun Terbit"));
				pdfTableDataBuku.addCell(": " + DataBuku.get(4));
				pdfTableDataBuku.addCell(new Phrase("Nomor Rak"));
				pdfTableDataBuku.addCell(": " + DataBuku.get(5));
				pdfTableDataBuku.addCell(new Phrase("Jumlah Buku"));
				pdfTableDataBuku.addCell(": " + DataBuku.get(6));

				pdfTable.setSpacingBefore((float) 20);
				pdfTable.setSpacingAfter((float) 10);
				pdfTable.spacingBefore();
				pdfTable.spacingAfter();
				doc.add(pdfTableDataBuku);
				doc.add(pdfTable);
				doc.close();
				JOptionPane.showMessageDialog(null, "Berhasil");
			} catch (DocumentException | FileNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Tidak Ada Record");
		}

	}

	private void tableDataBukuHistoriMouseClicked(java.awt.event.MouseEvent evt) {
		int row = tableDataBukuHistori.getSelectedRow();
		DataBuku.clear();
		DataBuku.add((String) tableDataBukuHistori.getValueAt(row, 0));
		DataBuku.add((String) tableDataBukuHistori.getValueAt(row, 1));
		DataBuku.add((String) tableDataBukuHistori.getValueAt(row, 2));
		DataBuku.add((String) tableDataBukuHistori.getValueAt(row, 3));
		DataBuku.add((String) tableDataBukuHistori.getValueAt(row, 4));
		DataBuku.add((String) tableDataBukuHistori.getValueAt(row, 5));
		DataBuku.add(tableDataBukuHistori.getValueAt(row, 6).toString());
		String data = "requestDataHistoriBuku#";
		data += tableDataBukuHistori.getValueAt(row, 0);
		try {
			LoadTableHistoriBuku(tcpClient.send(data));
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void txtCariBukuHistoriKeyReleased(java.awt.event.KeyEvent evt) {
		if (txtCariBukuHistori.getText().trim().equals("")) {
			try {
				LoadTableDataBukuHistori(tcpClient.send("requestDataBuku"));
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
				System.out.println(ex.getMessage());
			} catch (ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		} else {
			String data;
			data = "requestCariBuku#";
			data += cbCariBukuHistori.getSelectedItem().toString() + "#";
			data += txtCariBukuHistori.getText() + "#";
			try {
				LoadCariTableDataBukuHistori(tcpClient.send(data));
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
				System.out.println(ex.getMessage());
			} catch (ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private void btnReportHistoriAnggotaActionPerformed(java.awt.event.ActionEvent evt) {

		if (tableHistoriAnggota.getRowCount() > 1) {
			try {
				Document doc = new Document();
				PdfWriter.getInstance(doc, new FileOutputStream("report-histori-anggota.pdf"));
				doc.open();
				doc.add(new Paragraph("SISTEM PERPUSTAKAAN XYZ",
						FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD)));
				doc.add(new Paragraph(
						"----------------------------------------------------------------------------------------------------------------------------------"));
				doc.add(new Paragraph("Histori Anggota", FontFactory.getFont(FontFactory.TIMES_BOLD, 12, Font.BOLD)));
				PdfPTable pdfTable = new PdfPTable(tableHistoriAnggota.getColumnCount());
				PdfPTable pdfTableDataAnggota = new PdfPTable(2);

				pdfTable.setWidthPercentage(100);

				// adding table headers
				for (int i = 0; i < tableHistoriAnggota.getColumnCount(); i++) {
					pdfTable.addCell(tableHistoriAnggota.getColumnName(i));
				}
				// extracting data from the JTable and inserting it to PdfPTable
				for (int rows = 0; rows < tableHistoriAnggota.getRowCount(); rows++) {
					for (int cols = 0; cols < tableHistoriAnggota.getColumnCount(); cols++) {
						pdfTable.addCell(tableHistoriAnggota.getModel().getValueAt(rows, cols).toString());

					}
				}

				pdfTableDataAnggota.setHorizontalAlignment(0);
				pdfTableDataAnggota.setSpacingBefore(10);
				pdfTableDataAnggota.setSpacingAfter(10);
				pdfTableDataAnggota.getDefaultCell().setBorder(0);
				pdfTableDataAnggota.setWidths(new int[] { 2, 5 });

				pdfTableDataAnggota.addCell(new Phrase("Kode Anggota"));
				pdfTableDataAnggota.addCell(": " + DataAnggota.get(0));
				pdfTableDataAnggota.addCell(new Phrase("Nama Angggota"));
				pdfTableDataAnggota.addCell(": " + DataAnggota.get(1));
				pdfTableDataAnggota.addCell(new Phrase("Alamat"));
				pdfTableDataAnggota.addCell(": " + DataAnggota.get(2));
				pdfTableDataAnggota.addCell(new Phrase("Telepon"));
				pdfTableDataAnggota.addCell(": " + DataAnggota.get(3));
				pdfTableDataAnggota.addCell(new Phrase("Email"));
				pdfTableDataAnggota.addCell(": " + DataAnggota.get(4));

				pdfTable.setSpacingBefore((float) 20);
				pdfTable.setSpacingAfter((float) 10);
				pdfTable.spacingBefore();
				pdfTable.spacingAfter();
				doc.add(pdfTableDataAnggota);
				doc.add(pdfTable);
				doc.close();
				JOptionPane.showMessageDialog(null, "Berhasil");
			} catch (DocumentException | FileNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Tidak Ada Record");
		}

	}

	private void tableDataAnggotaHistoriMouseClicked(java.awt.event.MouseEvent evt) {

		int row = tableDataAnggotaHistori.getSelectedRow();
		DataAnggota.clear();
		DataAnggota.add((String) tableDataAnggotaHistori.getValueAt(row, 0));
		DataAnggota.add((String) tableDataAnggotaHistori.getValueAt(row, 1));
		DataAnggota.add((String) tableDataAnggotaHistori.getValueAt(row, 2));
		DataAnggota.add((String) tableDataAnggotaHistori.getValueAt(row, 3));
		DataAnggota.add((String) tableDataAnggotaHistori.getValueAt(row, 4));

		String data = "requestDataHistoriAnggota#";
		data += tableDataAnggotaHistori.getValueAt(row, 0);
		try {
			LoadTableHistoriAnggota(tcpClient.send(data));
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void txtCariAnggotaHistoriKeyReleased(java.awt.event.KeyEvent evt) {
		if (txtCariAnggotaHistori.getText().trim().equals("")) {
			try {
				LoadTableDataAnggotaHistori(tcpClient.send("requestDataAnggota"));
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
				System.out.println(ex.getMessage());
			} catch (ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		} else {
			String data;
			data = "requestCariAnggota#";
			data += cbCariAnggotaHistori.getSelectedItem().toString() + "#";
			data += txtCariAnggotaHistori.getText() + "#";
			try {
				LoadCariTableDataAnggotaHistori(tcpClient.send(data));
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
				System.out.println(ex.getMessage());
			} catch (ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private void btnReportHistoriPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {

		if (tableHistoriPeminjaman.getRowCount() > 1) {
			try {
				Document doc = new Document();
				PdfWriter.getInstance(doc, new FileOutputStream("report-histori.pdf"));
				doc.open();
				doc.add(new Paragraph("SISTEM PERPUSTAKAAN XYZ",
						FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD)));
				doc.add(new Paragraph(
						"----------------------------------------------------------------------------------------------------------------------------------"));
				doc.add(new Paragraph("Histori Peminjaman",
						FontFactory.getFont(FontFactory.TIMES_BOLD, 12, Font.BOLD)));

				PdfPTable pdfTable = new PdfPTable(tableHistoriPeminjaman.getColumnCount());
				pdfTable.setWidthPercentage(100);
				// adding table headers
				for (int i = 0; i < tableHistoriPeminjaman.getColumnCount(); i++) {
					pdfTable.addCell(tableHistoriPeminjaman.getColumnName(i));
				}
				// extracting data from the JTable and inserting it to PdfPTable
				for (int rows = 0; rows < tableHistoriPeminjaman.getRowCount(); rows++) {
					for (int cols = 0; cols < tableHistoriPeminjaman.getColumnCount(); cols++) {
						pdfTable.addCell(tableHistoriPeminjaman.getModel().getValueAt(rows, cols).toString());

					}
				}
				pdfTable.setSpacingBefore((float) 20);
				pdfTable.setSpacingAfter((float) 10);
				pdfTable.spacingBefore();
				pdfTable.spacingAfter();
				doc.add(pdfTable);
				doc.close();
				JOptionPane.showMessageDialog(null, "Berhasil");
			} catch (DocumentException | FileNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Tidak Ada Record");
		}

	}

	private void tableHistoriPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {

		int row = tableHistoriPeminjaman.getSelectedRow();
		String kdAnggota = (String) tableHistoriPeminjaman.getValueAt(row, 4);
		String kdBuku = (String) tableHistoriPeminjaman.getValueAt(row, 5);
		String pesanInfoBuku = "requestInformasiBuku#";
		pesanInfoBuku += kdBuku + "#";
		String pesanInfoAnggota = "requestInformasiAnggota#";
		pesanInfoAnggota += kdAnggota + "#";
		try {
			LoadInformasiBuku(tcpClient.send(pesanInfoBuku));
			LoadInformasiAnggota(tcpClient.send(pesanInfoAnggota));
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void btnCariHistoriPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {
		if (dcCariHistoriPeminjaman.getDate() == null) {
			try {
				LoadTableHistori(tcpClient.send("requestDataHistori"));
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
				System.out.println(ex.getMessage());
			} catch (ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String cari = sdf.format(dcCariHistoriPeminjaman.getDate());
			String data = "requestCariHistori#";
			data += cbCariHistoriPeminjaman.getSelectedItem().toString() + "#";
			data += cari + "#";
			try {
				LoadCariTableHistori(tcpClient.send(data));
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
				System.out.println(ex.getMessage());
			} catch (ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private void btnResetPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {
		txtCariPeminjaman.setText("");
		cbCariPeminjaman.setSelectedItem(0);
		ClearTextFieldPeminjaman();
		lblTotalHariDenda.setText("-");
		lblTotalHargaDenda.setText("-");
		try {
			LoadTablePeminjaman(tcpClient.send("requestDataPeminjaman"));
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {

		try {
			Document doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream("report.pdf"));
			doc.open();
			doc.add(new Paragraph("SISTEM PERPUSTAKAAN XYZ",
					FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD)));
			doc.add(new Paragraph(
					"----------------------------------------------------------------------------------------------------------------------------------"));

			PdfPTable pdfTable = new PdfPTable(tablePeminjaman.getColumnCount());
			pdfTable.setWidthPercentage(100);
			// adding table headers
			for (int i = 0; i < tablePeminjaman.getColumnCount(); i++) {
				pdfTable.addCell(tablePeminjaman.getColumnName(i));
			}
			// extracting data from the JTable and inserting it to PdfPTable
			for (int rows = 0; rows < tablePeminjaman.getRowCount(); rows++) {
				for (int cols = 0; cols < tablePeminjaman.getColumnCount(); cols++) {
					pdfTable.addCell(tablePeminjaman.getModel().getValueAt(rows, cols).toString());

				}
			}
			pdfTable.setSpacingBefore((float) 20);
			pdfTable.setSpacingAfter((float) 10);
			pdfTable.spacingBefore();
			pdfTable.spacingAfter();
			doc.add(pdfTable);
			doc.close();
			JOptionPane.showMessageDialog(null, "Berhasil");
		} catch (DocumentException | FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void btnPengembalianActionPerformed(java.awt.event.ActionEvent evt) {

		if (tablePeminjaman.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Tidak Ada Buku Yang Dikembalikan");
		} else {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah anda ingin melakukan pengembalian ?",
					"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (dialogResult == JOptionPane.YES_OPTION) {
				String data;
				data = "requestKembaliBuku#";
				data += KodePinjam + "#";
				data += KodeBukuPeminjaman + "#";
				try {
					LoadKembaliBuku(tcpClient.send(data));
					LoadAllTable();
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
					System.out.println(ex.getMessage());
				} catch (ClassNotFoundException ex) {
					System.out.println(ex.getMessage());
				}
				lblTotalHariDenda.setText("-");
				lblTotalHargaDenda.setText("-");
			}

		}
	}

	private void btnPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {

		if (txtKodeAnggota.getText().equals("") || txtKodeBuku.getText().equals("") || dcTanggalPinjam.getDate() == null
				|| dcTanggalBatasPinjam.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Data Peminjaman Belum Lengkap");
		} else {
			try {
				String pesan = "requestCekKodeBuku#";
				pesan += txtKodeBuku.getText() + "#";
				if (LoadCekKodeBuku(tcpClient.send(pesan)) > 0) {
					String pesan1 = "requestCekKodeAnggota#";
					pesan1 += txtKodeAnggota.getText() + "#";
					if (LoadCekKodeAnggota(tcpClient.send(pesan1)) > 0) {
						String pesan2 = "requestCekStokBuku#";
						pesan2 += txtKodeBuku.getText() + "#";
						if (LoadJumlahStokBuku(tcpClient.send(pesan2)) > 0) {
							String pesan3 = "requestCekTotalPinjamAnggota#";
							pesan3 += txtKodeAnggota.getText() + "#";
							if (LoadCekTotalPinjamAnggota(tcpClient.send(pesan3)) < 3) {
								int dialogResult = JOptionPane.showConfirmDialog(null,
										"Apakah anda ingin melakukan peminjaman ?", "Confirm",
										JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								if (dialogResult == JOptionPane.YES_OPTION) {
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									String data;
									String tanggalPinjam = sdf.format(dcTanggalPinjam.getDate());
									String tanggalBatasPinjam = sdf.format(dcTanggalBatasPinjam.getDate());
									data = "requestInsertPeminjaman#";
									data += txtKodeAnggota.getText() + "#";
									data += txtKodeBuku.getText() + "#";
									data += tanggalPinjam + "#";
									data += tanggalBatasPinjam + "#";
									try {
										InsertDataPeminjaman(tcpClient.send(data));
										LoadAllTable();
									} catch (IOException ex) {
										JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
										System.out.println(ex.getMessage());
									} catch (ClassNotFoundException ex) {
										System.out.println(ex.getMessage());
									}
								}

							} else {
								String info = "Limit Pinjam Anggota " + txtKodeAnggota.getText();
								info += " Sudah Habis";
								JOptionPane.showMessageDialog(null, info);
							}

						} else {
							String informationMessage = "Jumlah Stok Buku ";
							informationMessage += txtKodeBuku.getText();
							informationMessage += " Sudah Habis";
							JOptionPane.showMessageDialog(null, informationMessage);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Kode Anggota Tidak Valid");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Kode Buku Tidak Valid");
				}

			} catch (IOException | ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}

		}
	}

	private void tablePeminjamanMouseClicked(java.awt.event.MouseEvent evt) {

		int row = tablePeminjaman.getSelectedRow();
		KodePinjam = tablePeminjaman.getValueAt(row, 0).toString();
		KodeBukuPeminjaman = tablePeminjaman.getValueAt(row, 4).toString();
		String data;
		String tanggalBatasPinjam = tablePeminjaman.getValueAt(row, 2).toString();
		data = "requestCekDenda#";
		data += tanggalBatasPinjam + "#";

		try {
			LoadTotalHariDenda(tcpClient.send(data));
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void txtCariPeminjamanKeyReleased(java.awt.event.KeyEvent evt) {
		if (txtCariPeminjaman.getText().trim().equals("")) {
			try {
				LoadTablePeminjaman(tcpClient.send("requestDataPeminjaman"));
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
			} catch (ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		} else {
			String data;
			data = "requestCariPeminjaman#";
			data += cbCariPeminjaman.getSelectedItem().toString() + "#";
			data += txtCariPeminjaman.getText() + "#";
			try {
				LoadCariTablePeminjaman(tcpClient.send(data));
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
				System.out.println(ex.getMessage());
			} catch (ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private void btnResetAnggotaActionPerformed(java.awt.event.ActionEvent evt) {

		txtCariAnggota.setText("");
		cbCariAnggota.setSelectedIndex(0);
		ClearTextFieldAnggota();
		try {
			LoadTableAnggota(tcpClient.send("requestDataAnggota"));
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}

	}

	private void btnHapusAnggotaActionPerformed(java.awt.event.ActionEvent evt) {
		if (txtNamaAnggota.getText().equals("") || txtAlamat.getText().equals("")
				|| txtNomorTelepon.getText().equals("") || txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Data Anggota Belum Lengkap");
		} else {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus anggota ?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (dialogResult == JOptionPane.YES_OPTION) {
				String data;
				data = "requestDeleteAnggota#";
				data += KodeAnggota + "#";
				try {
					DeleteDataAnggota(tcpClient.send(data));
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
					System.out.println(ex.getMessage());
				} catch (ClassNotFoundException ex) {
					System.out.println(ex.getMessage());
				}
			}

		}
	}

	private void btnEditAnggotaActionPerformed(java.awt.event.ActionEvent evt) {

		if (txtNamaAnggota.getText().equals("") || txtAlamat.getText().equals("")
				|| txtNomorTelepon.getText().equals("") || txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Data Anggota Belum Lengkap");
		} else {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah anda ingin mengedit anggota ?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (dialogResult == JOptionPane.YES_OPTION) {
				String data;
				data = "requestUpdateAnggota#";
				data += KodeAnggota + "#";
				data += txtNamaAnggota.getText() + "#";
				data += txtAlamat.getText() + "#";
				data += txtNomorTelepon.getText() + "#";
				data += txtEmail.getText() + "#";
				try {
					UpdateDataAnggota(tcpClient.send(data));
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
					System.out.println(ex.getMessage());
				} catch (ClassNotFoundException ex) {
					System.out.println(ex.getMessage());
				}
			}

		}
	}

	private void btnTambahAnggotaActionPerformed(java.awt.event.ActionEvent evt) {

		if (txtNamaAnggota.getText().equals("") || txtAlamat.getText().equals("")
				|| txtNomorTelepon.getText().equals("") || txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Data Anggota Belum Lengkap");
		} else {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menambahkan anggota ?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (dialogResult == JOptionPane.YES_OPTION) {
				String data;
				data = "requestInsertAnggota#";
				data += txtNamaAnggota.getText() + "#";
				data += txtAlamat.getText() + "#";
				data += txtNomorTelepon.getText() + "#";
				data += txtEmail.getText() + "#";
				try {
					InsertDataAnggota(tcpClient.send(data));
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
					System.out.println(ex.getMessage());
				} catch (ClassNotFoundException ex) {
					System.out.println(ex.getMessage());
				}
			}

		}
	}

	private void tableAnggotaMouseClicked(java.awt.event.MouseEvent evt) {
		int row = tableAnggota.getSelectedRow();
		KodeAnggota = tableAnggota.getValueAt(row, 0).toString();
		txtNamaAnggota.setText(tableAnggota.getValueAt(row, 1).toString());
		txtAlamat.setText(tableAnggota.getValueAt(row, 2).toString());
		txtNomorTelepon.setText(tableAnggota.getValueAt(row, 3).toString());
		txtEmail.setText(tableAnggota.getValueAt(row, 4).toString());
	}

	private void txtCariAnggotaKeyReleased(java.awt.event.KeyEvent evt) {
		if (txtCariAnggota.getText().trim().equals("")) {
			try {
				LoadTableAnggota(tcpClient.send("requestDataAnggota"));
			} catch (IOException | ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		} else {
			String data;
			data = "requestCariAnggota#";
			data += cbCariAnggota.getSelectedItem().toString() + "#";
			data += txtCariAnggota.getText() + "#";
			try {
				LoadCariTableAnggota(tcpClient.send(data));
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
				System.out.println(ex.getMessage());
			} catch (ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private void btnResetBukuActionPerformed(java.awt.event.ActionEvent evt) {
		txtCariBuku.setText("");
		cbCariBuku.setSelectedIndex(0);
		ClearTextFieldBuku();
		try {
			LoadTableBuku(tcpClient.send("requestDataBuku"));
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void btnHapusBukuActionPerformed(java.awt.event.ActionEvent evt) {
		if (txtJudulBuku.getText().equals("") || txtPenulis.getText().equals("") || txtPenerbit.getText().equals("")
				|| txtTahunTerbit.getText().equals("") || txtNomorRak.getText().equals("")
				|| txtJumlahBuku.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Data Buku Belum Lengkap");
		} else {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus buku ?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (dialogResult == JOptionPane.YES_OPTION) {
				String data;
				data = "requestDeleteBuku#";
				data += KodeBuku + "#";
				try {
					DeleteDataBuku(tcpClient.send(data));
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
					System.out.println(ex.getMessage());
				} catch (ClassNotFoundException ex) {
					System.out.println(ex.getMessage());
				}
			}

		}
	}

	private void btnEditBukuActionPerformed(java.awt.event.ActionEvent evt) {

		if (txtJudulBuku.getText().equals("") || txtPenulis.getText().equals("") || txtPenerbit.getText().equals("")
				|| txtTahunTerbit.getText().equals("") || txtNomorRak.getText().equals("")
				|| txtJumlahBuku.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Data Buku Belum Lengkap");
		} else {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah anda ingin mengedit buku ?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (dialogResult == JOptionPane.YES_OPTION) {
				String data;
				data = "requestUpdateBuku#";
				data += KodeBuku + "#";
				data += txtJudulBuku.getText() + "#";
				data += txtPenulis.getText() + "#";
				data += txtPenerbit.getText() + "#";
				data += txtTahunTerbit.getText() + "#";
				data += txtNomorRak.getText() + "#";
				data += txtJumlahBuku.getText() + "#";
				try {
					UpdateDataBuku(tcpClient.send(data));
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
					System.out.println(ex.getMessage());
				} catch (ClassNotFoundException ex) {
					System.out.println(ex.getMessage());
				}

			}

		}
	}

	private void btnTambahBukuActionPerformed(java.awt.event.ActionEvent evt) {

		if (txtJudulBuku.getText().equals("") || txtPenulis.getText().equals("") || txtPenerbit.getText().equals("")
				|| txtTahunTerbit.getText().equals("") || txtNomorRak.getText().equals("")
				|| txtJumlahBuku.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Data Buku Belum Lengkap");
		} else {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menambahkan buku ?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (dialogResult == JOptionPane.YES_OPTION) {
				try {
					String data;
					data = "requestInsertBuku#";
					data += txtJudulBuku.getText() + "#";
					data += txtPenulis.getText() + "#";
					data += txtPenerbit.getText() + "#";
					data += txtTahunTerbit.getText() + "#";
					data += txtNomorRak.getText() + "#";
					data += txtJumlahBuku.getText() + "#";
					InsertDataBuku(tcpClient.send(data));
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
					System.out.println(ex.getMessage());
				} catch (ClassNotFoundException ex) {
					System.out.println(ex.getMessage());
				}
			}

		}
	}

	private void tableBukuMouseClicked(java.awt.event.MouseEvent evt) {
		
		int row = tableBuku.getSelectedRow();
		KodeBuku = tableBuku.getValueAt(row, 0).toString();
		txtJudulBuku.setText(tableBuku.getValueAt(row, 1).toString());
		txtPenulis.setText(tableBuku.getValueAt(row, 2).toString());
		txtPenerbit.setText(tableBuku.getValueAt(row, 3).toString());
		txtTahunTerbit.setText(tableBuku.getValueAt(row, 4).toString());
		txtNomorRak.setText(tableBuku.getValueAt(row, 5).toString());
		txtJumlahBuku.setText(tableBuku.getValueAt(row, 6).toString());
	}

	private void txtCariBukuKeyReleased(java.awt.event.KeyEvent evt) {
		
		if (txtCariBuku.getText().trim().equals("")) {
			try {
				LoadTableBuku(tcpClient.send("requestDataBuku"));
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
			} catch (ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		} else {
			String data;
			data = "requestCariBuku#";
			data += cbCariBuku.getSelectedItem().toString() + "#";
			data += txtCariBuku.getText() + "#";
			try {
				LoadCariTableBuku(tcpClient.send(data));
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Koneksi Server Terputus");
			} catch (ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}


	public static void main(String args[]) throws ClassNotFoundException, IOException {
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

		new FrameClient().setVisible(true);
	}


}
