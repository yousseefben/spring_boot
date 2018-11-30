package com.jee.project.Data;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@Entity
public class Compte {
    @Id
    @GeneratedValue
    private Long id;

    private int numCompte;

    @OneToOne()
    @JoinColumn(name = "budget_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Budget budget;

    public Compte(int numCompte) {
        this.numCompte = numCompte;
    }

    public Compte() {
    }

}
