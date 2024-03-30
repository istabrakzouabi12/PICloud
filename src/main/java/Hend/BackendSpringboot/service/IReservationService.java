package Hend.BackendSpringboot.service;

import Hend.BackendSpringboot.entity.Reservation;
import Hend.BackendSpringboot.repository.RessourceRepository;

import java.util.List;

public interface IReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation retrieveReservation(Long reservationId);
    public Reservation addReservation(Reservation r);
    public void removeReservation(Long reservationId);
    public Reservation modifyReservation(Reservation r);

}
