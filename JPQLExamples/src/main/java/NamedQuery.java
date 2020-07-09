import model.Coders;

import javax.persistence.*;
import java.util.List;

public class NamedQuery {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("JPQLExamples");
        EntityManager manager = entityManagerFactory.createEntityManager();

        manager.getTransaction().begin();
        Coders coders1 = new Coders("Valera");
        Coders coders2 = new Coders("Nastia");
        manager.persist(coders1);
        manager.persist(coders2);
        manager.getTransaction().commit();

        Query namedQuery = manager.createNamedQuery("get names by id");
        namedQuery.setParameter("codersId",20L);
        Coders coders = (Coders) namedQuery.getSingleResult();
        System.out.println(coders);
    }
}
