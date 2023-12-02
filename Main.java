import java.util.*;

/**
 * Kelas {@code Main} merupakan entry point program untuk aplikasi PBO STORE.
 * Program ini menyediakan fungsionalitas login untuk admin dan pelanggan,
 * serta pendaftaran akun admin dan pelanggan.
 *
 * <p>
 * Author: Aulia Vika Rahman
 * </p>
 */
 class Main {

  /**
   * Daftar admin yang terdaftar di aplikasi.
   */
  public static ArrayList<Admin> listAdmins = new ArrayList<>();

  /**
   * Daftar pelanggan yang terdaftar di aplikasi.
   */
  public static ArrayList<Customer> listCustomers = new ArrayList<>();

  /**
   * Daftar barang yang tersedia di toko.
   */
  public static ListBarang listBarang = new ListBarang();

  /**
   * Daftar transaksi yang telah dilakukan oleh pelanggan.
   */
  public static ArrayList<Transaksi> listTransaksi = new ArrayList<>();

  /**
   * Objek pelanggan yang sedang aktif.
   */
  public static Customer customer;

  /**
   * Objek admin yang sedang aktif.
   */
  public static Admin admin;

  /**
   * Metode utama untuk menjalankan aplikasi.
   *
   * @param args Argumen yang diberikan saat menjalankan program.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean lanjut = true;

    System.out.println(
      "============== SELAMAT DATANG DI PBO STORE =============="
    );

    while (lanjut) {
      login();
      System.out.print("Apakah Anda ingin login kembali? (ya/tidak): ");
      String jawab = scanner.nextLine().toLowerCase();

      if (jawab.equals("tidak")) {
        System.out.println("Terimakasih, Sampai Jumpa!");
        lanjut = false;
      }
    }
  }

  /**
   * Metode untuk melakukan login sebagai admin atau pelanggan.
   */
  public static void login() {
    Scanner scanner = new Scanner(System.in);

    try {
      System.out.println(
        "---------------------------------------------------------------"
      );
      System.out.println(
        "| Pilih role:                                                 |"
      );
      System.out.println(
        "| 1. Admin                                                    |"
      );
      System.out.println(
        "| 2. Customer                                                 |"
      );
      System.out.println(
        "| 3. Daftar Akun Admin                                        |"
      );
      System.out.println(
        "| 4. Daftar Akun Customer                                     |"
      );
      System.out.println(
        "---------------------------------------------------------------"
      );
      System.out.print("Masukkan pilihan (1/2/3/4):  ");

      int pilih = scanner.nextInt();
      scanner.nextLine();

      switch (pilih) {
        case 1:
          // Login Admin
          System.out.print("\nUsername Admin: ");
          String inputUsernameAdmin = scanner.nextLine();
          System.out.print("Password Admin: ");
          String inputPasswordAdmin = scanner.nextLine();

          // Cek apakah akun admin sudah terdaftar
          Admin existingAdmin = findAdmin(
            inputUsernameAdmin,
            inputPasswordAdmin
          );
          if (existingAdmin != null) {
            if (admin == null) {
              admin = existingAdmin;
            }
            AdminDriver adminDriver = new AdminDriver(
              listBarang,
              listTransaksi
            );
            adminDriver.menu();
          } else {
            System.out.println(
              "Username atau Password salah atau akun tidak terdaftar.\n"
            );
          }
          break;
        case 2:
          // Login Customer
          System.out.print("\nUsername Customer: ");
          String inputUsernameCustomer = scanner.nextLine();
          System.out.print("Password Customer: ");
          String inputPasswordCustomer = scanner.nextLine();

          // Cek apakah akun customer sudah terdaftar
          Customer existingCustomer = findCustomer(
            inputUsernameCustomer,
            inputPasswordCustomer
          );
          if (existingCustomer != null) {
            if (customer == null) {
              customer = existingCustomer;
            }
            CustomerDriver customerDriver = new CustomerDriver(
              customer,
              listBarang,
              new Transaksi(customer, new ArrayList<>())
            );
            customerDriver.menu();
          } else {
            System.out.println(
              "Username atau Password salah atau akun tidak terdaftar.\n"
            );
          }
          break;
        case 3:
          // Daftar Akun Admin
          registerAdmin();
          break;
        case 4:
          // Daftar Akun Customer
          registerCustomer();
          break;
        default:
          System.out.println(
            "\nPilihan tidak valid. Silakan pilih 1 untuk Admin, 2 untuk Customer, 3 untuk Daftar Akun Admin, atau 4 untuk Daftar Akun Customer."
          );
          break;
      }
    } catch (InputMismatchException e) {
      System.out.println("Masukkan harus berupa angka.");
      scanner.nextLine(); // Membersihkan buffer
    }
  }

  /**
   * Metode untuk mencari akun admin berdasarkan username dan password.
   *
   * @param username Username admin yang ingin dicari.
   * @param password Password admin yang ingin dicari.
   * @return Objek admin jika ditemukan, null jika tidak ditemukan.
   */
  private static Admin findAdmin(String username, String password) {
    for (Admin admin : listAdmins) {
      if (
        admin.getUsername().equals(username) &&
        admin.getPassword().equals(password)
      ) {
        return admin;
      }
    }
    return null;
  }

  /**
   * Metode untuk mencari akun customer berdasarkan username dan password.
   *
   * @param username Username customer yang ingin dicari.
   * @param password Password customer yang ingin dicari.
   * @return Objek customer jika ditemukan, null jika tidak ditemukan.
   */
  private static Customer findCustomer(String username, String password) {
    for (Customer customer : listCustomers) {
      if (
        customer.getUsername().equals(username) &&
        customer.getPassword().equals(password)
      ) {
        return customer;
      }
    }
    return null;
  }

  /**
   * Metode untuk pendaftaran akun admin.
   */
  public static void registerAdmin() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nPendaftaran Akun Admin");
    System.out.print("Username Admin: ");
    String username = scanner.nextLine();
    System.out.print("Password Admin: ");
    String password = scanner.nextLine();

    Admin newAdmin = new Admin(username, password);
    listAdmins.add(newAdmin);
    System.out.println("Akun Admin berhasil didaftarkan.\n");
  }

  // Method untuk pendaftaran akun customer
  public static void registerCustomer() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nPendaftaran Akun Customer");
    System.out.print("Username Customer: ");
    String username = scanner.nextLine();
    System.out.print("Password Customer: ");
    String password = scanner.nextLine();

    Customer newCustomer = new Customer(username, password);
    listCustomers.add(newCustomer);
    System.out.println("Akun Customer berhasil didaftarkan.\n");
  }
}
