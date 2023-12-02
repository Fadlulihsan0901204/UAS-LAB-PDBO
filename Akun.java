import java.util.*;

/**
 * Kelas Akun merepresentasikan entitas pengguna dalam sistem.
 *
 * @author Siska Auliani
 * @version 1.0
 */
public class Akun {

    /** Nama pengguna (username) dari akun. */
    public String username;

    /** Kata sandi (password) dari akun. */
    public String password;

    /**
     * Konstruktor untuk membuat objek Akun dengan username dan password tertentu.
     *
     * @param username Nama pengguna (username) untuk akun.
     * @param password Kata sandi (password) untuk akun.
     */
    public Akun(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Mendapatkan nama pengguna (username) dari akun.
     *
     * @return Nama pengguna (username) akun.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Mendapatkan kata sandi (password) dari akun.
     *
     * @return Kata sandi (password) akun.
     */
    public String getPassword() {
        return password;
    }
}
