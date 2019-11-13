package io.crdb.demo.boot.bank.v3;

import io.crdb.demo.boot.bank.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, String> {
}
