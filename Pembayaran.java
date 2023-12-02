import java.util.*;
public abstract class Pembayaran {
  // Metode abstrak untuk mendapatkan jenis metode pembayaran
  public abstract String getMetode();

  // Metode abstrak untuk menampilkan instruksi pembayaran
  public abstract void tampilkanInstruksiPembayaran();
}