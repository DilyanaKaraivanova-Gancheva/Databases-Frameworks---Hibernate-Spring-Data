package com.user.system.usersystem.services.interfaces;

import com.user.system.usersystem.models.entities.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    List<User> findAllUsersByEmailProvider(String provider);
    List<User> usersLastTimeLoggedInAfter(Date date);
    void removeAllUnActiveUsersAfterDate(Date date);
}
