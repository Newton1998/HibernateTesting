package tests;

import model.Cart;
import model.Items;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OneToMany");

        EntityManager entitymanager = emfactory.createEntityManager();

        Cart cart = new Cart();
        Items items1 = new Items();
        Items items2 = new Items();

        cart.setCustomerName("Vadym");

        items1.setDate(new Date());
        items2.setDate(new Date());

        cart.getItems().add(items1);
        cart.getItems().add(items2);

        items1.setCart(cart);
        items2.setCart(cart);


        entitymanager.getTransaction().begin();

        entitymanager.persist(cart);
        entitymanager.persist(items1);
        entitymanager.persist(items2);

        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }
}
