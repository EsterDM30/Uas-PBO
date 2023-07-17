/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author L E N O V O
 */
public class ManajemenPenjualanBuku {
    private static int modalAwal = 0;
    private static int modalBerjalan = 0;
    private static ArrayList<Buku> daftarBuku = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Sistem Penjualan Buku");
        System.out.print("By: <ESTER>, <22201144>\n");

        int pilihan;
        do {
            System.out.println("\nSilahkan pilih menu");
            System.out.println("1. Beli Buku");
            System.out.println("2. Jual Buku");
            System.out.println("3. Lihat Stok Buku");
            System.out.println("4. Lihat Laporan Keuangan");
            System.out.println("5. Exit");
            System.out.print("\nPilihan menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // Membersihkan newline character setelah memasukkan pilihan

            switch (pilihan) {
                case 1:
                    beliBuku(input);
                    break;
                case 2:
                    jualBuku(input);
                    break;
                case 3:
                    lihatStokBuku();
                    break;
                case 4:
                    lihatLaporanKeuangan();
                    break;
                case 5:
                    System.out.println("Program Selesai");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } while (pilihan != 5);
    }

    private static void beliBuku(Scanner input) {
        System.out.println("\nJenis buku:");
        System.out.println("1. Buku Fiksi");
        System.out.println("2. Buku Non-Fiksi");
        System.out.println("3. Majalah");
        System.out.print("Pilihan jenis buku: ");
        int jenisBuku = input.nextInt();
        
        
        System.out.print("Judul: ");    
        Scanner scanner = new Scanner(System.in);
        String judul = scanner.nextLine();
        
        System.out.print("Harga beli: ");
        int hargaBeli = input.nextInt();

        System.out.print("Harga jual: ");
        int hargaJual = input.nextInt();

        System.out.print("Jumlah stok: ");
        int jumlahStok = input.nextInt();

        switch (jenisBuku) {
            case 1:
                daftarBuku.add(new BukuFiksi(judul, hargaBeli, hargaJual, jumlahStok));
                break;
            case 2:
                daftarBuku.add(new BukuNonFiksi(judul, hargaBeli, hargaJual, jumlahStok));
                break;
            case 3:
                System.out.print("Nomor edisi: ");
                int nomorEdisi = input.nextInt();
                daftarBuku.add(new Majalah(judul, hargaBeli, hargaJual, jumlahStok, nomorEdisi));
                break;
            default:
                System.out.println("Jenis buku tidak valid.");
                break;
        }

        modalBerjalan += hargaBeli * jumlahStok;

        System.out.println("Buku berhasil dibeli.");
    }

    private static void jualBuku(Scanner input) {
        System.out.println("\nDaftar buku yang tersedia:");
        for (int i = 0; i < daftarBuku.size(); i++) {
            Buku buku = daftarBuku.get(i);
            System.out.println((i + 1) + ". " + buku.getJudul() + " (Stok: " + buku.getJumlahStok() + ")");
        }

        System.out.print("Pilih nomor buku yang akan dijual: ");
        int nomorBuku = input.nextInt();
        input.nextLine(); // Membersihkan newline character setelah memasukkan nomor buku

        if (nomorBuku >= 1 && nomorBuku <= daftarBuku.size()) {
            Buku buku = daftarBuku.get(nomorBuku - 1);
            System.out.print("Jumlah buku yang akan dijual: ");
            int jumlah = input.nextInt();

            if (jumlah <= buku.getJumlahStok()) {
                buku.kurangiStok(jumlah);
                modalBerjalan += buku.hargaJual * jumlah;
                System.out.println("Buku berhasil dijual.");
            } else {
                System.out.println("Jumlah buku yang dijual melebihi stok yang tersedia.");
            }
        } else {
            System.out.println("Nomor buku tidak valid.");
        }
    }
     private static void lihatStokBuku() {
        System.out.println("\nStok Buku");
        System.out.println("==================================");
        for (int i = 0; i < daftarBuku.size(); i++) {
            Buku buku = daftarBuku.get(i);
            String jenisBuku = "";

            if (buku instanceof BukuFiksi) {
                jenisBuku = "Buku Fiksi";
            } else if (buku instanceof BukuNonFiksi) {
                jenisBuku = "Buku Non-Fiksi";
            } else if (buku instanceof Majalah) {
                jenisBuku = "Majalah";
            }

            System.out.println("No. " + (i + 1));
            System.out.println("Judul: " + buku.getJudul());
            System.out.println("Jenis: " + jenisBuku);
            System.out.println("Stok: " + buku.getJumlahStok());

            if (buku instanceof Majalah) {
                Majalah majalah = (Majalah) buku;
                System.out.println("Nomor Edisi: " + majalah.getNomorEdisi());
            }

            System.out.println("------------------------------");
        }
    }

    private static void lihatLaporanKeuangan() {
        int keuntungan = modalBerjalan - modalAwal;

        System.out.println("\nLaporan Keuangan");
        System.out.println("=========================");
        System.out.println("Modal Awal    : " + modalAwal);
        System.out.println("Keuntungan    : " + keuntungan);
        System.out.println("Modal Berjalan: " + modalBerjalan);
        System.out.println("=========================");
    }
}
    

