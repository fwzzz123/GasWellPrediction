package com.proj.service;

import com.proj.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    User getUserById(int id);

    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(Long id);

}
