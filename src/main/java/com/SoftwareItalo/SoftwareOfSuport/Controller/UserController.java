package com.SoftwareItalo.SoftwareOfSuport.Controller;

import com.SoftwareItalo.SoftwareOfSuport.Model.Users;
import com.SoftwareItalo.SoftwareOfSuport.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping()
    public List<Users> listUsers()
    {
        return userService.getAllUsers();
    }


    @PostMapping()
    public ResponseEntity<Users> addUsers(@Valid @RequestBody Users user, @RequestParam  String emails, @RequestParam  String userPassword)
    {
        Users users = userService.addUsers(user, emails, userPassword);

        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }
}