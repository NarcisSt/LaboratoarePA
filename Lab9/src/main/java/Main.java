import EntityClasses.Movies;
import Singleton.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory();
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Movies new_movie = new Movies();

        em.getTransaction().commit();
        em.close();
        factory.close();
    }
}
