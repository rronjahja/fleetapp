package com.example.fleetapp.repositories;

import com.example.fleetapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByFirstnameAndLastname(String firstname, String lastname);
}
