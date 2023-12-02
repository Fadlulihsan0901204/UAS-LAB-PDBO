import java.util.*;

/**
 * Kelas {@code Invoice} merepresentasikan faktur atau tagihan untuk suatu transaksi.
 * Setiap invoice terkait dengan sebuah transaksi dan metode pembayaran yang digunakan.
 *
 * <p>
 * Author: Aulia Vika Rahman
 * </p>
 */
public class Invoice {

  /**
   * Transaksi yang terkait dengan invoice.
   */
  public Transaksi transaksi;

  /**
   * Metode pembayaran yang digunakan untuk invoice.
   */
  public Pembayaran pembayaran;

  /**
   * Tanggal pemesanan atau pembuatan invoice.
   */
  public Date tanggal;

  /**
   * Konstruktor untuk membuat objek invoice.
   *
   * @param transaksi   Transaksi yang terkait dengan invoice.
   * @param pembayaran  Metode pembayaran yang digunakan untuk invoice.
   * @param tanggal     Tanggal pemesanan atau pembuatan invoice.
   */
  public Invoice(Transaksi transaksi, Pembayaran pembayaran, Date tanggal) {
    this.transaksi = transaksi;
    this.pembayaran = pembayaran;
    this.tanggal = tanggal;
  }

  /**
   * Metode untuk menghasilkan ID unik untuk invoice.
   *
   * @return String berisi ID unik invoice.
   */
  private String generateInvoiceId() {
    return UUID.randomUUID().toString();
  }

  /**
   * Metode untuk mencetak informasi invoice.
   */
  public void printInvoice() {
    System.out.println("---------------------------------------------------");
    System.out.println("| Invoice ID: " + generateInvoiceId() + "|");
    System.out.println("| Tanggal Pemesanan: " + tanggal + " |");
    System.out.println("---------------------------------------------------");
    for (Barang barang : transaksi.barang) {
      int quantity = jumlahBarangDibeli(barang.nama);
      int totalInvoice = hitungTotal(barang.harga, quantity);
      System.out.println(
        " - " + barang.nama + " (Qty: " + quantity + ") - Rp " + totalInvoice
      );
    }

    System.out.println(" Total Harga: Rp " + hitungTotal());
    System.out.println(" Metode Pembayaran: " + metodePembayaran());
    System.out.println("---------------------------------------------------");
  }

  /**
   * Metode untuk menghitung jumlah barang yang dibeli.
   *
   * @param itemName Nama barang.
   * @return Jumlah barang yang dibeli.
   */
  private int jumlahBarangDibeli(String itemName) {
    int quantity = 0;
    for (Barang barang : transaksi.barang) {
      if (barang.nama.equals(itemName)) {
        quantity += barang.stok;
      }
    }
    return quantity;
  }

  /**
   * Metode untuk menghitung total harga suatu barang dalam transaksi.
   *
   * @param harga    Harga barang.
   * @param quantity Jumlah barang yang dibeli.
   * @return Total harga suatu barang.
   */
  private int hitungTotal(int harga, int quantity) {
    return harga * quantity;
  }

  /**
   * Metode untuk menghitung total harga seluruh barang dalam transaksi.
   *
   * @return Total harga seluruh barang dalam transaksi.
   */
  private int hitungTotal() {
    int total = 0;
    for (Barang barang : transaksi.barang) {
      total += hitungTotal(barang.harga, barang.stok);
    }
    return total;
  }

  /**
   * Metode untuk mendapatkan informasi metode pembayaran.
   *
   * @return Informasi metode pembayaran.
   */
  private String metodePembayaran() {
    if (pembayaran instanceof Qris) {
      return ((Qris) pembayaran).getMetode();
    } else if (pembayaran instanceof COD) {
      return ((COD) pembayaran).getMetode();
    } else if (pembayaran instanceof Bank) {
      return ((Bank) pembayaran).getMetode();
    } else {
      return "Metode Pembayaran Tidak Dikenali";
    }
  }
}
