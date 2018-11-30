package com.jee.project;


import com.jee.project.DAO.BudgetRepository;
import com.jee.project.DAO.CompteRepository;
import com.jee.project.DAO.RubriqueRepository;
import com.jee.project.DAO.TypeRepository;
import com.jee.project.Data.Budget;
import com.jee.project.Data.Compte;
import com.jee.project.Data.Rubrique;
import com.jee.project.Data.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {


    @Autowired
    CompteRepository compteRepository;

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    RubriqueRepository rubriqueRepository;

    public static void main(String[] args) {

        SpringApplication.run(ProjectApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

//        Compte c = new Compte(12);
//        Budget b = new Budget(12);
//        budgetRepository.save(b);
//        c.setBudget(b);
//        compteRepository.save(c);

//
        Type t = typeRepository.getOne((long) 9);
//
//        Rubrique r = new Rubrique((long) 123, "test");
//
//        r.setType(t);
//
//        Rubrique r2 = new Rubrique((long) 123, "test22");
//
//        r2.setType(t);
//
//        rubriqueRepository.save(r);
//        rubriqueRepository.save(r2);



//        for (Compte compte : compteRepository.findAll()) {
//            System.out.println(compte.toString());
//            if (compte.getBudget() != null) {
//                System.out.println(compte.getBudget().toString());
//            }
//
//        }


        for (Rubrique rub : t.getRubriques()) {
            System.out.println(rub.getNom());
        }
    }
}
