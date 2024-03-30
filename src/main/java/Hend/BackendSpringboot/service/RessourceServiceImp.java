package Hend.BackendSpringboot.service;

import Hend.BackendSpringboot.entity.Ressource;
import Hend.BackendSpringboot.entity.etatRessource;
import Hend.BackendSpringboot.repository.RessourceRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class RessourceServiceImp implements IRessourceService {
    @Autowired
    RessourceRepository ressourceRepository;

    @Override
    public List<Ressource> retrieveAllRessources() {
        List<Ressource> allRessources = ressourceRepository.findAll();
        List<Ressource> validRessource = new ArrayList<>();
        //return ressourceRepository.findAll();
        for (Ressource re: allRessources) {
            if((re.getTotalQuantite()!=0) && (re.getEtatRessource()!= etatRessource.HORS_SERVICE ) && (re.getEtatRessource()!= etatRessource.NON_DISPONIBLE)
            && (!re.isArchive())

            ){
                validRessource.add(re);
            }
        }
        return validRessource;
    }

    @Override
    public List<Ressource> retrieveAllRessourcesback() {
        return ressourceRepository.findAll();
    }

    @Override
    public Ressource retrieveRessource(Long ressourceId) {
        return ressourceRepository.findById(ressourceId).get();
    }

    @Override
    public Ressource addRessource(Ressource r) {

        List<Ressource> allRessources= ressourceRepository.findAll();
        for (Ressource re : allRessources) {
            if (re.getNomRessource()==r.getNomRessource())
            {
                System.out.println("nom existant");
                throw new RuntimeException("nom existant") ;
            }


        }
        if (r.getTotalQuantite()==0){
            throw new RuntimeException("quantite ne doit pas etre negative") ;
        }
        r.setArchive(false);
      return  ressourceRepository.save(r);
    }

    @Override
    public Ressource archiveRessource(Long ressourceId) {
       Ressource r = ressourceRepository.findById(ressourceId).get();
        if (r.isArchive()) {
            r.setArchive(true);
        }else
        {
            r.setArchive(false);
        }
        return r;
    }

    @Override
    public Ressource modifyRessource(Ressource r) {
        return ressourceRepository.save(r);
    }
}
