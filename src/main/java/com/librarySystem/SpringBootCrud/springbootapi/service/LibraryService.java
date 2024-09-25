package com.librarySystem.SpringBootCrud.springbootapi.service;

import com.librarySystem.SpringBootCrud.springbootapi.model.Book;
import com.librarySystem.SpringBootCrud.springbootapi.model.User;
import com.librarySystem.SpringBootCrud.springbootapi.model.UserBook;
import com.librarySystem.SpringBootCrud.springbootapi.repository.BookRepository;
import com.librarySystem.SpringBootCrud.springbootapi.repository.UserBookRepository;
import com.librarySystem.SpringBootCrud.springbootapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class LibraryService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserBookRepository userBookRepository;
	
	//add user
	public User createUser(User user) {
		return userRepository.save(user);
	}
	//get all the user
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	//get user by id 
	public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    } 
	
	//update user
	public User updateUser(int id, User updatedUser) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(updatedUser.getName());
            user.SetEmail(updatedUser.getEmail());
            return userRepository.save(user);
        }
        return null;
    }
	
	//delete user
	public void deleteUser(int id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
		}else {
			throw new RuntimeException("book not found with ID: "+id);
		}
	}
	
	
	
    //add book
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	//get book
	public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
	
	//get a book by id 
	public Book getBookById(int id) {
		return bookRepository.findById(id).orElse(null);
	}
		
	//update book
	public Book updateBook(int id, Book updatedBook) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthorEntity(updatedBook.getAuthorEntity());
            book.setCopies(updatedBook.getCopies());
            book.setIsbn(updatedBook.getIsbn());
            return bookRepository.save(book);
        }
        return null;
    }
	
	//delete book
	public void deleteBook(int id) {
		if (bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
		}else {
			throw new RuntimeException("book not found with ID: "+id);
		}
		
	}

	
	
	
    //take book copies
	public String takeBook( int userId, int bookId, int copies) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null || book.getCopies() < copies) {
            return "Not enough copies available.";
        }
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return "User not found.";
        }
        UserBook userBook = new UserBook();
        userBook.setUser(user);
        userBook.setBook(book);
        userBook.setCopiesTaken(copies);
        userBookRepository.save(userBook);
        book.setCopies(book.getCopies() - copies);
        bookRepository.save(book);
        return "Book copies taken successfully.";
    }
}
