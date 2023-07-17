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
class Buku {
    private final String judul;
    private final int hargaBeli;
    final int hargaJual;
    private int jumlahStok;

    public Buku(String judul, int hargaBeli, int hargaJual, int jumlahStok) {
        this.judul = judul;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.jumlahStok = jumlahStok;
    }

    public String getJudul() {
        return judul;
    }

    public int getHargaBeli() {
        return hargaBeli;
    }

    public int getHargaJual() {
        return hargaJual;
    }

    public int getJumlahStok() {
        return jumlahStok;
    }

    public void tambahStok(int jumlah) {
        jumlahStok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (jumlahStok >= jumlah) {
            jumlahStok -= jumlah;
        } else {
            System.out.println("Stok sudah mencapai nol.");
        }
    }
}

