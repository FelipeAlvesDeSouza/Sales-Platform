package com.SoftwareItalo.SoftwareOfSuport.Repository;

import com.SoftwareItalo.SoftwareOfSuport.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query("SELECT p FROM Users p WHERE p.email = :email")
    Optional<Users> findByEmailUser(@Param("email") String name);
}

