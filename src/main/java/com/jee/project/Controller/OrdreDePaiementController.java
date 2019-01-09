package com.jee.project.Controller;

import com.jee.project.DAO.CreditRepository;
import com.jee.project.DAO.OrdreDePaiementRepository;
import com.jee.project.Data.OrdreDePaiement;
import com.jee.project.Exception.OrdreDePaiementNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
public class OrdreDePaiementController {

    @Autowired
    private OrdreDePaiementRepository ordreDePaiementRepository;

    @Autowired
    private CreditRepository creditRepository;

    @GetMapping("/ordres")
    List<OrdreDePaiement> all() {
        return ordreDePaiementRepository.findAll();
    }

    @PostMapping("/ordres")
    OrdreDePaiement newOrdreDePaiement(@RequestBody OrdreDePaiement newOrdreDePaiement) {

        OrdreDePaiement ordre = ordreDePaiementRepository.save(newOrdreDePaiement);

        creditRepository.findById(newOrdreDePaiement.getCreditOuvert().getId())
                .map(b -> {
                    if (b.getReste() < newOrdreDePaiement.getMontant())
                        return new RuntimeException();
                    b.setReste(b.getReste() - newOrdreDePaiement.getMontant());
                    return creditRepository.save(b);
                });


        return ordre;
    }

    // Single item

    @GetMapping("/ordres/{id}")
    OrdreDePaiement one(@PathVariable Long id) {

        return ordreDePaiementRepository.findById(id)
                .orElseThrow(() -> new OrdreDePaiementNotFoundException(id));
    }

//    @PutMapping("/ordres/{id}")
//    OrdreDePaiement replaceOrdreDePaiement(@RequestBody OrdreDePaiement newOrdreDePaiement, @PathVariable Long id) {
//
//        return ordreDePaiementRepository.findById(id)
//                .map(ordreDePaiement -> {
//                    ordreDePaiement.setNumOrdreDePaiement(newOrdreDePaiement.getNumOrdreDePaiement());
//                    return ordreDePaiementRepository.save(ordreDePaiement);
//                })
//                .orElseGet(() -> {
//                    newOrdreDePaiement.setId(id);
//                    return ordreDePaiementRepository.save(newOrdreDePaiement );
//                });
//    }

    @DeleteMapping("/ordres/{id}")
    void deleteOrdreDePaiement(@PathVariable Long id) {
        ordreDePaiementRepository.deleteById(id);
    }
}
