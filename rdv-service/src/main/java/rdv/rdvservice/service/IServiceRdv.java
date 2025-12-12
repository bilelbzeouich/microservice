package rdv.rdvservice.service;

import rdv.rdvservice.entities.Rdv;

import java.util.List;

public interface IServiceRdv {
    Rdv addRdv(Rdv rdv);
    List<Rdv> allRdvs();
    Rdv getRdvById(int id);
}

