package com.jee.project.Data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Cheque {

    @Id
    @GeneratedValue
    private Long id;

    private Long numero;

    private double montant;
    private Date dateEmmissiont;
    private String observation;


    public Cheque(Long numero, double montant, Date dateEmmissiont, String observation) {
        this.numero = numero;
        this.montant = montant;
        this.dateEmmissiont = dateEmmissiont;
        this.observation = observation;
    }
//
    @OneToOne()
    @JoinColumn(name = "ordre_de_paiement_id", nullable = true)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private OrdreDePaiement ordreDePaiement;

    @JsonBackReference(value = "compte")
    @ManyToOne()
    @JoinColumn(name = "compte_id", nullable = true)
    private Compte compte;

    @JsonBackReference(value="cheque_exercice")
    @ManyToOne()
    @JoinColumn(name = "exercice_id", nullable = true)
    private Exercice exercice;

    @JsonBackReference(value = "type_budget")
    @ManyToOne()
    @JoinColumn(name = "type_budget_id", nullable = true)
    private TypeBudget typeBudget;

    @ManyToOne()
    @JoinColumn(name = "beneficiaire", nullable = true)
    private Beneficiaire beneficiaire;

    public Cheque() {
    }
}
