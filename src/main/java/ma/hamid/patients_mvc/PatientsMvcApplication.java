package ma.hamid.patients_mvc;

import ma.hamid.patients_mvc.entities.Patient;
import ma.hamid.patients_mvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner (PatientRepository patientRepository){
        return  args -> {
            patientRepository.save(new Patient(null, "Hassan", new Date() ,false, 12));
            patientRepository.save(new Patient(null, "amine", new Date() ,true, 30));
            patientRepository.save(new Patient(null, "salma", new Date() ,false, 10));
            patientRepository.save(new Patient(null, "yassmine", new Date() ,true, 80));

            patientRepository.findAll().forEach(patient ->{
                System.out.println(patient.getNom());
            });
        };



    }
}
