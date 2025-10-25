# Responsi 1 Mobile (H1D023114) – Info Klub Sepakbola

## Data Praktikan
- **Nama:** Essay Bina Mukti
- **NIM:** H1D023114
- **Shift Baru:** H
- **Shift Asal:** F

---

## Demo Aplikasi
Berikut adalah cuplikan **video demo aplikasi** yang memperlihatkan tampilan ikon aplikasi, halaman profil klub, pelatih, dan daftar pemain:  
![Demo Aplikasi Responsi 1](CeltaDeVigo.gif)

---

## Tentang Aplikasi
**Responsi 1 Mobile (H1D023114)** adalah aplikasi Android yang menampilkan informasi klub sepakbola **RC Celta de Vigo**.  
Aplikasi ini dikembangkan menggunakan **Kotlin** dengan dukungan **Retrofit** untuk mengambil data dari API publik [football-data.org](https://www.football-data.org/).

### Fitur Utama:
- Menampilkan **profil klub** (logo, sejarah singkat, stadion).
- Menampilkan **data pelatih** yang diambil langsung dari API.
- Menampilkan **daftar pemain (squad)** dengan warna kartu berbeda berdasarkan posisi:
   - Goalkeeper → Kuning
   - Defender → Biru
   - Midfielder → Hijau
   - Forward → Merah

---

## Alur Data: Dari API Hingga Tampil di Layar

1. **Pemanggilan Awal**
   - Saat aplikasi dijalankan, `MainActivity` menjadi halaman utama yang menyediakan tombol navigasi ke tiga bagian:
      - Profil Klub
      - Pelatih
      - Squad Pemain
   - ID klub yang digunakan adalah **558 (RC Celta de Vigo)**.

2. **Pemanggilan API**
   - Data diambil melalui endpoint:
     ```
     GET https://api.football-data.org/v4/teams/558
     Header: X-Auth-Token: [token pribadi]
     ```
   - Proses pemanggilan dilakukan menggunakan **Retrofit** di dalam `MainViewModel`, lalu dijalankan secara asynchronous dengan Kotlin **Coroutines**.

3. **Pengolahan Data**
   - Respon API dalam format JSON dikonversi otomatis ke objek `TeamResponse` melalui **GsonConverterFactory**.
   - Struktur data meliputi:
      - `coach` → informasi pelatih
      - `squad` → daftar pemain

4. **Distribusi Data**
   - Data yang diterima disimpan ke dalam `LiveData` agar bisa diamati (observed) oleh setiap fragment:
      - **CoachFragment:** Menampilkan data pelatih (nama, tanggal lahir, kebangsaan) serta foto dari aset lokal (`coach.jpg`).
      - **SquadFragment:** Menampilkan daftar pemain menggunakan **RecyclerView** dan adapter `PlayerAdapter`.  
        Warna latar kartu menyesuaikan posisi pemain (Goalkeeper, Defender, Midfielder, Forward).
      - **History/ProfileFragment:** Menampilkan profil klub dan sejarah singkat dengan gambar lokal (`main_page.jpg`, `history.jpg`, `logo.png`).

5. **Penyajian ke Layar**
   - Data tampil secara otomatis saat LiveData berubah.
   - Gambar pelatih dan klub ditampilkan menggunakan **Glide** agar proses loading lebih efisien dan lancar.

---

## Teknologi yang Digunakan
- **Kotlin (Android Studio)**
- **MVVM Architecture (Model-View-ViewModel)**
- **Retrofit2 + GsonConverterFactory**
- **Kotlin Coroutines**
- **RecyclerView + ViewBinding**
- **Glide (Image Loader)**
- **football-data.org API**

---