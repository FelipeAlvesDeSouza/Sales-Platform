package Controller;

import Model.Users;
import Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<Users> addUsers(@Valid @RequestBody Users user, @RequestParam String emailUser, @RequestParam String password)
    {
        Users users = userService.addUsers(user, emailUser, password);

        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }
}
