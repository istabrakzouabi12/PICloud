package Hend.BackendSpringboot.service;


import Hend.BackendSpringboot.entity.EquipeIntervention;
import Hend.BackendSpringboot.entity.Reservation;
import Hend.BackendSpringboot.entity.Ressource;
import Hend.BackendSpringboot.repository.EquipeInterventionRepository;
import Hend.BackendSpringboot.repository.ReservationRepository;
import Hend.BackendSpringboot.repository.RessourceRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ReservationServiceImp implements IReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    EquipeInterventionRepository equipeInterventionRepository;
    @Autowired
    RessourceRepository ressourceRepository;
    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation retrieveReservation(Long reservationId) {
        return reservationRepository.findById(reservationId).get();
    }

    @Override
    public Reservation AffecterRessourceAEquipe(Reservation r, Long  idRessource, Long idEquipe) {
        List<Reservation> liste=new ArrayList<>();
        EquipeIntervention equipe = equipeInterventionRepository.findById(idEquipe).get();
        Ressource res = ressourceRepository.findById(idRessource).get();
        r.setEquipeIntervention(equipe);
        r.setDateReservation(LocalDate.now());
        r.setRessource(res);
        reservationRepository.save(r);
       /* liste.add(r);
        System.out.println("LISSSTEEEE"+liste);
        res.setReservations(liste);
        ressourceRepository.save(res);*/


        return r;
    }

    @Override
    public void removeReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);

    }

    @Override
    public Reservation modifyReservation(Reservation r) {
        return reservationRepository.save(r);
    }
}
