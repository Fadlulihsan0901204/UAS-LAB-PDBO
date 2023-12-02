import java.util.*;

/**
 * Kelas Customer merepresentasikan entitas pelanggan dalam sistem.
 *
 * <p>
 * Kelas ini merupakan turunan dari kelas Akun dan memiliki atribut tambahan
 * berupa objek Keranjang untuk menyimpan barang yang akan dibeli, serta
 * ArrayList Invoice untuk menyimpan riwayat transaksi yang telah selesai.
 * </p>
 *
 * @author Siska Auliani
 * @version 1.0
 */
public class Customer extends Akun {

    /** Objek Keranjang untuk menyimpan barang yang akan dibeli oleh pelanggan. */
    public Keranjang keranjang;

    /** ArrayList Invoice untuk menyimpan riwayat transaksi yang telah selesai. */
    public ArrayList<Invoice> invoiceSelesai;

    /**
     * Konstruktor untuk membuat objek Customer dengan username dan password tertentu.
     * Selain itu, inisialisasi objek Keranjang dan ArrayList Invoice.
     *
     * @param username Nama pengguna (username) untuk akun pelanggan.
     * @param password Kata sandi (password) untuk akun pelanggan.
     */
    public Customer(String username, String password) {
        super(username, password);
        this.keranjang = new Keranjang();
        this.invoiceSelesai = new ArrayList<>();
    }
}
