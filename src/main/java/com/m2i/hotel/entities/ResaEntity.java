package com.m2i.hotel.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "resa", schema = "hotelm2i", catalog = "")
public class ResaEntity {

/*id, #client, #hotel , datedeb , datefin , num_chambre*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = "CLIENT_ID_FK_1"))
    private ClientlEntity client;

    @ManyToOne
    @JoinColumn(name = "hotel_id", foreignKey = @ForeignKey(name = "CLIENT_ID_FK_1"))
    private HotelEntity hotel;

    @Column(length = 45, nullable = false, unique = true)
    private Date dateDeb;

    @Column(length = 45, nullable = false, unique = true)
    private Date dateFin;

    @Column(length = 3, nullable = false, unique = true)
    private Integer num_chambre;

    public ResaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientlEntity getClient() {
        return client;
    }

    public void setClient(ClientlEntity client) {
        this.client = client;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getNum_chambre() {
        return num_chambre;
    }

    public void setNum_chambre(Integer num_chambre) {
        this.num_chambre = num_chambre;
    }
}
