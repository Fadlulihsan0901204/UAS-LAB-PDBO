import java.util.*;

/**
 * Kelas Bank merepresentasikan metode pembayaran menggunakan Transfer Bank.
 * Kelas ini mengambil turunan dari kelas Pembayaran dan memberikan rincian
 * spesifik terkait transaksi perbankan.
 */
class Bank extends Pembayaran {

  /**
   * Nomor rekening bank yang terkait dengan transaksi.
   */
  private String nomorRekening;

  /**
   * Membuat objek Bank dengan nomor rekening bank yang spesifik.
   *
   * @param nomorRekening Nomor rekening bank untuk transaksi.
   */
  public Bank(String nomorRekening) {
    this.nomorRekening = nomorRekening;
  }

  /**
   * Mendapatkan metode pembayaran yang digunakan, yaitu "Transfer Bank".
   *
   * @return Metode pembayaran sebagai string.
   */
  @Override
  public String getMetode() {
    return "Transfer Bank";
  }

  /**
   * Menampilkan petunjuk pembayaran untuk transfer bank.
   * Termasuk permintaan untuk mentransfer jumlah total ke
   * nomor rekening bank yang spesifik.
   */
  @Override
  public void tampilkanInstruksiPembayaran() {
    System.out.println("Mohon transfer sesuai total harga ke nomor rekening " + nomorRekening);
  }
}
