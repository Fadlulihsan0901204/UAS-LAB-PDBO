public class Qris extends Pembayaran {

   @Override
  public String getMetode() {
    return "QRIS";
  }
  @Override
   public void tampilkanInstruksiPembayaran(){
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