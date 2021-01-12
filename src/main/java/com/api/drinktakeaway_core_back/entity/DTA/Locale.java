package com.api.drinktakeaway_core_back.entity.DTA;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "locale", schema = "drink_take_away")
public class Locale {

    /**
     * @ManyToMany
     * @JoinTable(name = "menu", joinColumns = @JoinColumn(name = "id_locale"),
     *                 inverseJoinColumns = @JoinColumn(name = "id_bevanda"))
     *                 private Set<Bevanda> bevande = new HashSet<>();
     **/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "bevanda")
    private Set<Menu> bevanda = new HashSet<>();

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "type")
    private String type;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lon")
    private double lon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
