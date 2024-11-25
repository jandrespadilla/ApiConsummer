package com.consumer.interfaces;

import com.consumer.models.User;

import java.util.List;

public interface UserRestInterface {
    public List<User> getAllUser();
    public User getUserById(String id);
    public User addUser(User user);
    public User updateUser(User user);
    public void deleteUser(String id);
}
