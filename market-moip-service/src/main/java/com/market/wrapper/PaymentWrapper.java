package com.market.wrapper;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "payment")
public class PaymentWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @NotNull(message = "error.payment.installments.notempty")
    @Max(value = 10, message = "error.payment.installments.limit")
    @Min(value = 1, message = "error.payment.installments.limit")
    private Integer installments;

    public PaymentWrapper() {
    }

    public PaymentWrapper(String name, String number, String monthExpiration, String yearExpiration, String securityCode) {
        this.name = name;
        this.number = number;
        this.monthExpiration = monthExpiration;
        this.yearExpiration = yearExpiration;
        this.securityCode = securityCode;
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
}
