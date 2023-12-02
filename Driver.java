import java.util.*;

/**
 * Kelas abstrak Driver merepresentasikan entitas pengemudi dalam sistem.
 *
 * <p>
 * Kelas ini bersifat abstrak dan menyediakan metode abstrak menu() yang harus
 * diimplementasikan oleh kelas turunannya. Metode ini digunakan untuk menampilkan
 * menu yang spesifik untuk setiap jenis pengemudi.
 * </p>
 *
 * <p>
 * Implementasi kelas turunan harus menyediakan fungsionalitas menu sesuai dengan
 * peran masing-masing pengemudi dalam sistem.
 * </p>
 *
 * @author Siska Auliani
 * @version 1.0
 */
public abstract class Driver {

    /**
     * Menampilkan menu yang spesifik untuk jenis pengemudi tertentu.
     * Implementasi metode ini harus disediakan oleh kelas turunan.
     */
    public abstract void menu();
}
