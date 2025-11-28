package medecin.medecinservice.service;

import medecin.medecinservice.entities.Medecin;

import java.util.List;

public interface IServiceMedecin {
    Medecin addMedecin(Medecin medecin);

    List<Medecin> allMedecins();
}
