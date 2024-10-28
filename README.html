<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistem Perbankan RMI dengan Fitur Admin dan User</title>
    <style>
        body { font-family: Arial, sans-serif; line-height: 1.6; margin: 0 20px; }
        h1 { color: #333; }
        h2 { color: #555; }
        code { background-color: #f4f4f4; padding: 4px; }
        pre { background-color: #f4f4f4; padding: 10px; border-left: 3px solid #ddd; }
        ul { margin-top: 0; }
    </style>
</head>
<body>
    <h1>Sistem Perbankan RMI dengan Fitur Admin dan User</h1>
    <p>
        Proyek ini adalah aplikasi perbankan sederhana menggunakan Java RMI (Remote Method Invocation) dengan dua jenis pengguna, yaitu <strong>admin</strong> dan <strong>user</strong>. Aplikasi ini memiliki antarmuka grafis (GUI) untuk interaksi pengguna dan menyediakan fitur seperti melihat saldo, melakukan transfer, serta melihat transaksi khusus untuk admin.
    </p>

    <h2>Persyaratan Sistem</h2>
    <ul>
        <li>Java Development Kit (JDK) versi 8 atau yang lebih baru</li>
        <li>Text editor atau IDE seperti Visual Studio Code, Eclipse, atau IntelliJ IDEA</li>
    </ul>

    <h2>Pengaturan Lingkungan</h2>
    <h3>1. Instalasi Java</h3>
    <p>
        Jika belum terinstal, Anda dapat mengunduh dan menginstal JDK dari situs resmi Oracle: 
        <a href="https://www.oracle.com/java/technologies/javase-downloads.html" target="_blank">Download JDK</a>.
    </p>
    <p>
        Setelah terinstal, pastikan Java telah ditambahkan ke <code>PATH</code> sistem Anda. Verifikasi instalasi dengan menjalankan perintah berikut di terminal atau command prompt:
    </p>
    <pre>java -version</pre>
    <p>Pastikan versi Java tertera di terminal.</p>

    <h3>2. Menjalankan RMI Registry</h3>
    <p>
        RMI registry adalah komponen yang diperlukan untuk mendukung Remote Method Invocation (RMI). Sebelum menjalankan server, buka terminal atau command prompt dan ketik:
    </p>
    <pre>rmiregistry</pre>
    <p>Biarkan jendela ini terbuka selama Anda menjalankan server dan klien.</p>

    <h2>Kompilasi dan Menjalankan Program</h2>
    <p>Setelah memastikan semua file Java sudah siap, ikuti langkah-langkah berikut untuk mengkompilasi dan menjalankan program.</p>

    <h3>1. Kompilasi</h3>
    <p>
        Masuk ke folder tempat file Java disimpan dan jalankan perintah berikut untuk mengkompilasi semua file:
    </p>
    <pre>javac *.java</pre>
    <p>Jika tidak ada kesalahan, ini akan menghasilkan file <code>.class</code> yang siap dijalankan.</p>

    <h3>2. Menjalankan Server</h3>
    <p>Di terminal atau command prompt, jalankan perintah berikut untuk memulai server:</p>
    <pre>java BankServer</pre>
    <p>Anda akan melihat pesan "Bank Server is ready." jika server berhasil dijalankan.</p>

    <h3>3. Menjalankan Client</h3>
    <p>Di terminal atau command prompt lainnya, jalankan klien dengan perintah:</p>
    <pre>java BankClient</pre>
    <p>Program ini akan menampilkan antarmuka grafis untuk aplikasi bank.</p>

    <h2>Fungsionalitas Program</h2>
    <p>Program ini terdiri dari empat file utama dengan fungsinya masing-masing sebagai berikut:</p>

    <h3>1. Bank.java</h3>
    <p>
        File ini adalah <strong>antarmuka</strong> (interface) <code>Bank</code>, yang mendefinisikan metode-metode yang dapat digunakan klien, termasuk:
    </p>
    <ul>
        <li><code>checkBalance(String accountNumber)</code>: Memeriksa saldo dari nomor akun tertentu.</li>
        <li><code>transferFunds(String fromAccount, String toAccount, double amount)</code>: Transfer dana dari satu akun ke akun lainnya.</li>
        <li><code>viewAllBalances()</code>: Khusus untuk admin, untuk melihat saldo semua akun.</li>
        <li><code>viewTransactions()</code>: Khusus untuk admin, untuk melihat riwayat transaksi yang terjadi.</li>
    </ul>

    <h3>2. BankImpl.java</h3>
    <p>
        <code>BankImpl</code> adalah kelas yang mengimplementasikan antarmuka <code>Bank</code> dan mengandung logika inti untuk setiap metode:
    </p>
    <ul>
        <li>Menyimpan data akun dan saldo menggunakan <code>HashMap</code> untuk menyimpan nomor akun dan saldo masing-masing.</li>
        <li><strong>Memeriksa Saldo</strong> (<code>checkBalance</code>): Mengembalikan saldo dari akun yang diberikan.</li>
        <li><strong>Transfer Dana</strong> (<code>transferFunds</code>): Mengecek apakah akun asal dan tujuan valid, lalu melakukan pemotongan dan penambahan saldo sesuai permintaan transfer. Transaksi yang berhasil akan dicatat ke dalam riwayat transaksi.</li>
        <li><strong>Melihat Semua Saldo</strong> (<code>viewAllBalances</code>): Mengembalikan saldo semua akun (hanya untuk admin).</li>
        <li><strong>Melihat Riwayat Transaksi</strong> (<code>viewTransactions</code>): Mengembalikan catatan transaksi (hanya untuk admin).</li>
    </ul>

    <h3>3. BankServer.java</h3>
    <p>
        File ini adalah <strong>server RMI</strong> yang membuat instance dari <code>BankImpl</code>, mendaftarkannya ke RMI registry dengan nama <code>"BankService"</code>, dan membuat server siap menerima permintaan dari klien.
    </p>

    <h3>4. BankClient.java</h3>
    <p>
        <code>BankClient</code> adalah aplikasi GUI untuk klien yang menghubungkan klien dengan server menggunakan RMI. Saat dijalankan, pengguna akan diminta memasukkan <strong>username</strong> dan <strong>password</strong>. Tergantung pada tipe pengguna, antarmuka yang disajikan berbeda:
    </p>
    <ul>
        <li><strong>Admin</strong>: Dapat melihat saldo dari semua akun, dan dapat melihat riwayat transaksi.</li>
        <li><strong>User</strong>: Dapat memeriksa saldo akun mereka sendiri dan mentransfer dana ke akun lain.</li>
    </ul>

    <h2>Kesimpulan</h2>
    <p>
        Program ini adalah aplikasi perbankan sederhana yang memungkinkan pengguna berinteraksi dengan sistem perbankan menggunakan Java RMI. Program ini membedakan antara admin dan user untuk memberikan akses yang berbeda pada setiap jenis pengguna.
    </p>

    <h2>Catatan</h2>
    <p>Pastikan RMI registry berjalan selama server dan klien dijalankan, dan gunakan Java versi terbaru untuk menghindari masalah kompatibilitas.</p>

    <p><strong>Selamat mencoba!</strong></p>
</body>
</html>
