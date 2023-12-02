/**
 * Kelas Qris merupakan implementasi metode pembayaran menggunakan QRIS (Quick Response Code).
 * Kelas ini mengambil turunan dari kelas Pembayaran dan menyediakan rincian
 * terkait dengan pembayaran melalui QR Code.
 */
public class Qris extends Pembayaran {

  /**
   * Mendapatkan jenis metode pembayaran, yaitu "QRIS".
   *
   * @return Jenis metode pembayaran sebagai string.
   */
  @Override
  public String getMetode() {
    return "QRIS";
  }

  /**
   * Menampilkan instruksi pembayaran untuk metode pembayaran menggunakan QRIS.
   * Instruksi mencakup pesan untuk memindai QR Code yang disediakan.
   */
  @Override
  public void tampilkanInstruksiPembayaran() {
    System.out.println("Scan QR Code Berikut :");
    System.out.println("||||||||||||||||||||||");
    System.out.println("||||||||||||    |||| |");
    System.out.println("|||  | ||||| || ||| ||");
    System.out.println("|  |||| ||||    ||||| ");
    System.out.println("|  |||| | |||||||| |||");
    System.out.println("|||    |||| |||| || ||");
    System.out.println("|||||||||||||||||| |||");
  }
}
