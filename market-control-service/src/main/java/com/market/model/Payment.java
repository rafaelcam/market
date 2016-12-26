package com.market.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberPayment;

    @NotEmpty(message = "error.payment.name.notempty")
    private String name;

    @NotEmpty(message = "error.payment.number.notempty")
    private String number;

    @Column(name = "month_expiration")
    @NotEmpty(message = "error.payment.month.notempty")
    private String monthExpiration;

    @Column(name = "year_expiration")
    @NotEmpty(message = "error.payment.year.notempty")
    private String yearExpiration;

    @Column(name = "security_code")
    @NotEmpty(message = "error.payment.code.notempty")
    private String securityCode;

    @NotNull(message = "error.payment.installments.notnull")
    @Max(value = 10, message = "error.payment.installments.limit")
    @Min(value = 1, message = "error.payment.installments.limit")
    private Integer installments;

    @NotEmpty(message = "error.payment.hash.notempty")
    @Lob
    private String hash;

    public Payment() {
    }

    public Payment(String numberPayment, String name, String number, String monthExpiration, String yearExpiration, String securityCode, Integer installments, String hash) {
        this.numberPayment = numberPayment;
        this.name = name;
        this.number = number;
        this.monthExpiration = monthExpiration;
        this.yearExpiration = yearExpiration;
        this.securityCode = securityCode;
        this.installments = installments;
        this.hash = hash;
    }

    public Payment(Builder builder) {
        this.name = builder.name;
        this.number = builder.number;
        this.monthExpiration = builder.monthExpiration;
        this.yearExpiration = builder.yearExpiration;
        this.securityCode = builder.securityCode;
        this.installments = builder.installments;
        this.hash = builder.hash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberPayment() {
        return numberPayment;
    }

    public void setNumberPayment(String numberPayment) {
        this.numberPayment = numberPayment;
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

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", numberPayment='" + numberPayment + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", monthExpiration='" + monthExpiration + '\'' +
                ", yearExpiration='" + yearExpiration + '\'' +
                ", securityCode='" + securityCode + '\'' +
                ", installments=" + installments +
                ", hash='" + hash + '\'' +
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

        public Payment build() {
            return new Payment(this);
        }
    }
}
