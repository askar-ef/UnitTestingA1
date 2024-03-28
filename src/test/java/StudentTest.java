import org.example.Student;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentTest {

    private List<Student> students;

    @BeforeAll
    void initClass() {
        students = new ArrayList<>();
        System.out.println("Initialized class");
    }

    @BeforeEach
    void initMethod() {
        Student student = new Student("Askar", 20);
        student.enrollCourse("Math");
        students.add(student);
        System.out.println("Initialized method");
    }

    @Test
    void testDataCreation() {
        assertNotNull(students);
        assertFalse(students.isEmpty());
        assertEquals(1, students.size());
    }

    @Test
    void testStudentEnrollment() {
        Student student = students.get(0);
        List<String> enrolledCourses = student.getEnrolledCourses();
        assertEquals(1, enrolledCourses.size());
        assertTrue(enrolledCourses.contains("Math"));
    }

    @Test
    void testStudentGrade() {
        Student student = students.get(0);
        student.setGrade("Math", "A");
        assertEquals("A", student.getGrade("Math"));
    }

    @AfterEach
    void cleanMethod() {
        students.clear();
        System.out.println("Cleaned method");
    }

    @AfterAll
    void cleanClass() {
        students = null;
        System.out.println("Cleaned class");
    }
}
