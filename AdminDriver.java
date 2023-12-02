import java.util.*;
/**
 * Kelas {@code AdminDriver} merupakan pengemudi (driver) untuk pengguna dengan peran administrator.
 * Kelas ini menyediakan fungsionalitas untuk mengelola daftar barang, menerima transaksi,
 * dan melakukan operasi-administratif lainnya.
 * 
 * <p>
 * Pengguna dapat memilih berbagai opsi melalui menu yang disediakan.
 * </p>
 * 
 * <p>
 * Author: Aulia Vika Rahman
 * </p>
 */
public class AdminDriver extends Driver {
  /**
     * Akun administrator yang sedang aktif.
     */
  private Admin akun;
   /**
     * Daftar barang yang tersedia.
     */
  private ListBarang listBarang;
   /**
     * Daftar transaksi yang telah dilakukan oleh pelanggan.
     */
  private ArrayList<Transaksi> listTransaksi;

  
    /**
     * Membuat objek {@code AdminDriver} dengan daftar barang dan daftar transaksi yang diberikan.
     *
     * @param listBarang    Daftar barang yang tersedia.
     * @param listTransaksi Daftar transaksi yang telah dilakukan oleh pelanggan.
     */
  public AdminDriver(
    ListBarang listBarang,
    ArrayList<Transaksi> listTransaksi
  ) {
    this.listBarang = listBarang;
    this.listTransaksi =
      listTransaksi != null ? listTransaksi : new ArrayList<>();
  }
 /**
     * Menampilkan menu interaktif untuk administrator dan memproses input mereka.
     */
  public void menu() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\n=========================");
      System.out.println("|       MENU ADMIN      |");
      System.out.println("=========================");

