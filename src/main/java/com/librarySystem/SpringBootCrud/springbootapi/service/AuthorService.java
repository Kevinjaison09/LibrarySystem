package com.librarySystem.SpringBootCrud.springbootapi.service;

import com.librarySystem.SpringBootCrud.springbootapi.model.Author;
import com.librarySystem.SpringBootCrud.springbootapi.model.Book;
import com.librarySystem.SpringBootCrud.springbootapi.repository.AuthorRepository;
import com.librarySystem.SpringBootCrud.springbootapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    
	@Autowired
	private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;
     
    
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(int id) {
        return authorRepository.findById(id);
    }

    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }

    public Author updateAuthor(int id, Author updatedAuthor) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            author.setName(updatedAuthor.getName());
            author.setGenre(updatedAuthor.getGenre());
            return authorRepository.save(author);
        }
        return null;
    }
    public Book addBookToAuthor(int authorId, Book book) {
    	Author author = authorRepository.findById(authorId).orElse(null);
        if (author == null) {
            return null;
        }
        book.setAuthorEntity(author);
        return bookRepository.save(book);
    }

    public List<Book> getBooksByAuthor(int authorId) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if (author == null) {
            return null;
        }
        return author.getBooks();
    }
}

