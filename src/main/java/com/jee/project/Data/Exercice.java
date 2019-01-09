package com.jee.project.Data;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Exercice {

    @Id
    @GeneratedValue
    private Long id;

    private int annee;

    @JsonManagedReference(value="credit_ouvert_exercice")
    @OneToMany(mappedBy = "exercice")
    private List<CreditOuvert> creditOuverts;

    @JsonManagedReference(value="virement_exercice")
    @OneToMany(mappedBy = "exercice")
    private List<Virement> virements;

    @JsonManagedReference(value="cheque_exercice")
    @OneToMany(mappedBy = "exercice")
    private List<Cheque> cheque;

    @JsonManagedReference(value="rubrique_exercice")
    @OneToMany(mappedBy = "exercice")
    private List<Rubrique> rubrique;

    @JsonManagedReference(value="ordre_exercice")
    @OneToMany(mappedBy = "exercice")
    private List<OrdreDePaiement> ordreDePaiements;



    public Exercice(double montant) {
        this.annee = annee;
    }


    public Exercice() {
    }
}
