package rdv.rdvservice.service;

import rdv.rdvservice.entities.Rdv;
import rdv.rdvservice.repository.RdvRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceRdv implements IServiceRdv {

    RdvRepository rdvRepository;

    @Override
    public Rdv addRdv(Rdv rdv) {
        Rdv rdv1 = rdvRepository.findByPatientIdAndDateRdv(rdv.getPatientId(), rdv.getDateRdv());
        Rdv rdv2 = rdvRepository.findByMedecinIdAndDateRdv(rdv.getMedecinId(), rdv.getDateRdv());
        if (rdv1 == null && rdv2 == null)
            return rdvRepository.save(rdv);
        else
            return null;
    }

    @Override
    public List<Rdv> allRdvs() {
        return rdvRepository.findAll();
    }

    @Override
    public Rdv getRdvById(int id) {
        return rdvRepository.findById(id).orElse(null);
    }
}
