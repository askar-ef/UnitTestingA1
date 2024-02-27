import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WalletTest {

    @Test
    void TestSetOwner(){
        Wallet wallet = new Wallet("Askar");
        // Mengecek bahwa nilai owner sama seperti saat awal membuat objek
        Assertions.assertEquals("Askar", wallet.getOwner());

        // mengubah nilai owner dengan setOwner
        wallet.setOwner("Fathin");

        Assertions.assertAll(
                // mengecek bahwa nilai owner tetap ada setelah diubah
                () -> Assertions.assertNotNull(wallet.getOwner()),
                // mengecek bahwa nilai owner berhasil untuk diubah
                () -> Assertions.assertEquals("Fathin", wallet.getOwner())
        );
    }

    @Test
    void TestTambahKartu(){
        Wallet wallet = new Wallet("Askar");
        // menambahkan kartu
        wallet.tambahKartu("BCA");


        Assertions.assertAll(
                // mengecek bahwa list tidak bernilai kosong
                () -> Assertions.assertNotNull(wallet.getListKartu()),
                // mengecek bahwa kartu yang ditambahkan telah masuk ke list
                () -> Assertions.assertTrue(wallet.getListKartu().contains("BCA"))

        );
    }

    @Test
    void TestAmbilKartu(){
        Wallet wallet = new Wallet("Askar");
        wallet.tambahKartu("BCA");

        // mengambil kartu yang ada di dalam list
        wallet.ambilKartu("BCA");

        // mengecek bahwa kartu yang diambil sudah tidak ada lagi di dalam list
        Assertions.assertFalse(wallet.getListUangKoin().contains("BCA"));
    }

    @Test
    void TestTambahUang(){
        Wallet wallet = new Wallet("Askar");
        // menambahkan saldo uang
        wallet.tambahUang(20000);
        wallet.tambahUang(500);

        // mengecek bahwa uang bernilai > 1000 masuk ke dalam list uang lembaran
        Assertions.assertTrue(wallet.getListUangLembaran().contains(20000));
        // mengecek bahwa uang bernilai < 1000 masuk ke dalam list uang koin
        Assertions.assertTrue(wallet.getListUangKoin().contains(500));
    }

    @Test
    void TestAmbilUang(){
        Wallet wallet = new Wallet("Askar");
        wallet.tambahUang(20000);
        // mengambil uang yang terdapat pada list
        wallet.ambilUang(20000);

        // mengecek bahwa uang yang diambil sudah tidak ada lagi di dalam list
        Assertions.assertFalse(wallet.getListUangLembaran().contains(20000));
    }

    @Test
    void TestTampilkanUang(){
        Wallet wallet = new Wallet("Askar");
        // menambahkan uang
        wallet.tambahUang(20000);
        wallet.tambahUang(1000);
        wallet.tambahUang(500);

        // mengecek bahwa jumlah uang yang terdapat pada wallet
        Assertions.assertEquals(21500, wallet.tampilkanUang());
    }
}
