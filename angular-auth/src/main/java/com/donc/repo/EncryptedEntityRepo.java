package com.donc.repo;

import com.donc.entities.EncrytedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by donovan on 15/10/27.
 */
public interface EncryptedEntityRepo extends JpaRepository<EncrytedEntity, Long> {
}
