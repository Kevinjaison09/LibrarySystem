package com.librarySystem.SpringBootCrud.springbootapi.model;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String title;
	private int copies;
	private String isbn;
	@ManyToOne
	@JoinColumn(name ="author_id")
	private Author authorEntity;
	
	//getter Methods
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	
	public int getCopies() {
		return copies;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public Author getAuthorEntity() {
        return authorEntity;
    }
	
	//setter Methods
	
	public void setId(int id) {
	    this.id=id;
	}
	
	public void  setTitle(String title) {
	    this.title=title;
	}
	
	
	public void setCopies(int copies) {
	    this.copies=copies;
	}
	
	public void  setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setAuthorEntity(Author authorEntity) {
        this.authorEntity = authorEntity;
    }
		
}
