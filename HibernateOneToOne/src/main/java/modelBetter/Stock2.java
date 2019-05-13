package modelBetter;

import modelSimple.StockDetail;

import javax.persistence.*;

@Entity
@Table(name = "stocks2")
public class Stock2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stockId;

    @Column(name = "STOCK_CODE", unique = true, nullable = false)
    private String stockCode;

    @Column(name = "STOCK_NAME", unique = true, nullable = false)
    private String stockName;

    @OneToOne(mappedBy = "stock", cascade = CascadeType.ALL)
    private StockDetail2 stockDetail;

    public Stock2() {
    }

    public Stock2(String stockCode, String stockName, StockDetail2 stockDetail) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.stockDetail = stockDetail;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public StockDetail2 getStockDetail() {
        return stockDetail;
    }

    public void setStockDetail(StockDetail2 stockDetail) {
        this.stockDetail = stockDetail;
    }
}
