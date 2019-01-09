package com.jee.project.Controller;


import com.jee.project.DAO.BeneficiaireRepository;
import com.jee.project.Data.Beneficiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//import com.jee.project.Exception.BeneficiaireNotFoundException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BeneficiaireController {

    @Autowired
    private  BeneficiaireRepository BeneficiaireRepository;

    @GetMapping("/beneficiaires")
    List<Beneficiaire> all() {
        return BeneficiaireRepository.findAll();
    }

    @PostMapping("/beneficiaires")
    Beneficiaire newBeneficiaire(@RequestBody Beneficiaire newBeneficiaire) {
        return BeneficiaireRepository.save(newBeneficiaire);
    }

    // Single item

    @GetMapping("/beneficiaires/{id}")
    Optional<Beneficiaire> one(@PathVariable Long id) {

        return BeneficiaireRepository.findById(id);
//                .orElseThrow(() -> new BeneficiaireNotFoundException(id));
    }

//    @PutMapping("/beneficiaires/{id}")
//    Beneficiaire replaceBeneficiaire(@RequestBody Beneficiaire newBeneficiaire, @PathVariable Long id) {
//
//        return BeneficiaireRepository.findById(id)
//                .map(Beneficiaire -> {
//                    Beneficiaire.setMontant(newBeneficiaire.getMontant());
//                    return BeneficiaireRepository.save(Beneficiaire);
//                })
//                .orElseGet(() -> {
//                    newBeneficiaire.setId(id);
//                    return BeneficiaireRepository.save(newBeneficiaire );
//                });
//    }

    @DeleteMapping("/beneficiaires/{id}")
    void deleteBeneficiaire(@PathVariable Long id) {
        BeneficiaireRepository.deleteById(id);
    }
}
