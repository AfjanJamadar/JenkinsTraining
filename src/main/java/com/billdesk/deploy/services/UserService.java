package com.billdesk.deploy.services;

import java.util.List;

import com.billdesk.deploy.models.User;

public interface UserService {

    // Create
    User createUser(User user);

    // Read
    List<User> getAllUsers();

    User getUserById(Long id);

    // Update
    User updateUser(Long id, User user);

    // Delete
    void deleteUser(Long id);
}