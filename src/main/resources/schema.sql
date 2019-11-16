DROP TABLE IF EXISTS promo_codes CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS user_promo_codes CASCADE;
DROP TABLE IF EXISTS rides CASCADE;
DROP TABLE IF EXISTS vehicles CASCADE;
DROP TABLE IF EXISTS vehicle_location_histories CASCADE;

CREATE TABLE IF NOT EXISTS users (
	id UUID NOT NULL,
	city VARCHAR NOT NULL,
	first_name VARCHAR NULL,
	last_name VARCHAR NULL,
	email_address VARCHAR NULL,
	address VARCHAR NULL,
	address_city VARCHAR NULL,
	address_state VARCHAR NULL,
	address_country VARCHAR NULL,
	address_postal_code VARCHAR NULL,
	CONSTRAINT "primary" PRIMARY KEY (city ASC, id ASC)
);

CREATE TABLE IF NOT EXISTS promo_codes (
	code VARCHAR NOT NULL,
	description VARCHAR NULL,
	creation_time TIMESTAMP NULL,
	expiration_time TIMESTAMP NULL,
	rules JSONB NULL,
	CONSTRAINT "primary" PRIMARY KEY (code ASC)
);

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

CREATE TABLE IF NOT EXISTS rides (
	id UUID NOT NULL,
	city VARCHAR NOT NULL,
	rider_id UUID NULL,
	rider_city VARCHAR NOT NULL,
	vehicle_id UUID NULL,
	vehicle_city VARCHAR NULL,
	start_address VARCHAR NULL,
	end_address VARCHAR NULL,
	start_time TIMESTAMP NULL,
	end_time TIMESTAMP NULL,
	revenue DECIMAL(10,2) NULL,
	CONSTRAINT "primary" PRIMARY KEY (city ASC, id ASC),
	CONSTRAINT fk_users FOREIGN KEY (rider_city, rider_id) REFERENCES users(city, id),
	CONSTRAINT fk_vehicles FOREIGN KEY (vehicle_city, vehicle_id) REFERENCES vehicles(city, id)
);

CREATE TABLE IF NOT EXISTS ride_locations (
	ride_id UUID NOT NULL,
	ride_city VARCHAR NOT NULL,
	"timestamp" TIMESTAMP NOT NULL,
	lat FLOAT8 NULL,
	long FLOAT8 NULL,
	CONSTRAINT "primary" PRIMARY KEY (ride_city ASC, ride_id ASC, "timestamp" ASC),
	CONSTRAINT fk_rides FOREIGN KEY (ride_city, ride_id) REFERENCES rides(city, id)
);
/*
CREATE TABLE IF NOT EXISTS user_promo_codes (
	city VARCHAR NOT NULL,
	user_id UUID NOT NULL,
	code VARCHAR NOT NULL,
	"timestamp" TIMESTAMP NULL,
	usage_count INT8 NULL,
	CONSTRAINT "primary" PRIMARY KEY (city ASC, user_id ASC, code ASC),
	CONSTRAINT fk_city_ref_users FOREIGN KEY (city, user_id) REFERENCES users(city, id)
);
*/