package ma.hamid.patients_mvc.web;

import lombok.AllArgsConstructor;
import ma.hamid.patients_mvc.entities.Patient;
import ma.hamid.patients_mvc.repositories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String patients(Model model){
        List<Patient> patients=patientRepository.findAll();
        model.addAttribute("listPatients", patients);
        return "patients";
    }
}
