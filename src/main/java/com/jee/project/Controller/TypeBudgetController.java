package com.jee.project.Controller;

import com.jee.project.DAO.TypeBudgetRepository;
import com.jee.project.Data.TypeBudget;
import com.jee.project.Exception.TypeBudgetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders="*")
@RestController
public class TypeBudgetController {
    @Autowired
    private TypeBudgetRepository typeBudgetRepository;

    @GetMapping("/typeBudgets")
    List<TypeBudget> all() {
        return typeBudgetRepository.findAll();
    }

    @PostMapping("/typeBudgets")
    TypeBudget newTypeBudget(@RequestBody TypeBudget newTypeBudget) {

        return typeBudgetRepository.save(newTypeBudget);
    }

    // Single item

    @GetMapping("/typeBudgets/{id}")
    TypeBudget one(@PathVariable Long id) {

        return typeBudgetRepository.findById(id)
                .orElseThrow(() -> new TypeBudgetNotFoundException(id));
    }

}
