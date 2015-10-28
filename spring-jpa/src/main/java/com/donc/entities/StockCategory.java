package com.donc.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by donovan on 15/10/20.
 */
@Entity
@Table(name = "stock_category")
@AssociationOverrides({
        @AssociationOverride(name = "pk.stock", joinColumns = @JoinColumn(name = "stock_id")),
        @AssociationOverride(name = "pk.category", joinColumns = @JoinColumn(name = "category_id"))
})
public class StockCategory {

    private StockCategoryId pk = new StockCategoryId();
    private Date createdDate;
    private String createdBy;

    @EmbeddedId
    public StockCategoryId getPk() {
        return pk;
    }

    public void setPk(StockCategoryId pk) {
        this.pk = pk;
    }

    @Transient
    public Stock getStock() {
        return getPk().getStock();
    }

    public void setStock(Stock stock) {
        getPk().setStock(stock);
    }

    @Transient
    public Category getCategory() {
        return getPk().getCategory();
    }

    public void setCategory(Category category) {
        getPk().setCategory(category);
    }


    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", nullable = false, length = 10)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "CREATED_BY", nullable = false, length = 10)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
