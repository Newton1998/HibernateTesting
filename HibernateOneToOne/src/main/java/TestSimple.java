import modelSimple.Stock;
import modelSimple.StockDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class TestSimple {
    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OneToOne");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Stock stock = new Stock();
        StockDetail stockDetail = new StockDetail();

        stock.setStockCode("3y47h4hhr7eh");
        stock.setStockName("Vadym");


        stockDetail.setCompName("cocacola");
        stockDetail.setCompDesc("3y47h7eh");
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
