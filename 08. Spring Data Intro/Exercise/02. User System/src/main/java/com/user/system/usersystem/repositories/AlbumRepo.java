package com.user.system.usersystem.repositories;

import com.user.system.usersystem.models.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepo extends JpaRepository<Album,Integer> {
}
