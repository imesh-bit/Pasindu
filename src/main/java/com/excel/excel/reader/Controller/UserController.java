package com.excel.excel.reader.Controller;

import com.excel.excel.reader.DTO.UserDto;
import com.excel.excel.reader.Entity.User;
import com.excel.excel.reader.Service.IMPL.UserserviceIMPL;
import com.excel.excel.reader.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping

public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
        String username = userDto.getUsername();
        String password = userDto.getPassword();

        if (userService.authenticateUser(username, password)) {
            return ResponseEntity.ok("Login successful!");
        } else {
            System.out.println(username+password);
               return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");

        }


    }
}



