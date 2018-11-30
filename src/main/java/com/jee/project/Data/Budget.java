package com.jee.project.Data;

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
    @JoinColumn(name = "type_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Type type;

    public Budget() {
    }
}
