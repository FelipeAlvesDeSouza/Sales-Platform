package com.SoftwareItalo.SoftwareOfSuport.Services;

import com.SoftwareItalo.SoftwareOfSuport.Model.Users;
import com.SoftwareItalo.SoftwareOfSuport.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UsersRepository usersRepository;
    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public List<Users> getAllUsers()
    {
        System.out.println("TESTE TESTE TESTE");
        return usersRepository.findAll();
    }

    public Users addUsers(Users users, String email, String encryptedPassword) {
        Optional<Users> existingUser = usersRepository.findByEmailUser(email);

        if (existingUser.isPresent()) {
            throw new RuntimeException("Já existe um usuário cadastrado com este e-mail.");
        }

        users.setPassword(encryptedPassword);
        return usersRepository.save(users);
    }

    public boolean authenticateUser(String userEmail, String encryptedPassword) {
        Optional<Users> users = usersRepository.findByEmailUser(userEmail);

        if (users.isPresent()) {
            Users user = users.get();
            return user.checkPassword(encryptedPassword); // Verifica a senha de forma segura
        }
        return false; // Autenticação falhou
    }
}
