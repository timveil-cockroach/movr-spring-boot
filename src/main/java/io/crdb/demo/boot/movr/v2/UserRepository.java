package io.crdb.demo.boot.movr.v2;

import io.crdb.demo.boot.movr.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
