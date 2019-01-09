package com.jee.project.Data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jee.project.DAO.CreditRepository;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity

public class OrdreDePaiement {

    @Id
    @GeneratedValue
    private Long id;

    private Long numero;

    private double montant;

    private String objet;
    private String observation;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;


    private Boolean enCours;

    private String modeReglement;



    @JsonBackReference(value="ordre")
    @ManyToOne()
    @JoinColumn(name = "credit_id", nullable = true)
    private CreditOuvert creditOuvert;

    @JsonBackReference(value="ordre_exercice")
    @ManyToOne()
    @JoinColumn(name = "exercice", nullable = true)
    private Exercice exercice;

//
//    @OneToOne()
//    @JoinColumn(name = "cheque_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Cheque cheque;
//
//    @OneToOne()
//    @JoinColumn(name = "virement_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Virement virement;

    public OrdreDePaiement() {
    }
}
