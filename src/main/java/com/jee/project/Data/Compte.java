package com.jee.project.Data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Compte {
    @Id
    @GeneratedValue
    private Long id;

    private int numCompte;

    @JsonManagedReference(value="budget")
    @OneToMany(mappedBy = "compte")
    private List<Budget> budgets;

    @JsonBackReference(value="compte")
    @ManyToOne()
    @JoinColumn(name = "etablissement", nullable = true)
    private Etablissement etablissement;

    @JsonManagedReference(value="credit_compte")
    @OneToMany(mappedBy = "compte")
    private List<CreditOuvert> credit;

//    public Compte(int numCompte) {
//        this.numCompte = numCompte;
//    }
//
//    public Compte() {
//    }

}
