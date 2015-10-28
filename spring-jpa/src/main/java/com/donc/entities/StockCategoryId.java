package com.donc.entities;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by donovan on 15/10/20.
 */
@Embeddable
public class StockCategoryId implements Serializable {

    private Stock stock;
    private Category category;

    @ManyToOne
    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
