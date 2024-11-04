package fr.digi.m062024;

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

        em.close();
        emf.close();
    }
}
