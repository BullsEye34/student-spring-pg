package ml.vamshiprasad.learnSpring.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        else{
            studentRepository.save(student);
        }
    }
}

//                new Student(UUID.randomUUID(), "P Vamshi Prasad", LocalDate.of(1999, Month.JULY, 11), 22, "vamvijkum@gmail.com")
