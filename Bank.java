import java.util.*;
class Bank extends Pembayaran {
  private String nomorRekening;

  public Bank(String nomorRekening) {
    this.nomorRekening = nomorRekening;
  }

  @Override
  public String getMetode() {
    return "Bank Transfer";
  }

  @Override
  public void tampilkanInstruksiPembayaran() {
    System.out.println("Mohon transfer sesuai total harga ke nomor rekening " + nomorRekening);
  }
}