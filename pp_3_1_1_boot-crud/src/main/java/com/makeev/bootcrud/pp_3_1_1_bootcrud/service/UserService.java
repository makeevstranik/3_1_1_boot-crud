package com.makeev.bootcrud.pp_3_1_1_bootcrud.service;

import com.makeev.bootcrud.pp_3_1_1_bootcrud.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(User user);
    List<User> getAllUsers();
    List<User> getUsersByName(String name);
    Optional<User> getUserById(Long id);
    void updateUser(User user);
    void deleteUserById(Long id);

}
