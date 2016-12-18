package com.market.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String number;

    @Column(name = "month_expiration")
    private String monthExpiration;

    @Column(name = "year_expiration")
    private String yearExpiration;

    @Column(name = "security_code")
    private String securityCode;

    public Payment() {
    }

    public Payment(String name, String number, String monthExpiration, String yearExpiration, String securityCode) {
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
    
}
