package com.librarySystem.SpringBootCrud.springbootapi.repository;

import com.librarySystem.SpringBootCrud.springbootapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

}
