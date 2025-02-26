package com.proj.service.impl;


import com.proj.mapper.UserMapper;
import com.proj.entity.User;
import com.proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser(){
//        return UserMapper.selectList(null);
        return null;
    }

    @Override
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.insert(user) >0 ;
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateById(user) > 0 ;
    }

    @Override
    public boolean deleteUser(Long id){
        return userMapper.deleteById(id) > 0 ;
    }

}
