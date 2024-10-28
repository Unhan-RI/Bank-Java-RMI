# Java RMI Bank Application

Aplikasi Bank berbasis Java yang menggunakan Java RMI untuk memungkinkan interaksi jarak jauh antara klien dan server perbankan. Aplikasi ini menyediakan layanan dasar seperti cek saldo, transfer dana, dan fitur-fitur khusus untuk admin.

## Fitur

1. **Cek Saldo**: Pengguna dapat memeriksa saldo rekening mereka.
2. **Transfer Dana**: Pengguna dapat melakukan transfer dana antar rekening.
3. **Lihat Semua Saldo (Admin)**: Admin dapat melihat saldo dari semua rekening yang terdaftar.
4. **Lihat Riwayat Transaksi (Admin)**: Admin dapat melihat riwayat transaksi yang terjadi.

## Struktur Proyek

### 1. `Bank.java`

Antarmuka RMI yang mendefinisikan metode yang dapat digunakan oleh klien:
- `checkBalance(String accountNumber)`: Mengembalikan saldo dari nomor rekening yang diberikan.
- `transferFunds(String fromAccount, String toAccount, double amount)`: Melakukan transfer dana antar rekening.
- `viewAllBalances()`: Mengembalikan semua saldo rekening (khusus admin).
- `viewTransactions()`: Mengembalikan riwayat transaksi (khusus admin).

### 2. `BankClient.java`

Aplikasi klien berbasis GUI (Swing) yang menyediakan dua mode akses:
- **Mode Admin**: Memiliki akses untuk melihat semua saldo dan riwayat transaksi.
- **Mode Pengguna**: Memiliki akses untuk melihat saldo dan melakukan transfer dana.

#### Cara Menggunakan:
- Admin menggunakan kredensial: **Username**: `admin`, **Password**: `123456789`
- Pengguna dengan nomor akun: **Username**: `ACCxxx` (contoh: `ACC123`), **Password**: `informatika`

### 3. `BankImpl.java`

Implementasi dari antarmuka `Bank`, yang mengelola data akun dan menyimpan catatan transaksi.
- Menyimpan data saldo untuk akun yang terdaftar.
- Menyediakan fungsi untuk cek saldo, transfer dana, melihat semua saldo (admin), dan melihat riwayat transaksi (admin).

### 4. `BankServer.java`

Kode server yang:
- Membuat instance dari `BankImpl`.
- Mendaftarkan layanan `Bank` di registry RMI pada port 1099.
- Menjalankan server untuk memungkinkan koneksi dari klien.

## Cara Menjalankan

1. **Menjalankan Server**
   - Kompilasi `BankImpl.java` dan `BankServer.java`.
   - Jalankan `BankServer` untuk memulai layanan RMI.

   ```bash
   javac BankImpl.java BankServer.java
   java BankServer
