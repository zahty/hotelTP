package com.m2i.hotel.entities;


import javax.persistence.*;

@Entity
@Table(name = "hotel", schema = "hotelm2i", catalog = "")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false, unique = true)
    private String nom;

    @Column(length = 15, nullable = false, unique = true)
    private String etoiles;

    @Column(length = 45, nullable = false, unique = true)
    private String adresse;

    @Column(length = 45, nullable = false, unique = true)
    private String telephone;

    @Column(length = 45, nullable = false, unique = true)
    private String email;

    @Column(length = 45, nullable = false, unique = true)
    private String ville;



    public HotelEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEtoiles() {
        return etoiles;
    }

    public void setEtoiles(String etoiles) {
        this.etoiles = etoiles;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }


}
