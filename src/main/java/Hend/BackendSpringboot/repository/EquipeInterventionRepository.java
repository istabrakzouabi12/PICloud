package Hend.BackendSpringboot.repository;

import Hend.BackendSpringboot.entity.EquipeIntervention;
import Hend.BackendSpringboot.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeInterventionRepository extends JpaRepository<EquipeIntervention,Long> {
}
