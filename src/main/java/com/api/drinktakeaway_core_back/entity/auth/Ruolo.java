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
    private Set<Ruolo> ruoli = new HashSet<>();

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setRuoli(Set<Ruolo> ruoli) {
        this.ruoli = ruoli;
    }

    public Set<Ruolo> getRuoli() {
        return ruoli;
    }

    public void setRuoloEnum(RuoloEnum ruoloEnum) {
        this.ruoloEnum = ruoloEnum;
    }

    public RuoloEnum getRuoloEnum() {
        return ruoloEnum;
    }

}
