package org.example.task1blogwithlogin.repo;

import org.example.task1blogwithlogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo  extends JpaRepository<User,Integer> {

    Optional<User> findUserByEmail(String email);

}
