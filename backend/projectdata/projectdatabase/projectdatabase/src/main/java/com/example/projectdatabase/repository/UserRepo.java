package com.example.projectdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectdatabase.model.User;


@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
}