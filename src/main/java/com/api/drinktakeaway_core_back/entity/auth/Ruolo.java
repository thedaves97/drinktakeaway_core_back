package com.api.drinktakeaway_core_back.entity.auth;

import com.api.drinktakeaway_core_back.enums.RuoloEnum;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ruolo", schema = "autenticazione")
public class Ruolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "nome_ruolo")
    private RuoloEnum ruoloEnum;

    // @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "utente_ruolo", joinColumns = @JoinColumn(name = "id_ruolo_fk"), inverseJoinColumns = @JoinColumn(name = "id_utente_fk"))
    private Set<Utente> utenti = new HashSet<>();

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Set<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(Set<Utente> utenti) {
        this.utenti = utenti;
    }

    public void setRuoloEnum(RuoloEnum ruoloEnum) {
        this.ruoloEnum = ruoloEnum;
    }

    public RuoloEnum getRuoloEnum() {
        return ruoloEnum;
    }

}
