package com.example.demo.Clients.repo;

import com.example.demo.Clients.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends CrudRepository<Client,Long> {


    @Query("SELECT c FROM Client c WHERE c.username=:username")
    Client loadUserByUsername(@Param("username") String username);

}
