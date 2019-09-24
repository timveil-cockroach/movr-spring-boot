package io.crdb.demo.boot.movr;

import java.util.Date;
import java.util.UUID;

public class UserPromoCode {
    private String city;
    private UUID userId;
    private String code;
    private Date timestamp;
    private int usageCount;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(int usageCount) {
        this.usageCount = usageCount;
    }
}
