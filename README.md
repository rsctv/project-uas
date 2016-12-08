# project-uas

Sistem Perpustakaan XYZ Berbasis Client - Server
Sistem perpustakaan ini dibuat untuk mempermudah pengelolaan perpustakaan seperti pencatatan informasi
mengenai buku, anggota serta sistem peminjaman dan pengembalian buku yang berbasis client - server.
Dimana Server bertugas memberikan layanan berupa data - data yang tersimpan didalam database kepada Client, 
Sedangkan Client bertugas untuk meminta layanan berupa data - data ke pada Server. 
Contoh Client meminta/request layanan berupa informasi data buku dan Server bertugas untuk mengambil informasi 
data buku di database kemudian memberikan informasi buku tersebut kepada Client.

Sistem ini dibuat menggunakkan :
1. Bahasa Pemrograman Java Menggunakan Eclipse IDE.
2. Database MySql Menggunakan XAMPP.
3. Generate Report Menggunakan IText Versi 5.5.9.
4. MySql Connector Java Versi 5.1.23.

Cara Kerja Sistem Perpustakaan XYZ
Anggota dapat meminjam buku yang ada di perpustakaan XYZ, Sistem Perpustakaan XYZ akan mencatat atau menyimpan
data anggota perpustakaan yang melakukan peminjaman atau pengembalian buku. Anggota maksimal dapat meminjam sebanyak
3 buku per peminjaman. Jika Anggota tersebut belum pernah mengembalikan buku yang dipinjam maka anggota tersebut
tidak dapat melakukan peminjaman. Contoh apabila anggota tersebut total telah meminjam 3 buku dan belum pernah mengembalikan
salah satu dari 3 buku yang dipinjam, maka anggota tersebut tidak dapat melakukan peminjaman buku. Apabila anggota tersebut
ingin melakukan peminjaman, maka anggota tersebut harus melakukan pengembalian buku. Sistem Perpustakaan XYZ mencatat tanggal
setiap peminjaman buku yang dipinjam oleh anggota. Apabila peminjaman buku melewati tanggal batas waktu pinjam, maka anggota
tersebut dikenakan denda Rp 1.000/hari. Setiap peminjaman/pengembalian buku disesuaikan dengan jumlah stok buku yang ada dalam
sistem. Apabila dilakukan transaksi peminjaman maka jumlah stok berkurang, begitu juga sebaliknya apabila dilakukan transaksi
pengembalian buku makan jumlah stok bertambah.

Cara Menjalankan Sistem Perpustakaan XYZ
1. Pertama run/jalankan FrameServer.Java, pastikan komputer terhubung dengan jaringan LAN.
2. Kedua run/jalankan FrameClient, pastikan nomor port dan ip address sesuai dengan Server.
   cara melihat/mengganti nomor port dan ip address ada pada file TCPClient.java yang ada didalam
   folder PerpustakaanClient. Apabila FrameServer belum di run/jalankan maka pada FrameClient akan
   muncul notifikasi bahwa Server Tersebut Belum Dihidupkan.
3. Sistem Perpustakaan XYZ siap digunakan. (note : apabila FrameServer.java dimatikan secara tiba"
   maka koneksi server antara Server dan Client akan terputus).
   
Fitur - fitur Sistem Perpustakaan XYZ :
- Fitur CRUD (Create, Retrieve, Update, Delete) pada modul buku dan anggota.
- Pencarian buku sesuai dengan kode buku, judul buku, penulis, penerbit, tahun terbit, dan nomor rak.
- Pencarian anggota sesuai dengan kode anggota, nama anggota dan email.
- Sistem peminjaman/pengembalian buku oleh anggota.
- Pencarian transaksi peminjaman sesuai dengan kode pinjam, kode buku dan kode anggota.
- Terdapat modul histori peminjaman/pengembalian buku, histori anggota dan histori buku.
- Pencarian Histori peminjaman/pengembalian bedasarkan tanggal pinjam, tanggal kembali.
- Pencarian Histori buku bedasarkan kode buku, judul buku, penulis, penerbit, tahun terbit, dan nomor rak.
- Pencarian Histori anggota bedasarkan kode anggota, nama anggota dan email.
- Cetak report histori peminjaman/pengembalian buku, buku, dan anggota.




