package com.augeregalloydelisle.back.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Sondage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, unique = true)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String place;

    @Column
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Proposition.class, orphanRemoval = true)
    @CollectionTable
    private List<Proposition> propositions = new ArrayList<>();

    @ManyToOne(targetEntity = User.class)
    private User createur;

    public Sondage(String title, String place, List<Proposition> propositions, User createur) {
        this.title = title;
        this.place = place;
        this.propositions = propositions;
        this.createur = createur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<Proposition> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<Proposition> propositions) {
        this.propositions = propositions;
    }

    public User getCreateur() {
        return createur;
    }

    public void setCreateur(User createur) {
        this.createur = createur;
    }

}
