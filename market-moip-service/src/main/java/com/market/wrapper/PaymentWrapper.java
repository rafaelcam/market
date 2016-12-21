package com.market.wrapper;

import java.io.Serializable;

public class PaymentWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String numberPayment;

    private String name;

    private String number;

    private String monthExpiration;

    private String yearExpiration;

    private String securityCode;

    private Integer installments;

    private String hash;

    public PaymentWrapper() {
    }

    public PaymentWrapper(Long id, String numberPayment, String name, String number, String monthExpiration,
                          String yearExpiration, String securityCode, Integer installments, String hash) {
        this.id = id;
        this.numberPayment = numberPayment;
        this.name = name;
        this.number = number;
        this.monthExpiration = monthExpiration;
        this.yearExpiration = yearExpiration;
        this.securityCode = securityCode;
        this.installments = installments;
        this.hash = hash;
    }

    public PaymentWrapper(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.installments = builder.installments;
        this.hash = builder.hash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMonthExpiration() {
        return monthExpiration;
    }

    public void setMonthExpiration(String monthExpiration) {
        this.monthExpiration = monthExpiration;
    }

    public String getYearExpiration() {
        return yearExpiration;
    }

    public void setYearExpiration(String yearExpiration) {
        this.yearExpiration = yearExpiration;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getNumberPayment() {
        return numberPayment;
    }

    public void setNumberPayment(String numberPayment) {
        this.numberPayment = numberPayment;
    }

    @Override
    public String toString() {
        return "PaymentWrapper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", monthExpiration='" + monthExpiration + '\'' +
                ", yearExpiration='" + yearExpiration + '\'' +
                ", securityCode='" + securityCode + '\'' +
                '}';
    }

    public static class Builder {
        private Long id;
        private String name;
        private String number;
        private String monthExpiration;
        private String yearExpiration;
        private String securityCode;
        private Integer installments;
        private String hash;

        public Builder() { }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder installments(Integer installments) {
            this.installments = installments;
            return this;
        }

        public Builder hash(String hash) {
            this.hash = hash;
            return this;
        }

        public PaymentWrapper build() {
            return new PaymentWrapper(this);
        }
    }
}
