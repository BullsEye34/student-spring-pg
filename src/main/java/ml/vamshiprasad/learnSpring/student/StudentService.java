package ml.vamshiprasad.learnSpring.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    public List<Student> getStudents(){
        return List.of(
                new Student(UUID.randomUUID(), "P Vamshi Prasad", LocalDate.of(1999, Month.JULY, 11), 22, "vamvijkum@gmail.com")
        );
    }
}
