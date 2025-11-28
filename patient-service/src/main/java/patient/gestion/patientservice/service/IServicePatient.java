package patient.gestion.patientservice.service;

import patient.gestion.patientservice.entities.Patient;

import java.util.List;

public interface IServicePatient {
    Patient addPatient(Patient patient);

    List<Patient> allPatients();
}
