package com.market.service;


import com.market.model.Cart;
import com.market.model.ItemCart;
import com.market.model.Product;
import com.market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCartService implements IItemCartService {

    @Override
    public void loadCartInItemsCart(Cart cart) throws Exception {
        cart.getItems().forEach(itemCart -> {
            itemCart.setCart(cart);
        });
    }
}
