# Java RMI Bank Application

Aplikasi Bank berbasis Java yang menggunakan Java RMI untuk memungkinkan interaksi jarak jauh antara klien dan server perbankan. Aplikasi ini menyediakan layanan dasar perbankan seperti cek saldo, transfer dana, dan fitur khusus untuk admin.

## Fitur

1. **Cek Saldo**: Pengguna dapat memeriksa saldo rekening mereka.
2. **Transfer Dana**: Pengguna dapat melakukan transfer dana antar rekening.
3. **Lihat Semua Saldo (Admin)**: Admin dapat melihat saldo dari semua rekening yang terdaftar.
4. **Lihat Riwayat Transaksi (Admin)**: Admin dapat melihat riwayat transaksi yang terjadi.

## Struktur Proyek

### 1. `Bank.java`

Antarmuka RMI yang mendefinisikan metode yang dapat diakses oleh klien:

- `double checkBalance(String accountNumber)`: Mengembalikan saldo dari nomor rekening yang diberikan.
- `String transferFunds(String fromAccount, String toAccount, double amount)`: Melakukan transfer dana antar rekening dan memberikan hasil transfer.
- `Map<String, Double> viewAllBalances()`: Mengembalikan semua saldo rekening (khusus admin).
- `String viewTransactions()`: Mengembalikan riwayat transaksi yang terjadi (khusus admin).

### 2. `BankClient.java`

Aplikasi klien berbasis GUI menggunakan Java Swing. Terdapat dua mode akses:

- **Mode Admin**: Akses untuk melihat semua saldo dan riwayat transaksi.
- **Mode Pengguna**: Akses untuk cek saldo dan melakukan transfer dana.

#### Kredensial Pengguna:
- **Admin**: 
  - Username: `admin`
  - Password: `123456789`
- **Pengguna (Contoh)**:
  - Username: `ACCxxx` (misal: `ACC123`)
  - Password: `informatika`

Fitur dalam GUI klien meliputi:
- **Cek Saldo**: Untuk melihat saldo rekening.
- **Transfer Dana**: Untuk melakukan transfer dana antar rekening.
- **Lihat Semua Saldo dan Riwayat Transaksi (khusus Admin)**.

### 3. `BankImpl.java`

Kelas implementasi dari antarmuka `Bank`, yang mengelola data akun dan menyimpan catatan transaksi:

- Menyimpan data saldo untuk setiap akun yang terdaftar.
- Menyediakan fungsi untuk cek saldo, transfer dana antar akun, melihat semua saldo (khusus admin), dan melihat riwayat transaksi (khusus admin).

### 4. `BankServer.java`

Kode server yang mengatur proses server untuk layanan perbankan RMI:

- Membuat instance `BankImpl`.
- Mendaftarkan layanan `Bank` di registry RMI pada port 1099.
- Menyiapkan server untuk memungkinkan klien terhubung ke layanan perbankan dari jarak jauh.

## Cara Menjalankan Aplikasi

### 1. Menjalankan Server

Kompilasi `BankImpl.java` dan `BankServer.java` dan jalankan server sebelum klien:
```bash
javac BankImpl.java BankServer.java java BankServer
```

Server ini berjalan di localhost pada port default RMI (1099). Setelah berhasil, server akan siap menerima koneksi dari klien.

### 2. Menjalankan Klien
Kompilasi Bank.java dan BankClient.java, lalu jalankan klien dengan cara berikut:

```bash
javac Bank.java BankClient.java java BankClient
Saat klien dijalankan, GUI akan meminta login. Masukkan kredensial yang sesuai (admin atau pengguna biasa) untuk melanjutkan.
```

## Catatan Penting
   - Pastikan server berjalan sebelum menjalankan klien, karena klien perlu terhubung ke server      RMI.
   - Koneksi menggunakan localhost, yang berarti server dan klien berada pada mesin yang sama        kecuali disesuaikan untuk jaringan lain.

## Teknologi yang Digunakan
   -Java RMI: Untuk komunikasi jarak jauh antara server dan klien.
   -Java Swing: Untuk antarmuka pengguna berbasis GUI.
   -Java Collections (HashMap): Untuk menyimpan dan mengelola saldo akun pengguna.

## Potensi Pengembangan
   - Keamanan: Implementasi otentikasi yang lebih kuat untuk akses admin dan pengguna.
   - Pengembangan Fitur: Menambah fitur lain seperti penarikan tunai, penyetoran, dan pembuatan      akun baru.
   - Deployment pada Jaringan Luas: Menjalankan server pada jaringan eksternal agar dapat            diakses    dari lokasi berbeda.

