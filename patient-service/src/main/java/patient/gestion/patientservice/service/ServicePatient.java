package patient.gestion.patientservice.service;

import patient.gestion.patientservice.entities.Patient;
import patient.gestion.patientservice.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicePatient implements IServicePatient {

    PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> allPatients() {
        return patientRepository.findAll();
    }
}
