package io.crdb.demo.boot.movr.v3;

import io.crdb.demo.boot.movr.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, String> {
}
