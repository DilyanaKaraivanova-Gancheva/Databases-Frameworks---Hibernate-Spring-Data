package com.user.system.usersystem.services.impl;

import com.user.system.usersystem.models.entities.User;
import com.user.system.usersystem.repositories.UserRepo;
import com.user.system.usersystem.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepo repo;

    @Autowired
    public UserServiceImpl(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<User> findAllUsersByEmailProvider(String provider) {
        return this.repo.findAllByEmailContains(provider);
    }

    @Override
    public List<User> usersLastTimeLoggedInAfter(Date date) {
        return this.repo.findAllByLastTimeLoggedInAfter(date);
    }

    @Override
    public void removeAllUnActiveUsersAfterDate(Date date) {
        this.repo.removeAllUnActiveUsersAfterDate(date);
    }
}
