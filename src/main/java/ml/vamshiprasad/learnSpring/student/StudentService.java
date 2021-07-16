package ml.vamshiprasad.learnSpring.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists) throw new IllegalStateException(("Student with Student ID : "+id+" Does not exist!"));
        else studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalStateException("Student with ID: "+id+" Does not exist!"));
        if(name!=null&&name.length()>0&&!Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email!=null&&email.length()>0&&!Objects.equals(student.getEmail(), email)){
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
            if(studentByEmail.isPresent()){
                throw new IllegalStateException("Email Already Taken!");
            }
            else student.setEmail(email);
        }
    }
}

//                new Student(UUID.randomUUID(), "P Vamshi Prasad", LocalDate.of(1999, Month.JULY, 11), 22, "vamvijkum@gmail.com")
