package com.minstok.minstokbackend.controller;

import com.minstok.minstokbackend.entity.Depot;
import com.minstok.minstokbackend.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/depots")
public class DepotController extends BaseEntityController<Depot> {
    public DepotController(IService<Depot> service) {
        super(service);
    }
    // You can add depot-specific endpoints here if needed
}
