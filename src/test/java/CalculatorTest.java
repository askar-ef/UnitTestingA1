import org.example.Calculator;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {
    private double result = 0;

    @BeforeAll
    void setupClass() {
        System.out.println("before all is called");
    }

    @BeforeEach
    void setupMethod() {
        System.out.println("before each is called");
    }

    @AfterEach
    void cleanMethod() {
        System.out.println("after each is called");
    }

    @AfterAll
    void cleanClass() {
        System.out.println("after all is called");
    }

    @Test
    @Order(1)
    void TestTambah(){

        int a = 10;
        int b = 5;
        Calculator calc = new Calculator(a, b);
        result = calc.tambah();
        Assertions.assertEquals(15, result);
    }

    @Test
    @Order(2)
    void TestKurang(){

        int b = 5;
        Calculator calc = new Calculator(result, b);
        result = calc.kurang();
        Assertions.assertEquals(10, result);
    }
}


// hasilnya malah -5 karena test method itu buat instance baru, jadi mau bagaimanapun meskipun udah bikin var di luar, test bakal tetep mulai dari 0



//    @Test
//    void TestTambah(){
//
//        Calculator calc = new Calculator();
//        calc.a = 10;
//        calc.b = 5;
//        Assertions.assertEquals(15, calc.tambah(), "ini fungsi tambah");
//        // massage tampil jika error
//    }
//
//    @Test
//    void TestKali(){
//        Calculator calc = new Calculator(5,7);
//        Assertions.assertAll(
//                () -> Assertions.assertEquals(5, calc.a),
//                () -> Assertions.assertEquals(7, calc.b),
//                () -> Assertions.assertNotNull(calc.kali())
//        );
//    }
//
//    @Test
//    void TestBagi(){
//
//        Calculator calc = new Calculator();
//        calc.a = 10;
//        calc.b = 4;
//        Assertions.assertEquals(2.5, calc.bagi());
//    }

//    @Test
//    void TestKurang(){
//        Calculator calc = new Calculator();
//        calc.a = 10;
//        calc.b = 5;
//        Assertions.assertEquals(5, calc.kurang());
//    }


