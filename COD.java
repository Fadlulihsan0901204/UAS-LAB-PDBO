import java.util.*;

/**
 * Kelas COD (Cash On Delivery) merepresentasikan metode pembayaran menggunakan pembayaran tunai saat barang diterima.
 * Kelas ini mengambil turunan dari kelas Pembayaran dan memberikan rincian
 * spesifik terkait dengan pembayaran secara langsung saat pengiriman barang.
 */
class COD extends Pembayaran {

  /**
   * Mendapatkan metode pembayaran yang digunakan, yaitu "COD" (Cash On Delivery).
   *
   * @return Metode pembayaran sebagai string.
   */
  @Override
  public String getMetode() {
    return "COD";
  }

  /**
   * Menampilkan instruksi pembayaran untuk metode pembayaran tunai saat barang diterima (COD).
   * Termasuk informasi bahwa pembayaran akan dilakukan secara tunai dan
   * nasihat untuk memastikan ketersediaan uang tunai yang cukup.
   */
  @Override
  public void tampilkanInstruksiPembayaran() {
    System.out.println("Pembayaran akan dilakukan secara tunai saat barang diterima.");
    System.out.println("Pastikan Anda memiliki uang tunai yang cukup.");
  }
}
