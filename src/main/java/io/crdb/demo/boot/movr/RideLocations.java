package io.crdb.demo.boot.movr;

import java.util.Date;
import java.util.UUID;

/*
CREATE TABLE IF NOT EXISTS ride_locations (
	ride_id UUID NOT NULL,
	ride_city VARCHAR NOT NULL,
	"timestamp" TIMESTAMP NOT NULL,
	latitude FLOAT8 NULL,
	longitude FLOAT8 NULL,
 */
public class RideLocations {

    private UUID rideId;
    private String rideCity;
    private Date timestamp;
    private Float latitude;
    private Float longitude;

    public UUID getRideId() {
        return rideId;
    }

    public void setRideId(UUID rideId) {
        this.rideId = rideId;
    }

    public String getRideCity() {
        return rideCity;
    }

    public void setRideCity(String rideCity) {
        this.rideCity = rideCity;
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

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
}
