package Repository;

import Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query("SELECT p FROM Users p WHERE p.emailUser = :emailUser")
    Optional<Users> findByEmailUser(@Param("emailUser") String name);
}

