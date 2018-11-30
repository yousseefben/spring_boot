package com.jee.project.Data;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Type {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    @OneToOne()
    @JoinColumn(name = "budget_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Budget budget;

    @OneToMany(mappedBy = "type")
    private List<Rubrique> rubriques;

    public Type(String nom) {
        this.nom = nom;
    }

    public Type() {
    }
}

