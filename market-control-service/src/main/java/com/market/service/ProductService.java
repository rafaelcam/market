package com.market.service;


import com.market.model.Product;
import com.market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> findAll() throws Exception {
        return repository.findAll();
    }
}
