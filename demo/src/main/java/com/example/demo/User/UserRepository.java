package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserClass,Long> {

    @Query("SELECT u FROM UserClass u Where u.user_name = ?1")
    Optional<UserClass> findUserByName(String user_name);

}
