package com.example.demo.Clients.repo;

import com.example.demo.Clients.Bonus;
import com.example.demo.Clients.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepo extends CrudRepository<Seller,Long> {
}
