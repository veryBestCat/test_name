package com.example.demo.service;

import com.example.demo.dto.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserSerivce {

    private final List<User> users = new ArrayList<>();

    public List<User> getAll() {
        return users;
    }

    public boolean add(User user) {
        return users.add(user);
    }
}
