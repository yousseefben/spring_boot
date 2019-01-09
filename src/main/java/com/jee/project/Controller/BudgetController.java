package com.jee.project.Controller;


import com.jee.project.DAO.BudgetRepository;
import com.jee.project.Data.Budget;
import com.jee.project.Exception.BudgetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BudgetController {

    @Autowired
    private  BudgetRepository BudgetRepository;

    @GetMapping("/budgets")
    List<Budget> all() {
        return BudgetRepository.findAll();
    }

    @PostMapping("/budgets")
    Budget newBudget(@RequestBody Budget newBudget) {
        return BudgetRepository.save(newBudget);
    }

    // Single item

    @GetMapping("/budgets/{id}")
    Budget one(@PathVariable Long id) {

        return BudgetRepository.findById(id)
                .orElseThrow(() -> new BudgetNotFoundException(id));
    }

    @PutMapping("/budgets/{id}")
    Budget replaceBudget(@RequestBody Budget newBudget, @PathVariable Long id) {

        return BudgetRepository.findById(id)
                .map(Budget -> {
                    Budget.setMontant(newBudget.getMontant());
                    return BudgetRepository.save(Budget);
                })
                .orElseGet(() -> {
                    newBudget.setId(id);
                    return BudgetRepository.save(newBudget );
                });
    }

    @DeleteMapping("/budgets/{id}")
    void deleteBudget(@PathVariable Long id) {
        BudgetRepository.deleteById(id);
    }
}
