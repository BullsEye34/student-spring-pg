package ml.vamshiprasad.learnSpring.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
}

//                new Student(UUID.randomUUID(), "P Vamshi Prasad", LocalDate.of(1999, Month.JULY, 11), 22, "vamvijkum@gmail.com")
