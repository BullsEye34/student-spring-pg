package ml.vamshiprasad.learnSpring.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args->{
            Student p_vamshi_prasad = new Student(
                    "P Vamshi Prasad",
                    LocalDate.of(1999, JULY, 11),
                    22,
                    "vamvijkum@gmail.com"
            );
            Student cutie = new Student(
                    "Cutie",
                    LocalDate.of(2002, JULY, 10),
                    22,
                    "cutie@gmail.com"
            );

            studentRepository.saveAll(
                    List.of(
                            p_vamshi_prasad,
                            cutie
                    )
            );
        };
    }
}
