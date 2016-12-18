package com.market.service;

import com.market.model.Cart;
import com.market.model.ItemCart;
import com.market.model.Product;

import java.util.List;

public interface IItemCartService {

    public void loadCartInItemsCart(Cart cart) throws Exception;
}
