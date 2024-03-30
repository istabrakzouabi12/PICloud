package Hend.BackendSpringboot.service;


import Hend.BackendSpringboot.entity.Reservation;
import Hend.BackendSpringboot.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ReservationServiceImp implements IReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation retrieveReservation(Long reservationId) {
        return reservationRepository.findById(reservationId).get();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
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
