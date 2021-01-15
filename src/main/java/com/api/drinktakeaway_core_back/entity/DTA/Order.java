package com.api.drinktakeaway_core_back.entity.DTA;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_all", schema = "drink_take_away")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numerosity")
    private int numerosity;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Column(name = "email")
    private String email;

    @Column(name = "number")
    private int number;

    @Column(name = "id_locale")
    private int id_locale;

    @Column(name = "id_bevanda")
    private int id_bevanda;

    @Column(name = "status")
    private String status;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name = "id_bevanda", insertable = false, updatable = false),
            @JoinColumn(name = "id_locale", insertable = false, updatable = false) })
    Menu menu;

    public Order() {
    }

    public Order(String email, int number, int numerosity, Date timestamp, String status) {
        this.email = email;
        this.number = number;
        this.numerosity = numerosity;
        this.timestamp = timestamp;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumerosity(int numerosity) {
        this.numerosity = numerosity;
    }

    public int getId() {
        return id;
    }

    public int getNumerosity() {
        return numerosity;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setId_bevanda(int id_bevanda) {
        this.id_bevanda = id_bevanda;
    }

    public void setId_locale(int id_locale) {
        this.id_locale = id_locale;
    }

    public int getId_bevanda() {
        return id_bevanda;
    }

    public int getId_locale() {
        return id_locale;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
