package com.mustafavardal.user.controller;

import com.mustafavardal.user.entity.User;
import com.mustafavardal.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@Tag(name = "User Api", description = "User CRUD operations")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;



    @PostMapping("/addUser")
    public ResponseEntity<String> addNewUser(@Valid @RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok("User added successfully!");
    }

    @GetMapping("/getAllUserWithDetails")
    public ResponseEntity<List<User>> getAllUsersWithDetails(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/getUserByName/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name){
        User  user = userService.getUserByName(name);

        if (Objects.isNull(user)){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(user);
        }
    }

    @DeleteMapping("/deleteUserByName/{name}")
    public ResponseEntity<String> deleteUserByName(@PathVariable String name){
        userService.deleteUserByName(name);
        return ResponseEntity.ok("User deleted successfully");
    }

}
