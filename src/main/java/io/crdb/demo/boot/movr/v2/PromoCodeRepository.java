package io.crdb.demo.boot.movr.v2;

import io.crdb.demo.boot.movr.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoCodeRepository extends JpaRepository<PromoCode, String> {
}
