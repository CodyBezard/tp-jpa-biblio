package fr.digi.m062024;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="livre")
public class Livre {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="TITRE", length =255,nullable = false,unique = true)
    private String titre;

    @Column(name="AUTEUR", length = 50, nullable = false, unique = true)
    private String auteur;

    @ManyToMany(mappedBy = "livres")
    private Set<Emprunt> emprunts;

    public Livre() {
    }

    public Livre(Integer id) {
        this(id,"Titre");
    }

    public Livre(Integer id, String titre) {
        this(id, titre, "Auteur");
    }

    public Livre(Integer id, String titre, String auteur) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
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
     * Getter for titre
     * return titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Setter for titre
     *
     * @param titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Getter for auteur
     * return auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Setter for auteur
     *
     * @param auteur to set
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /**
     * Getter for emprunts
     * return emprunts
     */
    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    /**
     * Setter for emprunts
     *
     * @param emprunts to set
     */
    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", emprunts=" + emprunts +
                '}';
    }
}
