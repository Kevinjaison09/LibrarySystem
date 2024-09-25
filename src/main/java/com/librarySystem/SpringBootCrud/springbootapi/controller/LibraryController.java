package com.librarySystem.SpringBootCrud.springbootapi.controller;

import com.librarySystem.SpringBootCrud.springbootapi.model.Book;
import com.librarySystem.SpringBootCrud.springbootapi.model.User;
import com.librarySystem.SpringBootCrud.springbootapi.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;
    
    //post method
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return libraryService.createUser(user);
    }
    //get method
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return libraryService.getAllUsers();
    }
    
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return libraryService.getUserById(id);
    }
    // update method
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return libraryService.updateUser(id, user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        libraryService.deleteUser(id);
    }
    
//books
    
    //post method
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }
    
    // get method
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    //get method books by id 
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return libraryService.getBookById(id);
    }
    
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return libraryService.updateBook(id, book);
    }
    
    // delete method
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id) {
        libraryService.deleteBook(id);
    }

    //post method
    @PostMapping("/users/{userId}/books/{bookId}/take")
    public String takeBook(@PathVariable int userId, @PathVariable int bookId, @RequestParam int copies) {
        return libraryService.takeBook(userId, bookId, copies);
    }
}