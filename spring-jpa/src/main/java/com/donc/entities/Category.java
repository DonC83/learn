package com.donc.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by donovan on 15/10/20.
 */
@Entity
@Table
public class Category {

    private long id;
    private String name;
    private String desc;
    private Set<StockCategory> stockCategories = new HashSet<>();

    @Id
    @Column(unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(nullable = false)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.category")
    public Set<StockCategory> getStockCategories() {
        return stockCategories;
    }

    public void setStockCategories(Set<StockCategory> stockCategories) {
        this.stockCategories = stockCategories;
    }
}
