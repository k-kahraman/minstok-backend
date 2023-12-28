package com.minstok.minstokbackend.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product extends BaseEntity {

    private String name;
    private String description;
    private int quantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "stock_unit_id", referencedColumnName = "id")
    private StockUnit stockUnit;
}
