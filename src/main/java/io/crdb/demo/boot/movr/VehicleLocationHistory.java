package io.crdb.demo.boot.movr;

import java.util.Date;
import java.util.UUID;

public class VehicleLocationHistory {

    private String city;
    private UUID rideId;
    private Date timestamp;
    private Float latitude;
    private Float longitutde;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UUID getRideId() {
        return rideId;
    }

    public void setRideId(UUID rideId) {
        this.rideId = rideId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitutde() {
        return longitutde;
    }

    public void setLongitutde(Float longitutde) {
        this.longitutde = longitutde;
    }
}
