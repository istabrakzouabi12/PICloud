package Hend.BackendSpringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private Long idReservation;

    @Column(name = "reserved_quantity")
    private int reservedQuantity;

    @ManyToOne
    @JoinColumn(name = "id_equipe")
    private EquipeIntervention equipeIntervention;

    @ManyToOne
    @JoinColumn(name = "id_ressource")
    private Ressource ressource;


}
