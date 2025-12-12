package patient.gestion.patientservice.service;

import patient.gestion.patientservice.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface IServicePatient {
    Patient addPatient(Patient patient);

    List<Patient> allPatients();
    
    Optional<Patient> getPatientById(int id);
}
