package CompulsoryLab9.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Singleton class using Enum. We create one instance for EntityManagerFactory then use it for creating EntityManager object
 */
public enum PersistenceManager {
    INSTANCE;

    private EntityManagerFactory emf = null;

    PersistenceManager() {
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("lab9-persistence");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void closeEntityManagerFactory() {
        if (emf != null)
            emf.close();
    }
}
