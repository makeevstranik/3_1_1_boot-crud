package com.makeev.bootcrud.pp_3_1_1_bootcrud.repository;

import com.makeev.bootcrud.pp_3_1_1_bootcrud.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> getUsersByFirstName(String firstname);
}
