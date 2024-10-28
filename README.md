# Sistem Perbankan RMI dengan Fitur Admin dan User

Proyek ini adalah aplikasi perbankan sederhana menggunakan Java RMI (Remote Method Invocation) dengan dua jenis pengguna, yaitu **admin** dan **user**. Aplikasi ini memiliki antarmuka grafis (GUI) untuk interaksi pengguna dan menyediakan fitur seperti melihat saldo, melakukan transfer, serta melihat transaksi khusus untuk admin.

## Persyaratan Sistem
- Java Development Kit (JDK) versi 8 atau yang lebih baru
- Text editor atau IDE seperti Visual Studio Code, Eclipse, atau IntelliJ IDEA

## Pengaturan Lingkungan
### 1. Instalasi Java
Jika belum terinstal, Anda dapat mengunduh dan menginstal JDK dari situs resmi Oracle: [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html).

Setelah terinstal, pastikan Java telah ditambahkan ke `PATH` sistem Anda. Verifikasi instalasi dengan menjalankan perintah berikut di terminal atau command prompt:
```bash
java -version


Pastikan versi Java tertera di terminal.

2. Menjalankan RMI Registry
RMI registry adalah komponen yang diperlukan untuk mendukung Remote Method Invocation (RMI). Sebelum menjalankan server, buka terminal atau command prompt dan ketik:

bash
Salin kode
rmiregistry
Biarkan jendela ini terbuka selama Anda menjalankan server dan klien.

Kompilasi dan Menjalankan Program
Setelah memastikan semua file Java sudah siap, ikuti langkah-langkah berikut untuk mengkompilasi dan menjalankan program.

1. Kompilasi
Masuk ke folder tempat file Java disimpan dan jalankan perintah berikut untuk mengkompilasi semua file:

bash
Salin kode
javac *.java
Jika tidak ada kesalahan, ini akan menghasilkan file .class yang siap dijalankan.

2. Menjalankan Server
Di terminal atau command prompt, jalankan perintah berikut untuk memulai server:

bash
Salin kode
java BankServer
Anda akan melihat pesan "Bank Server is ready." jika server berhasil dijalankan.

3. Menjalankan Client
Di terminal atau command prompt lainnya, jalankan klien dengan perintah:

bash
Salin kode
java BankClient
Program ini akan menampilkan antarmuka grafis untuk aplikasi bank.

Fungsionalitas Program
Program ini terdiri dari empat file utama dengan fungsinya masing-masing sebagai berikut:

1. Bank.java
File ini adalah antarmuka (interface) Bank, yang mendefinisikan metode-metode yang dapat digunakan klien, termasuk:

checkBalance(String accountNumber): Memeriksa saldo dari nomor akun tertentu.
transferFunds(String fromAccount, String toAccount, double amount): Transfer dana dari satu akun ke akun lainnya.
viewAllBalances(): Khusus untuk admin, untuk melihat saldo semua akun.
viewTransactions(): Khusus untuk admin, untuk melihat riwayat transaksi yang terjadi.
2. BankImpl.java
BankImpl adalah kelas yang mengimplementasikan antarmuka Bank dan mengandung logika inti untuk setiap metode:

Menyimpan data akun dan saldo: Menggunakan HashMap untuk menyimpan nomor akun dan saldo masing-masing.
Memeriksa Saldo (checkBalance): Mengembalikan saldo dari akun yang diberikan.
Transfer Dana (transferFunds): Mengecek apakah akun asal dan tujuan valid, lalu melakukan pemotongan dan penambahan saldo sesuai permintaan transfer. Transaksi yang berhasil akan dicatat ke dalam riwayat transaksi.
Melihat Semua Saldo (viewAllBalances): Mengembalikan saldo semua akun (hanya untuk admin).
Melihat Riwayat Transaksi (viewTransactions): Mengembalikan catatan transaksi (hanya untuk admin).
3. BankServer.java
File ini adalah server RMI yang membuat instance dari BankImpl, mendaftarkannya ke RMI registry dengan nama "BankService", dan membuat server siap menerima permintaan dari klien.

Cara kerjanya:

Membuat instance BankImpl.
Membuat RMI registry di port default (1099).
Mendaftarkan instance BankImpl ke registry dengan nama "BankService".
4. BankClient.java
BankClient adalah aplikasi GUI untuk klien yang menghubungkan klien dengan server menggunakan RMI. Saat dijalankan, pengguna akan diminta memasukkan username dan password. Tergantung pada tipe pengguna, antarmuka yang disajikan berbeda:

Admin:
Dapat melihat saldo dari semua akun.
Dapat melihat riwayat transaksi.
User:
Dapat memeriksa saldo akun mereka sendiri.
Dapat mentransfer dana ke akun lain.
Fitur utama pada klien:

Login Dialog (showLoginDialog): Menampilkan dialog login awal untuk menentukan apakah pengguna adalah admin atau user.
Admin menggunakan username admin dan password 123456789.
User menggunakan username sesuai nomor akun (ACC123, ACC456, dll.) dan password informatika.
Check Balance (checkBalance): Menampilkan saldo akun pengguna.
Transfer Funds (transferFunds): Memproses transfer dana dari akun pengguna ke akun lain.
View All Balances (viewAllBalances): Hanya untuk admin, menampilkan saldo semua akun.
View Transactions (viewTransactions): Hanya untuk admin, menampilkan seluruh riwayat transaksi.
Kesimpulan
Program ini adalah aplikasi perbankan sederhana yang memungkinkan pengguna berinteraksi dengan sistem perbankan menggunakan Java RMI. Program ini membedakan antara admin dan user untuk memberikan akses yang berbeda pada setiap jenis pengguna.

Catatan
Pastikan RMI registry berjalan selama server dan klien dijalankan, dan gunakan Java versi terbaru untuk menghindari masalah kompatibilitas.
