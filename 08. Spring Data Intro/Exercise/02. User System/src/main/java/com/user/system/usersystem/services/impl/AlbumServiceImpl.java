package com.user.system.usersystem.services.impl;

import com.user.system.usersystem.repositories.AlbumRepo;
import com.user.system.usersystem.services.interfaces.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

public class AlbumServiceImpl implements AlbumService {
    private AlbumRepo repo;

    @Autowired
    public AlbumServiceImpl(AlbumRepo repo) {
        this.repo = repo;
    }
}
