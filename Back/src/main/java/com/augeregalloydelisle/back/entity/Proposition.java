package com.augeregalloydelisle.back.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Proposition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, unique = true)
    private Integer id;

    @Column
    private LocalDate date;

    @Column
    private LocalTime start;

    @Column
    private LocalTime finish;

    @Column(nullable = false)
    @ManyToMany(targetEntity = User.class)
    @CollectionTable
    private Set<User> yes = new HashSet<>();

    @Column(nullable = false)
    @ManyToMany(targetEntity = User.class)
    @CollectionTable
    private Set<User> no = new HashSet<>();

    public Proposition(LocalDate date, LocalTime start, LocalTime finish) {
        this.date = date;
        this.start = start;
        this.finish = finish;
    }

    public Proposition(String date, String start, String finish) {
        String dateArr[] = date.split("-");
        String startArr[] = start.split(":");
        String finishArr[] = finish.split(":");
        this.date = LocalDate.of(Integer.parseInt(dateArr[0]), Integer.parseInt(dateArr[1]),
                Integer.parseInt(dateArr[2]));
        this.start = LocalTime.of(Integer.parseInt(startArr[0]), Integer.parseInt(startArr[1]));
        this.finish = LocalTime.of(Integer.parseInt(finishArr[0]), Integer.parseInt(finishArr[1]));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getFinish() {
        return finish;
    }

    public void setFinish(LocalTime finish) {
        this.finish = finish;
    }

    public Set<User> getYes() {
        return yes;
    }

    public void setYes(Set<User> yes) {
        this.yes = yes;
    }

    public Set<User> getNo() {
        return no;
    }

    public void setNo(Set<User> no) {
        this.no = no;
    }

}
