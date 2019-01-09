package com.jee.project.Controller;

import com.jee.project.DAO.BudgetRepository;
import com.jee.project.DAO.CompteRepository;
import com.jee.project.DAO.CreditRepository;
import com.jee.project.DAO.RubriqueRepository;
import com.jee.project.Data.Budget;
import com.jee.project.Data.Compte;
import com.jee.project.Data.CreditOuvert;
import com.jee.project.Data.Rubrique;
import com.jee.project.Exception.CreditOuvertNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
public class CreditController {

    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private RubriqueRepository rubriqueRepository;

    @Autowired
    private BudgetRepository budgetRepository;

    @GetMapping("/credits")
    List<CreditOuvert> all() {
        return creditRepository.findAll();
    }

    @PostMapping("/credits")
    CreditOuvert newCreditOuvert(@RequestBody CreditOuvert newCreditOuvert) {

        newCreditOuvert.setReste(newCreditOuvert.getMontant());

        Optional<Compte> c = compteRepository.findById(newCreditOuvert.getCompte().getId());
        Optional<Rubrique> r = rubriqueRepository.findById(newCreditOuvert.getRubrique().getId());

        Budget budget = null;

        for (Budget b : c.get().getBudgets() ) {
            if (b.getTypeBudget().getId() == r.get().getTypeBudget().getId()) {
                if (b.getMontant() < newCreditOuvert.getMontant()) {
                    throw new RuntimeException();
                }

                budget = b;

            }
        }

        r.get().setCredit(true);

        System.out.println(budget.getId());

        CreditOuvert credit = creditRepository.save(newCreditOuvert);
        budgetRepository.findById(budget.getId())
                .map( b -> {
                  b.setMontant(b.getMontant() - credit.getMontant());
                  return budgetRepository.save(b);
                });

        return credit;
    }
    // Single item

    @GetMapping("/credits/{id}")
    CreditOuvert one(@PathVariable Long id) {

        return creditRepository.findById(id)
                .orElseThrow(() -> new CreditOuvertNotFoundException(id));
    }

//    @PutMapping("/credits/{id}")
//    CreditOuvert replaceCreditOuvert(@RequestBody CreditOuvert newCreditOuvert, @PathVariable Long id) {
//
//        return creditRepository.findById(id)
//                .map(credit -> {
//                    credit.setNumCreditOuvert(newCreditOuvert.getNumCreditOuvert());
//                    return creditRepository.save(credit);
//                })
//                .orElseGet(() -> {
//                    newCreditOuvert.setId(id);
//                    return creditRepository.save(newCreditOuvert );
//                });
//    }

    @DeleteMapping("/credits/{id}")
    void deleteCreditOuvert(@PathVariable Long id) {
        creditRepository.deleteById(id);
    }
}
