package com.donc.service;

import com.donc.dto.UserDTO;
import com.donc.entities.User_;

import java.util.List;

/**
 * Created by donovan on 15/10/27.
 */
public interface UserService {

    List<UserDTO> get();

    void createUser(UserDTO userDTO);

    boolean authenticate(UserDTO userDTO);
}
