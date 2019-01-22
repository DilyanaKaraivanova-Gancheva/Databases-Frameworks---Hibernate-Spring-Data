package com.user.system.usersystem.repositories;

import com.user.system.usersystem.models.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country,Integer> {
}
