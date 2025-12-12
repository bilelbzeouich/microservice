package medecin.medecinservice.service;

import medecin.medecinservice.entities.Medecin;
import medecin.medecinservice.repository.MedecinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServiceMedecin implements IServiceMedecin {

    MedecinRepository medecinRepository;

    @Override
    public Medecin addMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public List<Medecin> allMedecins() {
        return medecinRepository.findAll();
    }

    @Override
    public Optional<Medecin> getMedecinById(int id) {
        return medecinRepository.findById(id);
    }
}
