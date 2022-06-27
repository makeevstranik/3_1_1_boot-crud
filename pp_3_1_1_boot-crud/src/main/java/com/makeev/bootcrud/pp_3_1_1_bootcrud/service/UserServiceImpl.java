package com.makeev.bootcrud.pp_3_1_1_bootcrud.service;

import com.makeev.bootcrud.pp_3_1_1_bootcrud.model.User;
import com.makeev.bootcrud.pp_3_1_1_bootcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    final private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userRepository.getUsersByFirstName(name);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(User user) {
        if (userRepository.existsById(user.getId())) {
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
