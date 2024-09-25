package com.librarySystem.SpringBootCrud.springbootapi.repository;

import com.librarySystem.SpringBootCrud.springbootapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Integer>{

}
