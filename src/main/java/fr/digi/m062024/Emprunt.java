package fr.digi.m062024;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="emprunt")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "DATE_DEBUT", nullable = false)
    private LocalDateTime dateDebut;
    @Column(name = "DELAI", length = 10)
    private Integer delai;
    @Column(name = "DATE_FIN")
    private LocalDateTime dateFin;
    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;
    @ManyToMany
    @JoinTable(name = "compo",
            joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
    private Set<Livre> livres;

    public Emprunt() {
    }

    public Emprunt(Integer id, LocalDateTime dateDebut, Integer delai, LocalDateTime dateFin, Client client) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.delai = delai;
        this.dateFin = dateFin;
        this.client = client;
    }

    /**
     * Getter for id
     * return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for id
     *
     * @param id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for dateDebut
     * return dateDebut
     */
    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    /**
     * Setter for dateDebut
     *
     * @param dateDebut to set
     */
    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Getter for delai
     * return delai
     */
    public Integer getDelai() {
        return delai;
    }

    /**
     * Setter for delai
     *
     * @param delai to set
     */
    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    /**
     * Getter for dateFin
     * return dateFin
     */
    public LocalDateTime getDateFin() {
        return dateFin;
    }

    /**
     * Setter for dateFin
     *
     * @param dateFin to set
     */
    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Getter for client
     * return client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Setter for client
     *
     * @param client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Getter for livres
     * return livres
     */
    public Set<Livre> getLivres() {
        return livres;
    }

    /**
     * Setter for livres
     *
     * @param livres to set
     */
    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", delai=" + delai +
                ", dateFin=" + dateFin +
                ", client=" + client +
                '}';
    }
}
