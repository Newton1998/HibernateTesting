package modelBetter;

import modelSimple.Stock;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock_details2")
public class StockDetail2 {

    @Id
    private Integer stockId;

    @OneToOne
    @MapsId
    private Stock2 stock;
    private String compName;
    private String compDesc;
    private String remark;

    @Temporal(TemporalType.DATE)
    @Column(name = "LISTED_DATE", nullable = false, length = 10)
    private Date listedDate;

    public StockDetail2() {
    }

    public StockDetail2(Stock2 stock, String compName, String compDesc, String remark, Date listedDate) {
        this.stock = stock;
        this.compName = compName;
        this.compDesc = compDesc;
        this.remark = remark;
        this.listedDate = listedDate;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Stock2 getStock() {
        return stock;
    }

    public void setStock(Stock2 stock) {
        this.stock = stock;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompDesc() {
        return compDesc;
    }

    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getListedDate() {
        return listedDate;
    }

    public void setListedDate(Date listedDate) {
        this.listedDate = listedDate;
    }
}
