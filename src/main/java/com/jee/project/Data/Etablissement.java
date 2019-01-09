package com.jee.project.Data;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Etablissement {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    public Etablissement(String nom) {
        this.nom = nom;
    }

    @JsonManagedReference(value="compte")
    @OneToMany(mappedBy = "etablissement")
    private List<Compte> comptes;

    public Etablissement() {
    }
}
