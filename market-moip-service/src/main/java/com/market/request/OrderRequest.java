package com.market.request;


public class OrderRequest extends br.com.moip.request.OrderRequest {

    private AmountRequest amount;

    public OrderRequest() {
    }

    public OrderRequest amount(AmountRequest amount) {
        this.amount = amount;
        return this;
    }

    public AmountRequest getAmount() {
        return amount;
    }
}
