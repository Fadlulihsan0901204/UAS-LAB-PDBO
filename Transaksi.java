import java.util.*;


/**
 * Kelas {@code Transaksi} merepresentasikan sebuah transaksi yang dilakukan oleh seorang akun (pelanggan).
 * Setiap transaksi dapat terdiri dari beberapa barang yang dibeli oleh pelanggan.
 * Transaksi dapat di-generate menjadi invoice dan memiliki status apakah sudah diterima oleh admin atau belum.
 *
 * <p>
 * Author: Aulia Vika Rahman
 * </p>
 */
public class Transaksi {

  /**
     * Akun (pelanggan) yang melakukan transaksi.
     */
  public Akun akun;

  /**
     * Daftar barang yang dibeli dalam transaksi.
     */
  public ArrayList<Barang> barang;

  /**
     * Status apakah transaksi sudah diterima oleh admin atau belum.
     */
  public boolean acceptedByAdmin;


   /**
     * Konstruktor untuk membuat objek transaksi.
     *
     * @param akun   Akun (pelanggan) yang melakukan transaksi.
     * @param barang Daftar barang yang dibeli dalam transaksi.
     */
  public Transaksi(Akun akun, ArrayList<Barang> barang) {
    this.akun = akun;
    this.barang = new ArrayList<>();
    this.acceptedByAdmin = false;

    
    for (Barang b : barang) {
      addOrUpdateItem(b);
    }
  }

  /**
     * Metode untuk menambah atau memperbarui item dalam daftar barang transaksi.
     *
     * @param newItem Barang yang akan ditambahkan atau diperbarui.
     */
  private void addOrUpdateItem(Barang newItem) {
    boolean found = false;

    for (Barang existingItem : this.barang) {
      if (existingItem.nama.equals(newItem.nama)) {
        existingItem.stok += newItem.stok;
        found = true;
        break;
      }
    }

    if (!found) {
      //Apabila item belum pernah di masukkan ke keranjang, tambahkan item tersebut
      this.barang.add(new Barang(newItem.nama, newItem.harga, newItem.stok));
    }
  }

   /**
     * Metode untuk menghasilkan objek {@code Invoice} berdasarkan transaksi.
     *
     * @param pembayaran Metode pembayaran yang akan digunakan dalam invoice.
     * @param tanggal    Tanggal transaksi dilakukan.
     * @return Objek {@code Invoice} yang dihasilkan.
     */
  public Invoice generateInvoice(Pembayaran pembayaran, Date tanggal) {
    return new Invoice(this, pembayaran, tanggal);
  }

  /**
     * Metode untuk menghitung total harga dari seluruh barang dalam transaksi.
     *
     * @return Total harga dari seluruh barang dalam transaksi.
     */
  public int totalHarga() {
    int total = 0;
    for (Barang b : barang) {
      total += b.harga * b.stok;
    }
    return total;
  }
}
