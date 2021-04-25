package Singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
    private static final PersistenceManager singleton = new PersistenceManager();
    private EntityManagerFactory emf;
    private static final boolean DEBUG = true;

    public static PersistenceManager getInstance() {
        return singleton;
    }

    public EntityManagerFactory getEntityManagerFactory() {

        if (emf == null) {
            createEntityManagerFactory();
        }
        return emf;
    }

    private void createEntityManagerFactory() {

        this.emf = Persistence.createEntityManagerFactory("lab9-persistence");
        if (DEBUG)
            System.out.println("n Persistence started at " + new java.util.Date());
    }

    public void closeEntityManagerFactory() {

        if (emf != null) {
            emf.close();
            emf = null;
            if (DEBUG)
                System.out.println("n Persistence finished at " + new java.util.Date());
        }
    }
}
