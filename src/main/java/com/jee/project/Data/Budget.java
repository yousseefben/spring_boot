package com.jee.project.Data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
public class Budget {

    @Id
    @GeneratedValue
    private Long id;

    private double montant;

    public Budget(double montant) {
        this.montant = montant;
    }

    @OneToOne()
    @JoinColumn(name = "type_budget_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TypeBudget typeBudget;

    @JsonBackReference(value="budget")
    @ManyToOne()
    @JoinColumn(name = "compte", nullable = true)
    private Compte compte;


    public Budget() {
    }
}
