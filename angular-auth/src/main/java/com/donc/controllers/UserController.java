package com.donc.controllers;

import com.donc.dto.UserDTO;
import com.donc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by donovan on 15/10/27.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserDTO>> get() {
        return new ResponseEntity<>(userService.get(), HttpStatus.OK);
    }

    @RequestMapping(value="/authenticate", method = RequestMethod.POST )
    public ResponseEntity authenticate(@RequestBody UserDTO userDTO) {
        if (!userService.authenticate(userDTO)) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity(HttpStatus.OK);
        }

    }

}
