package Hend.BackendSpringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipe_intervention")
public class EquipeIntervention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipe")
    private Long idEquipe;

    @Column(name = "nom_equipe")
    private String nomEquipe;

    @Column(name = "description")
    private String description;

    @Column(name = "disponibilite")
    private boolean disponibilite;

    @OneToMany(mappedBy = "equipeIntervention", cascade = CascadeType.ALL)
    private List<Membre> membres;

  // @JsonIgnore
    @OneToMany(mappedBy = "equipeIntervention", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @ManyToMany(mappedBy = "equipesIntervention")
    private List<Incident> incidents;



    public Long getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public List<Membre> getMembres() {
        return membres;
    }

    public void setMembres(List<Membre> membres) {
        this.membres = membres;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }
}
