package tests;

import model.Cart;
import model.Items;
import modelBetter.Cart2;
import modelBetter.Items2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class TestBetter {
    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OneToMany");

        EntityManager entitymanager = emfactory.createEntityManager();

        Cart2 cart = new Cart2();
        Items2 items1 = new Items2();
        Items2 items2 = new Items2();
        cart.setCustomerName("Vlad");
        items1.setDate(new Date());
        items1.setCart(cart);
        items2.setCart(cart);
        items2.setDate(new Date());
        cart.getItems().add(items1);
        cart.getItems().add(items2);

        entitymanager.getTransaction().begin();

        entitymanager.persist(cart);
        entitymanager.persist(items1);
        entitymanager.persist(items2);

        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }
}
