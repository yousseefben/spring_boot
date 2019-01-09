package com.jee.project;


import com.jee.project.DAO.*;
import com.jee.project.Data.Role;
import com.jee.project.Data.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {


    @Autowired
    CompteRepository compteRepository;

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    TypeBudgetRepository typeBudgetRepository;

    @Autowired
    RubriqueRepository rubriqueRepository;

    @Autowired
    private RoleRepository roleRepository;

//        @Bean
//    public void init() {
//
//        //ROLES
//        roleRepository.save(new Role(RoleName.ROLE_ADMIN));
//        roleRepository.save(new Role(RoleName.ROLE_USER));
//    }
    public static void main(String[] args) {

        SpringApplication.run(ProjectApplication.class, args);

    }

    @Override
    public void run(String... args) {

//        Compte c = new Compte(12);
//        Budget b = new Budget(12);
//        budgetRepository.save(b);
//        c.setBudget(b);
//        compteRepository.save(c);

//
//        TypeBudget t = typeBudgetRepository.getOne((long) 9);
//
//        Rubrique r = new Rubrique((long) 123, "test");
//
//        r.setTypeBudget(t);
//
//        Rubrique r2 = new Rubrique((long) 123, "test22");
//
//        r2.setTypeBudget(t);
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


//        for (Rubrique rub : t.getRubriques()) {
//            System.out.println(rub.getNom());
//        }
    }
}
