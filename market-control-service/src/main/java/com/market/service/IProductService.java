package com.market.service;

import com.market.model.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findAll() throws Exception;
}
