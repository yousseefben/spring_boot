package com.jee.project.Controller;


import com.jee.project.DAO.EtablissementRepository;
import com.jee.project.Data.Etablissement;
import com.jee.project.Exception.EtablissementNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EtablissementController {

    @Autowired
    private  EtablissementRepository EtablissementRepository;

    @GetMapping("/etablissements")
    List<Etablissement> all() {
        return EtablissementRepository.findAll();
    }

    @PostMapping("/etablissements")
    Etablissement newEtablissement(@RequestBody Etablissement newEtablissement) {
        return EtablissementRepository.save(newEtablissement);
    }

    // Single item

    @GetMapping("/etablissements/{id}")
    Etablissement one(@PathVariable Long id) {

        return EtablissementRepository.findById(id)
                .orElseThrow(() -> new EtablissementNotFoundException(id));
    }
//
//    @PutMapping("/etablissements/{id}")
//    Etablissement replaceEtablissement(@RequestBody Etablissement newEtablissement, @PathVariable Long id) {
//
//        return EtablissementRepository.findById(id)
//                .map(Etablissement -> {
//                    Etablissement.setMontant(newEtablissement.getMontant());
//                    return EtablissementRepository.save(Etablissement);
//                })
//                .orElseGet(() -> {
//                    newEtablissement.setId(id);
//                    return EtablissementRepository.save(newEtablissement );
//                });
//    }

    @DeleteMapping("/etablissements/{id}")
    void deleteEtablissement(@PathVariable Long id) {
        EtablissementRepository.deleteById(id);
    }
}
