package modelBetter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ITEMS2")
public class Items2{

    @Id
    private int id;

    @ManyToOne
    @MapsId
    private Cart2 cart;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE", nullable = false)
    private Date date;

    public Items2(){}

    public Items2(Cart2 cart, Date date) {
        this.cart = cart;
        this.date = date;
    }

    public Cart2 getCart() {
        return cart;
    }

    public void setCart(Cart2 cart) {
        this.cart = cart;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Items2{" +
                "cart=" + cart +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items2 items2 = (Items2) o;
        return id == items2.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
