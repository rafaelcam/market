package com.market.request;

public class AmountRequest {

    private SubTotalsRequest subtotals;

    public AmountRequest() {
    }

    public SubTotalsRequest getSubtotals() {
        return subtotals;
    }

    public AmountRequest subtotals(SubTotalsRequest subtotals) {
        this.subtotals = subtotals;
        return this;
    }

    @Override
    public String toString() {
        return "AmountRequest{" +
                "subtotals=" + subtotals +
                '}';
    }
}
