package CompulsoryLab9.RepoClasses;

import CompulsoryLab9.EntityClasses.Movies;
import CompulsoryLab9.Singleton.PersistenceManager;

import javax.persistence.EntityManager;

/**
 * Repository class for Movies, we can create new record in DB and find movie by name and by Id
 */
public class MoviesRepo {
    public void create (Movies movies) {
        EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(movies);
        entityManager.getTransaction().commit();
    }

    public Movies findMovieByName(String name) {
        EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();
        return (Movies) entityManager.createQuery("SELECT m FROM Movies m WHERE m.id=?1").setParameter(1, name).getSingleResult();
    }

    public Movies findMovieById(Long id) {
        EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();
        return (Movies) entityManager.createQuery("SELECT m FROM Movies m WHERE m.id=?1").setParameter(1, id).getSingleResult();
    }
}
