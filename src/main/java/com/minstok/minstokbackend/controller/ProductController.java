package com.minstok.minstokbackend.controller;

import com.minstok.minstokbackend.entity.Product;
import com.minstok.minstokbackend.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController extends BaseEntityController<Product> {

    public ProductController(IService<Product> service) {
        super(service);
    }

}
