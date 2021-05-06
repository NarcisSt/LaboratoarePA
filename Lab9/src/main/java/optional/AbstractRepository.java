package optional;

import compulsory.Singleton.PersistenceManager;

import javax.persistence.EntityManager;

/**
 * Generic class which help us to create or findById in our DB
 *
 * @param <S> is the type of object will use / what table will make query(Genres / Movies)
 */
public class AbstractRepository<S>{
    public S create(S entity){
        EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();

        return entity; //returns the saved entity
    }
/*
    public S findById(String id){
        EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();
        return (S)entityManager.createQuery("SELECT e FROM ?1 e WHERE e.id=?2").setParameter(1, S).setParameter(2, id).getSingleResult();
    }
*/
}
