package io.crdb.demo.boot.movr;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.UUID;

/*
CREATE TABLE vehicles (
	id UUID NOT NULL,
	city VARCHAR NOT NULL,
	type VARCHAR NULL,
	owner_id UUID NULL,
	creation_time TIMESTAMP NULL,
	status VARCHAR NULL,
	current_location VARCHAR NULL,
	ext JSONB NULL
)
 */
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    private UUID id;
    private String city;
    private String type;
    private UUID ownerId;

    @Column(name = "creation_time")
    private Date creationDate;
    private String status;
    private String currentLocation;
    private String ext;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
