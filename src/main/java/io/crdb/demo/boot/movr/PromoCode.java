package io.crdb.demo.boot.movr;

import java.util.Date;
/*
CREATE TABLE promo_codes (
	code VARCHAR NOT NULL,
	description VARCHAR NULL,
	creation_time TIMESTAMP NULL,
	expiration_time TIMESTAMP NULL,
	rules JSONB NULL
)
 */
public class PromoCode {
    private String code;
    private String description;
    private Date creationTime;
    private Date expirationTime;
    private String rules;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }
}
