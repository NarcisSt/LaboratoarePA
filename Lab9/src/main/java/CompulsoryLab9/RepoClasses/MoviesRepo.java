package CompulsoryLab9.RepoClasses;

import CompulsoryLab9.EntityClasses.Movies;
import CompulsoryLab9.Singleton.PersistenceManager;

import javax.persistence.EntityManager;

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
