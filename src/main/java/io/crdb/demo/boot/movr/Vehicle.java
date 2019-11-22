package io.crdb.demo.boot.movr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

/*
CREATE TABLE IF NOT EXISTS vehicles (
	id UUID NOT NULL,
	city VARCHAR NOT NULL,
    owner_id UUID NULL,
	owner_city VARCHAR NOT NULL,
	type VARCHAR NULL,
	added_to_pool TIMESTAMP NULL,
	status VARCHAR NULL,
	make VARCHAR NULL,
	color VARCHAR NULL,
	CONSTRAINT "primary" PRIMARY KEY (city ASC, id ASC),
	CONSTRAINT fk_users FOREIGN KEY (owner_city, owner_id) REFERENCES users(city, id)
);
 */
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    private UUID id;
    private String city;
    private UUID ownerId;
    private String ownerCity;
    private String type;

    @Column(name = "added_to_pool")
    private Date addedToPool;
    private String status;
    private String make;
    private String color;

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

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerCity() {
        return ownerCity;
    }

    public void setOwnerCity(String ownerCity) {
        this.ownerCity = ownerCity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getAddedToPool() {
        return addedToPool;
    }

    public void setAddedToPool(Date addedToPool) {
        this.addedToPool = addedToPool;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
