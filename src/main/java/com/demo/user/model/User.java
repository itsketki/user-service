package com.demo.user.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
* <h1>User entity</h1>
* The entity class for User.
* <p>
*
* @author  Ketki Gupta
* @version 1.0
* @since   2020-12-03
*/
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long id;

    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    private String title;

    @NotEmpty
    private String gender;

    public User() {
        super();
    }

    public User(Long id, @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String title,
            @NotEmpty String gender, Address address) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.gender = gender;
        this.address = address;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
                + ", gender=" + gender + ", address=" + address + "]";
    }

}
