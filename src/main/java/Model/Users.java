package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameUser;
    private String emailUser;
    private String encryptedPassword;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void setEncryptedPassword(String password) {
        this.encryptedPassword = passwordEncoder.encode(password);
    }
}
