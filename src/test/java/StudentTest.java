import org.example.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentTest {
    @Test
    void TestMBKM(){
        Student student = new Student("Askar", 4, true);

        Assertions.assertEquals(false, student.isDoingMBKM());

    }
}
