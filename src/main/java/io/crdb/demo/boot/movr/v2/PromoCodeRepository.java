package io.crdb.demo.boot.movr.v2;

import io.crdb.demo.boot.movr.PromoCode;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PromoCodeRepository extends PagingAndSortingRepository<PromoCode, String> {
}
