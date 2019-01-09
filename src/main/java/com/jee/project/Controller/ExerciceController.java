package com.jee.project.Controller;


import com.jee.project.DAO.ExerciceRepository;
import com.jee.project.Data.Exercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//import com.jee.project.Exception.ExerciceNotFoundException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ExerciceController {

    @Autowired
    private  ExerciceRepository exerciceRepository;

    @GetMapping("/exercices")
    List<Exercice> all() {
        return exerciceRepository.findAll();
    }

    @PostMapping("/exercices")
    Exercice newExercice(@RequestBody Exercice newExercice) {
        return exerciceRepository.save(newExercice);
    }

    // Single item

    @GetMapping("/exercices/{id}")
    Optional<Exercice> one(@PathVariable Long id) {

        return exerciceRepository.findById(id);
//                .orElseThrow(() -> new ExerciceNotFoundException(id));
    }

//    @PutMapping("/exercices/{id}")
//    Exercice replaceExercice(@RequestBody Exercice newExercice, @PathVariable Long id) {
//
//        return ExerciceRepository.findById(id)
//                .map(Exercice -> {
//                    Exercice.setMontant(newExercice.getMontant());
//                    return ExerciceRepository.save(Exercice);
//                })
//                .orElseGet(() -> {
//                    newExercice.setId(id);
//                    return ExerciceRepository.save(newExercice );
//                });
//    }

    @DeleteMapping("/exercices/{id}")
    void deleteExercice(@PathVariable Long id) {
        exerciceRepository.deleteById(id);
    }
}
