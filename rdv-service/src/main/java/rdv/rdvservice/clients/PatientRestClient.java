package rdv.rdvservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rdv.rdvservice.model.Patient;

import java.util.Optional;

@FeignClient(name = "patient-service")
public interface PatientRestClient {
    @GetMapping("/api/patient/{id}")
    Optional<Patient> getPatientById(@PathVariable int id);
}

