package com.api.drinktakeaway_core_back.entity.DTA;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MenuKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id_locale")
    private int id_locale;

    @Column(name = "id_bevanda")
    private int id_bevanda;

    public int getId_bevanda() {
        return id_bevanda;
    }

    public int getId_locale() {
        return id_locale;
    }

    public void setId_bevanda(int id_bevanda) {
        this.id_bevanda = id_bevanda;
    }

    public void setId_locale(int id_locale) {
        this.id_locale = id_locale;
    }

}