import org.example.Wallet;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class WalletTest {
    private static Wallet wallet;

    @BeforeAll
    static void initClass() {
        wallet = new Wallet("Askar");
        System.out.println("Before all tests");
    }

    @AfterAll
    static void cleanClass() {
        wallet = null;
        System.out.println("After all tests");
    }

    @BeforeEach
    void initMethod() {
        System.out.println("Before each test");
    }

    @AfterEach
    void cleanMethod() {
        wallet.setListKartu(new ArrayList<>()); // Mengosongkan list kartu setelah setiap pengujian
        wallet.setListUangKoin(new ArrayList<>()); // Mengosongkan list uang koin setelah setiap pengujian
        wallet.setListUangLembaran(new ArrayList<>()); // Mengosongkan list uang lembaran setelah setiap pengujian
        System.out.println("After each test");
        System.out.println("");
    }

    @Test
    void TestSetOwner(){
        Assertions.assertEquals("Askar", wallet.getOwner());

        wallet.setOwner("Fathin");

        Assertions.assertAll(
                () -> Assertions.assertNotNull(wallet.getOwner()),
                () -> Assertions.assertEquals("Fathin", wallet.getOwner())
        );

        System.out.println("Test Nama Owner");
    }

    @Test
    void TestTambahKartu(){
        wallet.tambahKartu("BCA");
        Assertions.assertAll(
                () -> Assertions.assertNotNull(wallet.getListKartu()),
                () -> Assertions.assertTrue(wallet.getListKartu().contains("BCA"))
        );

        System.out.println("Test Tambah Kartu");
    }

    @Test
    void TestAmbilKartu(){
        wallet.tambahKartu("BCA");
        wallet.ambilKartu("BCA");

        Assertions.assertFalse(wallet.getListKartu().contains("BCA"));

        System.out.println("Test Ambil Kartu");
    }

    @Test
    void TestTambahUang(){
        wallet.tambahUang(20000);
        wallet.tambahUang(500);

        Assertions.assertAll(
                () -> Assertions.assertTrue(wallet.getListUangLembaran().contains(20000)),
                () -> Assertions.assertTrue(wallet.getListUangKoin().contains(500))
        );

        System.out.println("Test Tambah Uang");
    }

    @Test
    void TestAmbilUang(){
        wallet.tambahUang(20000);
        wallet.ambilUang(20000);

        Assertions.assertFalse(wallet.getListUangLembaran().contains(20000));

        System.out.println("Test Ambil Uang");
    }

    @Test
    void TestTampilkanUang(){
        wallet.tambahUang(20000);
        wallet.tambahUang(1000);
        wallet.tambahUang(500);

        Assertions.assertEquals(21500, wallet.tampilkanUang());

        System.out.println("Test Tampilkan Uang");
    }
}
