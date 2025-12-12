package medecin.medecinservice.service;

import medecin.medecinservice.entities.Medecin;

import java.util.List;
import java.util.Optional;

public interface IServiceMedecin {
    Medecin addMedecin(Medecin medecin);

    List<Medecin> allMedecins();
    
    Optional<Medecin> getMedecinById(int id);
}
