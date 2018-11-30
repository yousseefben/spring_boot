package com.jee.project.Data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rubrique {
    @Id
    @GeneratedValue
    private Long id;

    private Long code;

    private String nom;

    @ManyToOne()
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    public Rubrique(Long code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public Rubrique() {
    }

}
