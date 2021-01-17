package com.api.drinktakeaway_core_back.entity.auth;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "utente", schema = "autenticazione")
public class Utente {

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id")
    private Integer id;

    // @ManyToMany(fetch = FetchType.EAGER)
    // @JoinTable(joinColumns = @JoinColumn(name = "id_utente_fk",
    // referencedColumnName = "id_utente"), inverseJoinColumns = @JoinColumn(name =
    // "id_ruolo_fk", referencedColumnName = "id_ruolo"))
    // private Set<Ruolo> ruoli = new HashSet<>();

    // @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "utente_ruolo", joinColumns = @JoinColumn(name = "id_utente_fk"), inverseJoinColumns = @JoinColumn(name = "id_ruolo_fk"))
    private Set<Ruolo> ruoli = new HashSet<>();

    public Utente(String email, String password) {
        this.password = password;
        this.email = email;
    }

    public Utente() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdUtente(int idUtente) {
        this.id = idUtente;
    }

    public Integer getidUtente() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Set<Ruolo> getRuoli() {
        return ruoli;
    }

    public void setRuoli(Set<Ruolo> ruoli) {
        this.ruoli = ruoli;
    }

}
