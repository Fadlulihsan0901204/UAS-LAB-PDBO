import java.util.*;
class COD extends Pembayaran {

  @Override
  public String getMetode() {
    return "COD";
  }

  @Override
  public void tampilkanInstruksiPembayaran() {
    System.out.println("Pembayaran akan dilakukan secara tunai saat barang diterima.");
    System.out.println("Pastikan Anda memiliki uang tunai yang cukup.");
  }
}