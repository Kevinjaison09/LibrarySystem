package com.librarySystem.SpringBootCrud.springbootapi.repository;

import com.librarySystem.SpringBootCrud.springbootapi.model.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBookRepository extends JpaRepository<UserBook,Integer >{

}
