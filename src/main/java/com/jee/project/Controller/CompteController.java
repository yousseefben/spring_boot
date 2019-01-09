package com.jee.project.Controller;

import com.jee.project.DAO.BudgetRepository;
import com.jee.project.DAO.CompteRepository;
import com.jee.project.DAO.TypeBudgetRepository;
import com.jee.project.Data.Budget;
import com.jee.project.Data.Compte;
import com.jee.project.Data.TypeBudget;
import com.jee.project.Exception.CompteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders="*")
@RestController
public class CompteController {

    @Autowired
    private  CompteRepository compteRepository;
    @Autowired
    private BudgetRepository budgetRepository;
    
    @Autowired
    private TypeBudgetRepository typeBudgetRepository;

    @GetMapping("/comptes")
    List<Compte> all() {
        return compteRepository.findAll();
    }

    @PostMapping("/comptes")
    Compte newCompte(@RequestBody Compte newCompte) {
        TypeBudget invest, fonc;
        Budget fonctionnement, investissement;

        if (typeBudgetRepository.findAll().size() == 0) {
            invest  = typeBudgetRepository.save(new TypeBudget("Investissement"));
            fonc = typeBudgetRepository.save(new TypeBudget("Fonctionnement"));
        } else {
            invest = typeBudgetRepository.findAll().get(0);
            fonc = typeBudgetRepository.findAll().get(1);
        }

        Compte c = compteRepository.save(newCompte);

        Budget b1 =  new Budget(0);
        b1.setTypeBudget(invest);
        b1.setCompte(c);
        investissement = budgetRepository.save(b1);
        
        Budget b2 =  new Budget(0);
        b2.setTypeBudget(fonc);
        b2.setCompte(c);
        fonctionnement = budgetRepository.save(b2);

        return c;
    }

    // Single item

    @GetMapping("/comptes/{id}")
    Compte one(@PathVariable Long id) {

        return compteRepository.findById(id)
                .orElseThrow(() -> new CompteNotFoundException(id));
    }

    @PutMapping("/comptes/{id}")
    Compte replaceCompte(@RequestBody Compte newCompte, @PathVariable Long id) {

        return compteRepository.findById(id)
                .map(compte -> {
                    compte.setNumCompte(newCompte.getNumCompte());
                    return compteRepository.save(compte);
                })
                .orElseGet(() -> {
                    newCompte.setId(id);
                    return compteRepository.save(newCompte );
                });
    }

    @DeleteMapping("/comptes/{id}")
    void deleteCompte(@PathVariable Long id) {
        compteRepository.deleteById(id);
    }
}
