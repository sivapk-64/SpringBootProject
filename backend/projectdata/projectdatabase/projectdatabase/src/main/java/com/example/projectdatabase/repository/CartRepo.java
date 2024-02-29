package com.example.projectdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.projectdatabase.model.Cart;
import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer>{
    @Query(value="select * from my_cart mc WHERE mc.app_name=?1",nativeQuery=true)
    List<Cart> findByAppName(String appName);
}