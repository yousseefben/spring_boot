package com.jee.project.Controller;


import com.jee.project.DAO.VirementRepository;
import com.jee.project.Data.Virement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//import com.jee.project.Exception.VirementNotFoundException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class VirementController {

    @Autowired
    private  VirementRepository VirementRepository;

    @GetMapping("/virements")
    List<Virement> all() {
        return VirementRepository.findAll();
    }

    @PostMapping("/virements")
    Virement newVirement(@RequestBody Virement newVirement) {
        return VirementRepository.save(newVirement);
    }

    // Single item

    @GetMapping("/virements/{id}")
    Optional<Virement> one(@PathVariable Long id) {

        return VirementRepository.findById(id);
//                .orElseThrow(() -> new VirementNotFoundException(id));
    }

    @PutMapping("/virements/{id}")
    Virement replaceVirement(@RequestBody Virement newVirement, @PathVariable Long id) {

        return VirementRepository.findById(id)
                .map(Virement -> {
                    Virement.setMontant(newVirement.getMontant());
                    return VirementRepository.save(Virement);
                })
                .orElseGet(() -> {
                    newVirement.setId(id);
                    return VirementRepository.save(newVirement );
                });
    }

    @DeleteMapping("/virements/{id}")
    void deleteVirement(@PathVariable Long id) {
        VirementRepository.deleteById(id);
    }
}
