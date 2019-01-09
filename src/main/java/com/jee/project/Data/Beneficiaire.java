package com.jee.project.Data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
public class Beneficiaire {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    public Beneficiaire(String nom) {
        this.nom = nom;
    }

//    @ManyToOne()
//    @JoinColumn(name = "beneficiaire", nullable = true)
//    private Beneficiaire beneficiaire;



    public Beneficiaire() {
    }
}
