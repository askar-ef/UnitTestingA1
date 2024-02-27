import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void TestTambah(){

        Calculator calc = new Calculator();
        calc.a = 10;
        calc.b = 5;
        Assertions.assertEquals(15, calc.tambah(), "ini fungsi tambah");
        // massage tampil jika error
    }

    @Test
    void TestKali(){
        Calculator calc = new Calculator(5,7);
        Assertions.assertAll(
                () -> Assertions.assertEquals(5, calc.a),
                () -> Assertions.assertEquals(7, calc.b),
                () -> Assertions.assertNotNull(calc.kali())
        );
    }

    @Test
    void TestBagi(){

        Calculator calc = new Calculator();
        calc.a = 10;
        calc.b = 4;
        Assertions.assertEquals(2.5, calc.bagi());
    }

    @Test
    void TestKurang(){
        Calculator calc = new Calculator();
        calc.a = 10;
        calc.b = 5;
        Assertions.assertEquals(5, calc.kurang());
    }
}
