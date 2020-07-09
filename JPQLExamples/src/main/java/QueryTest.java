import model.Coders;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class QueryTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("JPQLExamples");
        EntityManager manager = entityManagerFactory.createEntityManager();

        manager.getTransaction().begin();
        Coders coders1 = new Coders("Oleh");
        Coders coders2 = new Coders("ihor");
        Coders coders3 = new Coders("Kiril");
        manager.persist(coders1);
        manager.persist(coders2);
        manager.persist(coders3);
        manager.getTransaction().commit();
        //jpql (java persistence query language), hql, sql + oop
        Query query =
                manager.createQuery("SELECT c FROM Coders c WHERE c.name=:inName");
        List list =
                query.setParameter("inName", "Oleh")
                        .setFirstResult(2)
                        .getResultList();
        list.stream().forEach(System.out::println);

    }
}
