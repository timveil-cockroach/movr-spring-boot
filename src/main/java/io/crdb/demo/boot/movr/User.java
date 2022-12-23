package io.crdb.demo.boot.movr;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

/*
CREATE TABLE users (
	id UUID NOT NULL,
	city VARCHAR NOT NULL,
	name VARCHAR NULL,
	address VARCHAR NULL,
	credit_card VARCHAR NULL
)
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    private UUID id;
    private String city;
    private String name;
    private String address;
    private String creditCard;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
