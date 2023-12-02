import java.util.*;

/**
 * Kelas Admin merupakan turunan dari kelas Akun yang merepresentasikan
 * entitas admin dalam sistem.
 *
 * @author Siska Auliani
 * @version 1.0
 */
public class Admin extends Akun {

    /**
     * Konstruktor untuk membuat objek Admin dengan username dan password tertentu.
     *
     * @param username Nama pengguna (username) untuk akun admin.
     * @param password Kata sandi (password) untuk akun admin.
     */
    public Admin(String username, String password) {
        super(username, password);
    }
}
