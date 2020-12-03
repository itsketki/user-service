package com.demo.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

/**
* <h1>Address entity</h1>
* The entity class for User address.
* <p>
*
* @author  Ketki Gupta
* @version 1.0
* @since   2020-12-03
*/
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String street;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    @Column(name = "post_code")
    @Positive
    private int postCode;

    public Address() {
        super();
    }
    public Address(Long id, @NotEmpty String street, @NotEmpty String city, @NotEmpty String state,
            @Positive int postCode) {
        super();
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", postCode="
                + postCode + "]";
    }


}
