package com.user.system.usersystem.repositories;

import com.user.system.usersystem.models.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepo extends JpaRepository<Picture,Integer> {
}
