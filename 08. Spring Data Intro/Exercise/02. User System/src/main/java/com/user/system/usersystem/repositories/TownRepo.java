package com.user.system.usersystem.repositories;

import com.user.system.usersystem.models.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepo extends JpaRepository<Town,Integer> {
}
