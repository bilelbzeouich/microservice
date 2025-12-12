package rdv.rdvservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rdv.rdvservice.clients.MedecinRestClient;
import rdv.rdvservice.clients.PatientRestClient;
import rdv.rdvservice.entities.Rdv;
import rdv.rdvservice.model.Medecin;
import rdv.rdvservice.model.Patient;
import rdv.rdvservice.service.IServiceRdv;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rdv/")
public class RdvRestController {

    IServiceRdv iServiceRdv;
    PatientRestClient patientRestClient;
    MedecinRestClient medecinRestClient;

    @PostMapping("add")
    public ResponseEntity<Object> add(@RequestBody Rdv rdv) {
        Rdv rdv1 = null;
        Optional<Patient> patient = patientRestClient.getPatientById(rdv.getPatientId());
        Optional<Medecin> medecin = medecinRestClient.getMedecinById(rdv.getMedecinId());
        if (patient.isPresent() && medecin.isPresent())
            rdv1 = iServiceRdv.addRdv(rdv);
        if (rdv1 != null)
            return new ResponseEntity<>(rdv, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Le Rdv ne peut pas être crée, merci de vérifier vos données",
                    HttpStatus.BAD_REQUEST);
    }

    @GetMapping("all")
    public List<Rdv> all() {
        List<Rdv> rdvs = iServiceRdv.allRdvs();
        for (Rdv rdv : rdvs) {
            Optional<Patient> patient = patientRestClient.getPatientById(rdv.getPatientId());
            Optional<Medecin> medecin = medecinRestClient.getMedecinById(rdv.getMedecinId());
            if (patient.isPresent()) {
                rdv.setPatient(patient.get());
            }
            if (medecin.isPresent()) {
                rdv.setMedecin(medecin.get());
            }
        }
        return rdvs;
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> find(@PathVariable int id) {
        Rdv rdv = iServiceRdv.getRdvById(id);
        if (rdv == null) {
            return new ResponseEntity<>("RDV avec l'ID " + id + " n'existe pas", HttpStatus.NOT_FOUND);
        }
        try {
            Optional<Patient> patient = patientRestClient.getPatientById(rdv.getPatientId());
            Optional<Medecin> medecin = medecinRestClient.getMedecinById(rdv.getMedecinId());
            if (patient.isPresent()) {
                rdv.setPatient(patient.get());
            }
            if (medecin.isPresent()) {
                rdv.setMedecin(medecin.get());
            }
            return new ResponseEntity<>(rdv, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la récupération des données: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
