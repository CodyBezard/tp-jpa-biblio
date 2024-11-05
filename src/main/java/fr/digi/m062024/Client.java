package fr.digi.m062024;

import jakarta.persistence.*;

import java.util.IdentityHashMap;
import java.util.Set;

@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    @Column(name="NOM",length = 50)
    private String nom;
    @Column(name="PRENOM", length = 50)
    private String prenom;
    @OneToMany(mappedBy="client")
    private Set<Emprunt> emprunts;


    public Client() {
    }

    public Client(String nom, String prenom){
        this(-1,nom,prenom);
    }

    public Client(Integer id, String prenom, String nom) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
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
     * Getter for nom
     * return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter for nom
     *
     * @param nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter for prenom
     * return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter for prenom
     *
     * @param prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
}
