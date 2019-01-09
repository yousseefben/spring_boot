package com.jee.project.Controller;

import com.jee.project.DAO.BudgetRepository;
import com.jee.project.DAO.RubriqueRepository;
import com.jee.project.Data.Budget;
import com.jee.project.Data.Rubrique;
import com.jee.project.Exception.RubriqueNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders="*")
@RestController
public class RubriqueController {

    @Autowired
    private  RubriqueRepository rubriqueRepository;

    @Autowired
    private BudgetRepository budgetRepository;

    @GetMapping("/rubriques")
    List<Rubrique> all() {
        return rubriqueRepository.findAll();
    }

    @PostMapping("/rubriques")
    Rubrique newRubrique(@RequestBody Rubrique newRubrique) {


        Rubrique r = rubriqueRepository.save(newRubrique);



        budgetRepository.findById((long) 143)
                .map(b -> {
                    b.setMontant(r.getMontant() + b.getMontant());
                    return budgetRepository.save(b);
                });

//        if(r.getMontant() != 0) {
//            Long i = r.getTypeBudget().getBudget().getId();
//            Optional<Budget> bud = budgetRepository.findById((long) 143);
//
//            bud.get().setMontant(r.getMontant());

        return r;

    }

    // Single item

    @GetMapping("/rubriques/{id}")
    Rubrique one(@PathVariable Long id) {

        return rubriqueRepository.findById(id)
                .orElseThrow(() -> new RubriqueNotFoundException(id));
    }

    @PutMapping("/rubriques/{id}")
    Rubrique replaceRubrique(@RequestBody Rubrique newRubrique, @PathVariable Long id) {

        return rubriqueRepository.findById(id)
                .map(rubrique -> {
                    rubrique.setNom(newRubrique.getNom());
                    rubrique.setCode(newRubrique.getCode());
                    rubrique.setTypeBudget(newRubrique.getTypeBudget());
                    return rubriqueRepository.save(rubrique);
                })
                .orElseGet(() -> {
                    newRubrique.setId(id);
                    return rubriqueRepository.save(newRubrique );
                });
    }

    @DeleteMapping("/rubriques/{id}")
    void deleteRubrique(@PathVariable Long id) {
        rubriqueRepository.deleteById(id);
    }
}
