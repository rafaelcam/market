package com.market.request;

public class SubTotalsRequest {

    private Integer addition;
    private Integer discount;

    public SubTotalsRequest() {
    }

    public SubTotalsRequest addition(Integer addition) {
        this.addition = addition;
        return this;
    }

    public Integer getAddition() {
        return addition;
    }

    public SubTotalsRequest discount(Integer discount) {
        this.discount = discount;
        return this;
    }

    public Integer getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "SubTotalsRequest{" +
                "addition=" + addition +
                ", discount=" + discount +
                '}';
    }
}
