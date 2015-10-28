package com.donc.service;

import com.donc.dto.UserDTO;
import com.donc.entities.User_;
import com.donc.repo.UserRepo;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by donovan on 15/10/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private StrongPasswordEncryptor spe;

    @Override
    public List<UserDTO> get() {
        List<User_> users = repo.findAll();
        List<UserDTO> dtos = new ArrayList<>();
        users.forEach(user -> {
            dtos.add(new UserDTO.Builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .password(user.getPassword()).build());
        });
        return dtos;
    }

    @Override
    public void createUser(UserDTO userDTO) {
        User_ user = new User_();
        user.setUsername(userDTO.getUsername());
        user.setPassword(spe.encryptPassword(userDTO.getPassword()));
        repo.save(user);
    }

    @Override
    public boolean authenticate(UserDTO userDTO) {

        User_ user = repo.findByUsername(userDTO.getUsername());
        if (user==null) {
            return false;
        }

        return spe.checkPassword(userDTO.getPassword(), user.getPassword());
    }

}
