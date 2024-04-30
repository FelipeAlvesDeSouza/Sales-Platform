package Services;

import Model.Users;
import Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users addUsers(Users users, String emailUser, String password) {
        if (authenticateUser(emailUser, password)) {
            Optional<Users> existingUser = usersRepository.findByEmailUser(emailUser);

            if (existingUser.isPresent())
                throw new RuntimeException("Já existe um usuário cadastrado com este e-mail.");

            return usersRepository.save(users);
        }
        throw new RuntimeException("Falha na autenticação do usuário.");
    }

    public boolean authenticateUser(String emailUser, String password) {
        Optional<Users> users = usersRepository.findByEmailUser(emailUser);

        if (users.isPresent()) {
            Users user = users.get();
            return user.checkPassword(password); // Verifica a senha de forma segura
        }
        return false; // Autenticação falhou
    }
}
