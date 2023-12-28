package com.minstok.minstokbackend.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StockUnit extends BaseEntity {

    private String name;
    private String qrCode;
    private String note;

    @ManyToOne
    @JoinColumn(name = "depot_id", referencedColumnName = "id")
    private Depot depot;
}
