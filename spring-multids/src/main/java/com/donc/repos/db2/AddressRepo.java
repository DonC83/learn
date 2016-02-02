package com.donc.repos.db2;

import com.donc.db2.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Donovan Chong on 2015-11-10.
 */
public interface AddressRepo extends JpaRepository<Address, Long>, AddressRepoCust {
}
