package com.user.system.usersystem.services.impl;

import com.user.system.usersystem.repositories.TownRepo;
import com.user.system.usersystem.services.interfaces.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TownServiceImpl implements TownService {
    private TownRepo repo;

    @Autowired
    public TownServiceImpl(TownRepo repo) {
        this.repo = repo;
    }
}
