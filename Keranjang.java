import java.util.*;

/**
 * Kelas Keranjang merepresentasikan entitas keranjang belanja dalam sistem.
 *
 * <p>
 * Kelas ini memiliki atribut berupa ArrayList barang untuk menyimpan daftar
 * barang yang ada dalam keranjang belanja dan atribut transaksi untuk menyimpan
 * informasi transaksi yang terkait dengan keranjang.
 * </p>
 *
 * <p>
 * Kelas ini digunakan untuk mengelola barang-barang yang akan dibeli oleh
 * pelanggan sebelum proses transaksi selesai.
 * </p>
 *
 * @author Siska Auliani
 * @version 1.0
 */
public class Keranjang {

    /** ArrayList untuk menyimpan daftar barang dalam keranjang belanja. */
    public ArrayList<Barang> barang;

    /** Objek Transaksi untuk menyimpan informasi transaksi yang terkait dengan keranjang. */
    public Transaksi transaksi;

    /**
     * Konstruktor untuk membuat objek Keranjang dengan inisialisasi ArrayList barang.
     * Setiap instance Keranjang akan memiliki daftar barang kosong pada awalnya.
     */
    public Keranjang() {
        this.barang = new ArrayList<>();
    }
}
