import model.Coders;

import javax.persistence.*;
import java.util.List;

public class TypedQueryTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("JPQLExamples");
        EntityManager manager = entityManagerFactory.createEntityManager();

        manager.getTransaction().begin();
        Coders coders1 = new Coders("Valera");
        Coders coders2 = new Coders("Nastia");
        Coders coders3 = new Coders("Dima");
        manager.persist(coders1);
        manager.persist(coders2);
        manager.persist(coders3);
        manager.getTransaction().commit();

        TypedQuery<Coders> query =
                manager.createQuery("SELECT c FROM Coders c WHERE c.name=:inName", Coders.class);
        List list =
                query.setParameter("inName", "Oleh")
                        .setFirstResult(0)
                        .getResultList();
        list.stream().forEach(System.out::println);
    }
}
