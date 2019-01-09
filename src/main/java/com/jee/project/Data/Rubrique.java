package com.jee.project.Data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity

public class Rubrique {
    @Id
    @GeneratedValue
    private Long id;

    private Long code;

    private String nom;

    //depense ou recette
    private String type;

//    @Column(name="credit_ouvert",columnDefinition = "boolean default false")]
    //appartient a un credit ou non;
    //default false
    private boolean credit;

    private double montant;

    @JsonBackReference(value="rubrique")
    @ManyToOne()
    @JoinColumn(name = "type_budget_id", nullable = false)
    private TypeBudget typeBudget;

    @JsonBackReference(value="credit")
    @OneToOne(mappedBy="rubrique")
    private CreditOuvert creditOuvert;

    @JsonBackReference(value="rubrique_exercice")
    @ManyToOne()
    @JoinColumn(name = "exercice", nullable = true)
    private Exercice exercice;

    public Rubrique(Long code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public Rubrique() {
    }

}
