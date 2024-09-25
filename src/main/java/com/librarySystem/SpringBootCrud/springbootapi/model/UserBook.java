package com.librarySystem.SpringBootCrud.springbootapi.model;

import jakarta.persistence.*;

@Entity
@Table(name ="user_books")

public class UserBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	private int copiesTaken;
	
	
	//getter methods
	
	public int getId() {
		return id;
	}
	
	public User getUser() {
		return user;
	}
	
	public Book getBook() {
		return book;
	}
	
    public int getCopiesTaken() {
    	return copiesTaken;
    }

    
    //setter methods
    
    public void setId(int id) {
        this.id = id;
    }
    

    public void setUser(User user) {
        this.user = user;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }
    
    public void setCopiesTaken(int copiesTaken) {
        this.copiesTaken = copiesTaken;
    }
    
}
