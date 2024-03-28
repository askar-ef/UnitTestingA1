package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class WalletQuizTest {
    private WalletQuiz wallet1;
    private WalletQuiz wallet2;

    // Kode ini hanya sebagai penanda sebelum semua kode dijalankan
    @BeforeAll
    public static void setUpAll() {
        System.out.println("Initializing WalletQuiz tests...");
    }

    // Kode ini akan dijalankan sebagai inisialisasi objek dari awal saat mengecek setiap kode yang ada
    @BeforeEach
    public void setUp() {
        wallet1 = new WalletQuiz(100.0, "USD");
        wallet2 = new WalletQuiz(50.0, "USD");
    }

    // Kode ini hanya penanda setelah semua pengujian telah selesai dilakukan
    @AfterAll
    public static void tearDownAll() {
        System.out.println("WalletQuiz tests completed.");
    }

    // Kode ini akan mengetest kesesuaian inisiasi objek untuk balace dan currency yang dilakukan dan nilai pada objek tersebut
    @Test
    @DisplayName("Test initial balance and currency")
    public void testInitialBalanceAndCurrency() {
        assertEquals(100.0, wallet1.getBalance());
        assertEquals("USD", wallet1.getCurrency());
    }


    // Kode ini mengetest apakah sudah fungsi untuk menyimpan uang atau deposit sudah berhasil atau belum
    @Test
    @DisplayName("Test depositing amount")
    public void testDeposit() {
        wallet1.depositAmount(50.0);
        assertEquals(150.0, wallet1.getBalance());
    }


    // kode ini berfungsi untuk mengecek bahwa fungsi withdraw telah berjalan dengan semestinya dan berefek pada nilai dari objek yang ada
    @Test
    @DisplayName("Test withdrawing sufficient funds")
    public void testWithdrawSufficientFunds() {
        assertTrue(wallet1.withdrawAmount(50.0));
        assertEquals(50.0, wallet1.getBalance());
    }

    // Kode ini mengecek bahwa jika amount uang yang ingin diambil lebih besar dari saldo yang terdapat pada wallet maka transaksi tidak akan dijalankan
    @Test
    @DisplayName("Test withdrawing insufficient funds")
    public void testWithdrawInsufficientFunds() {
        assertFalse(wallet1.withdrawAmount(150.0));
        assertEquals(100.0, wallet1.getBalance());
    }

    // Kode ini mengecek bahwa transfer nilai wallet ke wallet lain berhasil apabila nilai yang akan ditransfer dan currency antar wallet memiliki nilai yang sesuai, maka transaksi akan dijalankan 
    @Test
    @DisplayName("Test transferring funds between wallets")
    public void testTransferFunds() {
        wallet1.transferFunds(wallet2, 50.0);
        assertEquals(50.0, wallet1.getBalance());
        assertEquals(100.0, wallet2.getBalance());
    }

}
