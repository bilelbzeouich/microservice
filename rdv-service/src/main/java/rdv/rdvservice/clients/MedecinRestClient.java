package rdv.rdvservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rdv.rdvservice.model.Medecin;

import java.util.Optional;

@FeignClient(name = "medecin-service")
public interface MedecinRestClient {
    @GetMapping("/api/medecin/{id}")
    Optional<Medecin> getMedecinById(@PathVariable int id);
}

