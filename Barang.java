import java.util.*;

/**
 * Kelas Barang merepresentasikan entitas barang dalam sistem.
 *
 * @author Siska Auliani
 * @version 1.0
 */
public class Barang {

    /** Nama barang. */
    String nama;

    /** Harga barang. */
    int harga;

    /** Jumlah stok barang. */
    int stok;

    /**
     * Konstruktor untuk membuat objek Barang dengan nama, harga, dan stok tertentu.
     *
     * @param nama  Nama barang.
     * @param harga Harga barang.
     * @param stok  Jumlah stok barang.
     */
    public Barang(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }
}
