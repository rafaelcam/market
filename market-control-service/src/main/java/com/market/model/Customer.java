package com.market.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "error.customer.name.notempty")
    private String name;

    @NotEmpty(message = "error.customer.email.notempty")
    private String email;

    @NotEmpty(message = "error.customer.cpf.notempty")
    private String cpf;

    @NotEmpty(message = "error.customer.areacode.notempty")
    private String areaCode;

    @NotEmpty(message = "error.customer.phone.notempty")
    private String phone;

    @NotEmpty(message = "error.customer.address.notempty")
    private String address;

    @NotNull(message = "error.customer.datebirth.notempty")
    private Date dateBirth;

    public Customer() {
    }

    public Customer(String name, String email, String cpf, String areaCode, String phone, String address, Date dateBirth) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.areaCode = areaCode;
        this.phone = phone;
        this.address = address;
        this.dateBirth = dateBirth;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
