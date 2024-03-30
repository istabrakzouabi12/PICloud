package Hend.BackendSpringboot.controller;

import Hend.BackendSpringboot.entity.Incident;
import Hend.BackendSpringboot.entity.Ressource;
import Hend.BackendSpringboot.service.IRessourceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/ressource")
public class RessourceRestController {
    IRessourceService ressourceService;
    // http://localhost:8089/csers/ressource/add-ressource
    @PostMapping("/add-ressource")
    public Ressource addRessource(@RequestBody Ressource r) {
        Ressource ressource = ressourceService.addRessource(r);
        return ressource;
    }
    // http://localhost:8089/csers/ressource/retrieve-all-ressources
    @GetMapping("/retrieve-all-ressources")
    public List<Ressource> getRessources(){

        List<Ressource> listRessources = ressourceService.retrieveAllRessources();
        return listRessources;
    }
    // http://localhost:8089/csers/ressource/retrieve-all-ressources-back
    @GetMapping("/retrieve-all-ressources-back")
    public List<Ressource> getRessourcesBack(){

        List<Ressource> listRessources = ressourceService.retrieveAllRessourcesback();
        return listRessources;
    }


    // http://localhost:8089/csers/ressource/archiver-ressource/8
    @GetMapping("/archive-ressource/{ressource-id}")
    public Ressource archiveRessource(@PathVariable("ressource-id") Long ressourceId) {
        Ressource ressource = ressourceService.archiveRessource(ressourceId);
        return ressource;
    }
    // http://localhost:8089/csers/ressource/retrieve-ressource/8
    @GetMapping("/retrieve-ressource/{ressource-id}")
    public Ressource retrieveRessource(@PathVariable("ressource-id") Long ressourceId) {
        Ressource ressource = ressourceService.retrieveRessource(ressourceId);
        return ressource;
    }

    // http://localhost:8089/csers/ressource/modify-ressource
    @PutMapping("/modify-ressource")
    public Ressource modifyRessource(@RequestBody Ressource ressource) {
        return ressourceService.modifyRessource(ressource);

    }

}

