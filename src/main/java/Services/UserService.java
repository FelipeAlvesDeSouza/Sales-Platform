package Services;

import Model.Users;
import Repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository)
    {
        this.usersRepository = usersRepository;
    }


   /* public boolean authenticateUser(String emailUser , String password)
    {
        Optional <Users> users = usersRepository.findByEmailUser(emailUser)

        return true;
    }*/


}
