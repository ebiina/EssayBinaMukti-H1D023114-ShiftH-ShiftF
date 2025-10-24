# Responsi 1 Mobile (H1D023114) – Info Klub Sepakbola

## Data Praktikan
- **Nama:** Essay Bina Mukti
- **NIM:** H1D023114
- **Shift Baru:** H
- **Shift Asal:** F

---

## Tentang Aplikasi
**Responsi 1 Mobile (H1D023114)** adalah aplikasi Android yang menampilkan informasi klub sepakbola **RC Celta de Vigo**.  
Aplikasi dibuat menggunakan **Kotlin** dan **Retrofit** dengan data dari [football-data.org](https://www.football-data.org/).

Fitur utama:
- Menampilkan **profil klub** (logo, sejarah singkat, stadion).
- Menampilkan **pelatih** dari data API.
- Menampilkan **daftar pemain** dengan warna kartu sesuai posisi.

---

## Demo Aplikasi
Berikut cuplikan demo aplikasi yang memperlihatkan ikon, halaman profil, pelatih, dan pemain:  
![Demo Aplikasi Responsi 1](CeltaDeVigo.gif)

---

## Alur Data (Dari API ke Layar)
1. **MainActivity**
   - Mengatur navigasi antar halaman: Profil, Pelatih, dan Pemain.
   - Mengirim **ID klub = 558 (RC Celta de Vigo)** ke setiap fragment.

2. **Panggilan API**
   - Menggunakan Retrofit untuk request:
     ```
     GET https://api.football-data.org/v4/teams/558
     Header: X-Auth-Token: [token pribadi]
     ```
   - Token disimpan aman di `local.properties`.

3. **Parsing JSON**
   - Response API otomatis dikonversi ke model `TeamResponse` yang berisi data klub, pelatih, dan pemain.

4. **Menampilkan Data**
   - **ProfileFragment:** Menampilkan logo, sejarah, dan gambar klub (`logo.png`, `main_page.jpg`, `history.jpg`).
   - **CoachFragment:** Menampilkan pelatih dari API menggunakan foto lokal (`coach.jpg`).
   - **PlayersFragment:** Menampilkan daftar pemain dengan warna kartu sesuai posisi.

---

## Teknologi yang Digunakan
- **Kotlin (Android Studio)**
- **Retrofit2 + GsonConverterFactory**
- **Glide (untuk menampilkan gambar)**
- **RecyclerView + ViewBinding**
- **API:** `https://api.football-data.org/v4/teams/558`

---

## Penjelasan Singkat
> Aplikasi ini menampilkan data klub RC Celta de Vigo secara dinamis dari football-data.org.  
> Data pelatih dan pemain diambil langsung dari API, sedangkan gambar dan logo diambil dari aset lokal.  
> Tampilan dibuat responsif dan terpisah antar fragment agar mudah dinavigasi dan rapi sesuai ketentuan responsi.