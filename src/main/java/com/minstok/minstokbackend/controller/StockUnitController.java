package com.minstok.minstokbackend.controller;

import com.minstok.minstokbackend.entity.StockUnit;
import com.minstok.minstokbackend.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock-units")
public class StockUnitController extends BaseEntityController<StockUnit> {
    public StockUnitController(IService<StockUnit> service) {
        super(service);
    }

}
