import modelBetter.Stock2;
import modelBetter.StockDetail2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class TestBetter {
    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OneToOne");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Stock2 stock = new Stock2();
        StockDetail2 stockDetail = new StockDetail2();

        stock.setStockCode("3y47tttthr7eh");
        stock.setStockName("Oleh");


        stockDetail.setCompName("cocacola");
        stockDetail.setCompDesc("3y4fff7h7eh");
        stockDetail.setListedDate(new Date());
        stockDetail.setRemark("nothing");

        stock.setStockDetail(stockDetail);
        stockDetail.setStock(stock);

        entitymanager.persist(stock);
        entitymanager.persist(stockDetail);

        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }
}
