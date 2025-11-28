package patient.gestion.patientservice.controller;

import patient.gestion.patientservice.entities.Patient;
import patient.gestion.patientservice.service.IServicePatient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/patient/")
public class PatientRestController {

    IServicePatient iServicePatient;

    @PostMapping("add")
    public Patient add(@RequestBody Patient patient) {
        return iServicePatient.addPatient(patient);
    }

    @GetMapping("all")
    public List<Patient> all() {
        return iServicePatient.allPatients();
    }
}
