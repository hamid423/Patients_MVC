package ma.hamid.patients_mvc;

import ma.hamid.patients_mvc.entities.Patient;
import ma.hamid.patients_mvc.repositories.PatientRepository;
import ma.hamid.patients_mvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }




    @Bean
    PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }
    //@Bean


    CommandLineRunner commandLineRunner (PatientRepository patientRepository){
        return  args -> {
            patientRepository.save(new Patient(null, "Hassan", new Date() ,false, 112));
            patientRepository.save(new Patient(null, "amine", new Date() ,true, 301));
            patientRepository.save(new Patient(null, "salma", new Date() ,false, 101));
            patientRepository.save(new Patient(null, "yassmine", new Date() ,true, 810));

            patientRepository.findAll().forEach(patient ->{
                System.out.println(patient.getNom());
            });
        };



    }
    //@Bean
    CommandLineRunner saveUser(SecurityService securityService){
        return  args -> {
            securityService.saveNewUser("mohamed", "1234", "1234");
            securityService.saveNewUser("ayman", "1234", "1234");
            securityService.saveNewUser("hamid", "1234", "1234");
            securityService.saveRole("USER", "");
            securityService.saveRole("ADMIN", "");

            securityService.addRoleToUser("mohamed", "USER");
            securityService.addRoleToUser("mohamed", "ADMIN");
            securityService.addRoleToUser("ayman", "USER");
            securityService.addRoleToUser("hamid", "USER");



        };
    }
}
