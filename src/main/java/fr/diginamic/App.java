package fr.diginamic;

import fr.digi.m062024.Client;
import fr.digi.m062024.Emprunt;
import fr.digi.m062024.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp-jpa-biblio");
        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();

        //CRUD ==> Read/select
        Livre livreATrouver = em.find(Livre.class,2);
        if(livreATrouver != null){
            System.out.println(livreATrouver.getId() + " " + livreATrouver.getTitre() + " de l'auteur " + livreATrouver.getAuteur());
        }

        Client clientATrouver = em.find(Client.class,1);
        if(clientATrouver != null){
            System.out.println("Liste des emprunts du Client " + clientATrouver.getNom() + " : " + clientATrouver.getEmprunts());
        }

        Emprunt empruntATrouver = em.find(Emprunt.class,3);
        if(empruntATrouver != null){
            System.out.println("Liste des livres de l'emprunt a l'indice 2 : "+ empruntATrouver.getLivres());
        }

        Client clientToutEmprunt = em.find(Client.class,1);
        if(clientToutEmprunt!=null){
            System.out.println("Liste des emprunts du client 1 :");
            for(Emprunt var: clientToutEmprunt.getEmprunts()){
                System.out.println(var);
            }
        }

        em.close();
        emf.close();
    }
}
