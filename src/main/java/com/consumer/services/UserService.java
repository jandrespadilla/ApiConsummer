package com.consumer.services;

import com.consumer.interfaces.UserRestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.consumer.models.User;
import com.consumer.apis.UserRestApi;

import java.util.List;

@Service
public class UserService implements UserRestInterface {
    @Autowired
    private UserRestApi userRestApi;

    @Override
    public List<User> getAllUser() {
        return userRestApi.getAllUser();
    }

    @Override
    public User getUserById(String id) {
        return userRestApi.getUserById(id);
    }

    @Override
    public User addUser(User user) {
        return userRestApi.addUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userRestApi.updateUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userRestApi.deleteUser(id);
    }
}
