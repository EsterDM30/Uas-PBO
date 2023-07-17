/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author L E N O V O
 */
class Majalah extends Buku {
    private final int nomorEdisi;

    public Majalah(String judul, int hargaBeli, int hargaJual, int jumlahStok, int nomorEdisi) {
        super(judul, hargaBeli, hargaJual, jumlahStok);
        this.nomorEdisi = nomorEdisi;
    }

    public int getNomorEdisi() {
        return nomorEdisi;
    }
}
