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
public class CreditOuvert {

    @Id
    @GeneratedValue
    private Long id;

    private double montant;
    private double reste;

    public CreditOuvert(double montant) {
        this.montant = montant;
    }

    @JsonBackReference(value="credit_compte")
    @ManyToOne()
    @JoinColumn(name = "compte_id", nullable = false)
    private Compte compte;

    @JsonManagedReference(value="credit")
    @OneToOne()
    @JoinColumn(name = "rubrique_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Rubrique rubrique;

    @JsonManagedReference(value="ordre")
    @OneToMany(mappedBy = "creditOuvert")
    private List<OrdreDePaiement> ordreDePaiements;

    @JsonBackReference(value="credit_ouvert_exercice")
    @ManyToOne()
    @JoinColumn(name = "exercice", nullable = true)
    private Exercice exercice;

    public CreditOuvert() {
    }
}
