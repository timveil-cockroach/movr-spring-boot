package io.crdb.demo.boot.movr;

import java.util.Date;
import java.util.UUID;

/*
CREATE TABLE vehicle_location_histories (
	city VARCHAR NOT NULL,
	ride_id UUID NOT NULL,
	"timestamp" TIMESTAMP NOT NULL,
	lat FLOAT8 NULL,
	long FLOAT8 NULL
)
 */
public class VehicleLocationHistory {

    private String city;
    private UUID rideId;
    private Date timestamp;
    private Float latitude;
    private Float longitude;

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

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
}
