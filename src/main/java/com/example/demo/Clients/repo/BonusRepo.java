package com.example.demo.Clients.repo;

import com.example.demo.Clients.Bonus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusRepo extends CrudRepository<Bonus,Long>{
}
