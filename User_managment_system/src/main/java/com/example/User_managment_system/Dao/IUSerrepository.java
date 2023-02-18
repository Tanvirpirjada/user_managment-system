package com.example.User_managment_system.Dao;

import com.example.User_managment_system.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUSerrepository extends JpaRepository<User,Integer> {
}
