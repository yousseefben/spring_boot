package com.jee.project.Data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class TypeBudget {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    @OneToOne()
    @JoinColumn(name = "budget_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Budget budget;

    @JsonManagedReference(value="rubrique")
    @OneToMany(mappedBy = "typeBudget")
    private List<Rubrique> rubriques;

    public TypeBudget(String nom) {
        this.nom = nom;
    }

    public TypeBudget() {
    }
}

