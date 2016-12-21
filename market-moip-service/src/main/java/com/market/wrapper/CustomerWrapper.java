package com.market.wrapper;

import java.io.Serializable;
import java.util.Date;


public class CustomerWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String email;

    private String cpf;

    private String areaCode;

    private String phone;

    private String address;

    private Date dateBirth;

    public CustomerWrapper() {
    }

    public CustomerWrapper(String name, String email, String cpf, String areaCode, String phone, String address, Date dateBirth) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.areaCode = areaCode;
        this.phone = phone;
        this.address = address;
        this.dateBirth = dateBirth;
    }

    public CustomerWrapper(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.cpf = builder.cpf;
        this.areaCode = builder.areaCode;
        this.phone = builder.phone;
        this.address = builder.address;
        this.dateBirth = builder.dateBirth;
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

    public static class Builder {
        private Long id;
        private String name;
        private String email;
        private String cpf;
        private String areaCode;
        private String phone;
        private String address;
        private Date dateBirth;

        public Builder() { }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder areaCode(String areaCode) {
            this.areaCode = areaCode;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder dateBirth(Date dateBirth) {
            this.dateBirth = dateBirth;
            return this;
        }

        public CustomerWrapper build() {
            return new CustomerWrapper(this);
        }
    }
}
