package com.donc.repo;

import com.donc.entities.User_;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by donovan on 15/10/27.
 */
public interface UserRepo extends JpaRepository<User_, Long> {

    User_ findByUsername(String username);
}
