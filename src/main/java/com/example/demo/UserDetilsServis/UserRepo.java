package com.example.demo.UserDetilsServis;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.username=:username")
    UserDetails loadUserByUsername(@Param("username") String username);

}
