package com.librarySystem.SpringBootCrud.springbootapi.repository;

import com.librarySystem.SpringBootCrud.springbootapi.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author,Integer>{

}
