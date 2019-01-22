package com.user.system.usersystem.repositories;

import com.user.system.usersystem.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepo  extends JpaRepository<User,Integer> {

    @Modifying
    @Query(value = "UPDATE User u SET u.deleted = true WHERE u.lastTimeLoggedIn > :date")
    void removeAllUnActiveUsersAfterDate(@Param("date") Date date);

    List<User> findAllByLastTimeLoggedInAfter(Date date);

    List<User> findAllByEmailContains(String provider);
}
