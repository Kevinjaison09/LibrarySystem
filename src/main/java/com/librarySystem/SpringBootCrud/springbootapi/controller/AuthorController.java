package com.librarySystem.SpringBootCrud.springbootapi.controller;

import com.librarySystem.SpringBootCrud.springbootapi.model.Author;
import com.librarySystem.SpringBootCrud.springbootapi.model.Book;
import com.librarySystem.SpringBootCrud.springbootapi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }
    
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable int id) {
        return authorService.getAuthorById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthor(id);
    }

    @PostMapping("/{authorId}/books")
    public Book addBookToAuthor(@PathVariable int authorId, @RequestBody Book book) {
        return authorService.addBookToAuthor(authorId, book);
    }

    @GetMapping("/{authorId}/books")
    public List<Book> getBooksByAuthor(@PathVariable int authorId) {
        return authorService.getBooksByAuthor(authorId);
    }
}