      System.out.println("|  1. Tambah Barang     |");
      System.out.println("|  2. Hapus Barang      |");
      System.out.println("|  3. Edit Barang       |");
      System.out.println("|  4. Lihat Transaksi   |");
      System.out.println("|  5. Lihat Barang      |");
      System.out.println("|  0. Log Out           |");
      System.out.println("=========================");
      System.out.print("Pilihan Anda: ");
      try {
        int pilih = scanner.nextInt();
        switch (pilih) {
          case 1:
            System.out.print("\nMasukkan nama barang : ");
            String nama = scanner.next();

            System.out.print("Masukkan harga barang : ");
            int harga = scanner.nextInt();
            if (harga <= 0) {
            throw new IllegalArgumentException("Harga harus lebih dari 0");
            }
            System.out.print("Masukkan stok barang : ");
            int stok = scanner.nextInt();
            tambahBarang(nama, harga, stok);
            listBarang.updateListBarang(listBarang.barang);
            break;
          case 2:
            System.out.print("\nMasukkan nama barang yang akan dihapus : ");
            String namaHapus = scanner.next();
            hapusBarang(namaHapus);
            listBarang.updateListBarang(listBarang.barang);
            break;
          case 3:
            System.out.print("\nMasukkan nama barang yang akan diedit: ");
            scanner.nextLine();
            String namaEdit = scanner.next();
            System.out.print("Masukkan nama baru: ");
            String newNama = scanner.next();
            System.out.print("Masukkan harga baru: ");
            int newHarga = scanner.nextInt();
            editBarang(namaEdit, newNama, newHarga);
            listBarang.updateListBarang(listBarang.barang);
            break;
          case 4:
            lihatDanTerimaTransaksi();
            break;
          case 5:
            lihatListBarang();
            break;
          case 0:
            System.out.println("\nLogout berhasil.\n");
            return;
          default:
            System.out.println("\nPilihan tidak valid.\n");
        }
      } catch (InputMismatchException e) {
        System.out.println("Masukkan harus berupa angka.");
        scanner.next(); // Membersihkan buffer
        continue; // Mengulang loop
      }
    }
  }

   /**
     * Menambahkan barang ke daftar barang yang tersedia.
     *
     * @param nama  Nama barang yang akan ditambahkan.
     * @param harga Harga barang yang akan ditambahkan.
     * @param stok  Stok barang yang akan ditambahkan.
     */
  public void tambahBarang(String nama, int harga, int stok) {
    Barang barang = new Barang(nama, harga, stok);
    listBarang.barang.add(barang);
  }

  /**
     * Menampilkan daftar barang yang tersedia.
     */
  public void lihatListBarang() {
    System.out.println("\nList Barang:");
    for (Barang barang : listBarang.barang) {
      System.out.println("Nama  : " + barang.nama);
      System.out.println("Harga : Rp." + barang.harga);
      System.out.println("Stok  : " + barang.stok + "\n");
    }
  }

     /**
     * Menghapus barang dari daftar barang yang tersedia.
     *
     * @param namaHapus Nama barang yang akan dihapus.
     */
  public void hapusBarang(String namaHapus) {
    Iterator<Barang> iterator = listBarang.barang.iterator();
    boolean found = false;
    while (iterator.hasNext()) {
      Barang barang = iterator.next();
      if (barang.nama.equalsIgnoreCase(namaHapus)) {
        iterator.remove();
        found = true;
        break;
      }
    }

    if (found) {
      System.out.println("\nBarang dihapus.\n");
    } else {
      System.out.println("\nBarang tidak ditemukan.\n");
    }
  }

   /**
     * Mengedit barang dalam daftar barang yang tersedia.
     *
     * @param namaBarang Nama barang yang akan diedit.
     * @param newNama    Nama baru untuk barang.
     * @param newHarga   Harga baru untuk barang.
     */
  public void editBarang(String namaBarang, String newNama, int newHarga) {
    Iterator<Barang> iterator = listBarang.barang.iterator();

    while (iterator.hasNext()) {
      Barang barang = iterator.next();
      if (barang.nama.equals(namaBarang)) {
        barang.nama = newNama;
        barang.harga = newHarga;
        System.out.println("Barang diedit.");
        return;
      }
    }
    System.out.println("Barang tidak ditemukan.");
  }

  /**
     * Menambahkan transaksi ke daftar transaksi yang sedang menunggu.
     *
     * @param transaksi Transaksi yang akan ditambahkan.
     */
  public void addListTransaksi(Transaksi transaksi) {
    Main.listTransaksi.add(transaksi);
  }

  /**
     * Menampilkan daftar transaksi yang sedang menunggu dan memberikan opsi untuk menerima atau menolak.
     */
  public void lihatDanTerimaTransaksi() {
    Scanner scanner = new Scanner(System.in);
    if(listTransaksi.isEmpty()){
      System.out.println("\nBelum ada transaksi ");
      return;
    }

    System.out.println("\nDaftar Transaksi Menunggu:");
    for (Transaksi transaksi : listTransaksi) {
      if (!transaksi.acceptedByAdmin) {

        System.out.println("\nUsername: " + transaksi.akun.getUsername());
        System.out.println("Total Harga: Rp " + transaksi.totalHarga());
        System.out.println("---------------------------------------------");
        System.out.printf("|    %-12s |     %-9s |  %-6s |%n", "Nama Barang", "Harga", "Jumlah");
        System.out.println("---------------------------------------------");

        for (Barang barang : transaksi.barang) {
          System.out.printf("| %-15s |  Rp %-9d |    %-5d|%n",barang.nama,barang.harga,barang.stok);
        }

        System.out.println("---------------------------------------------");
        System.out.print(
          "Apakah Anda ingin menerima transaksi ini? (ya/tidak): "
        );
        String acceptpilih = scanner.next().toLowerCase();

        if (acceptpilih.equals("ya")) {
          transaksi.acceptedByAdmin = true;
          System.out.println("\nTransaksi diterima.");
        } else if(acceptpilih.equals("tidak")) {
          System.out.println("Apakah transaksi ingin ditolak ? (ya/tidak)");
          String tolak = scanner.next().toLowerCase();
          if(tolak.equals("ya")){
            transaksi.acceptedByAdmin = false;
            System.out.println("Transaksi ditolak");
             listTransaksi.remove(transaksi);
            return;
          }
        }
      }
    }
  }

}