import java.util.*;

/**
 * Kelas abstrak Pembayaran menyediakan kerangka dasar untuk metode pembayaran.
 * Kelas ini berisi metode-metode abstrak yang harus diimplementasikan oleh kelas turunannya.
 */
public abstract class Pembayaran {

  /**
   * Metode abstrak untuk mendapatkan jenis metode pembayaran.
   *
   * @return Jenis metode pembayaran sebagai string.
   */
  public abstract String getMetode();

  /**
   * Metode abstrak untuk menampilkan instruksi pembayaran.
   * Implementasi metode ini akan bervariasi tergantung pada jenis metode pembayaran.
   */
  public abstract void tampilkanInstruksiPembayaran();
}
