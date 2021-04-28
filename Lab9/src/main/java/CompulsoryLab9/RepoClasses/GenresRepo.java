package CompulsoryLab9.RepoClasses;

import CompulsoryLab9.EntityClasses.Genres;
import CompulsoryLab9.Singleton.PersistenceManager;

import javax.persistence.EntityManager;

/**
 * Repository class for Genres, we can create new record in DB and find genre by name
 */
public class GenresRepo {
    public Genres findGenreByName(String name) {
        EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();
        return (Genres) entityManager.createQuery("SELECT g FROM Genres g WHERE g.id=?1").setParameter(1, name).getSingleResult();
    }

    public void create (Genres genres) {
        EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(genres);
        entityManager.getTransaction().commit();
    }
}
