package com.jee.project.Controller;


import com.jee.project.DAO.ChequeRepository;
import com.jee.project.Data.Cheque;
//import com.jee.project.Exception.ChequeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ChequeController {

    @Autowired
    private  ChequeRepository ChequeRepository;

    @GetMapping("/cheques")
    List<Cheque> all() {
        return ChequeRepository.findAll();
    }

    @PostMapping("/cheques")
    Cheque newCheque(@RequestBody Cheque newCheque) {
        return ChequeRepository.save(newCheque);
    }

    // Single item

    @GetMapping("/cheques/{id}")
    Optional<Cheque> one(@PathVariable Long id) {

        return ChequeRepository.findById(id);
//                .orElseThrow(() -> new ChequeNotFoundException(id));
    }

    @PutMapping("/cheques/{id}")
    Cheque replaceCheque(@RequestBody Cheque newCheque, @PathVariable Long id) {

        return ChequeRepository.findById(id)
                .map(Cheque -> {
                    Cheque.setMontant(newCheque.getMontant());
                    return ChequeRepository.save(Cheque);
                })
                .orElseGet(() -> {
                    newCheque.setId(id);
                    return ChequeRepository.save(newCheque );
                });
    }

    @DeleteMapping("/cheques/{id}")
    void deleteCheque(@PathVariable Long id) {
        ChequeRepository.deleteById(id);
    }
}
