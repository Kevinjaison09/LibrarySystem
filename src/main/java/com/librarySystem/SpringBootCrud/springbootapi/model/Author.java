package com.librarySystem.SpringBootCrud.springbootapi.model;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name ="authors")
public class Author {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 
 private int id;
 private String name;
 private String genre;
 
 @OneToMany(mappedBy ="authorEntity",cascade = CascadeType.ALL, orphanRemoval= true)
 private List<Book> books;
 
 //Getters
 public int getId() {
	 return id;
 }
 
 public String getName() {
	 return name;
 }
 
 public String getGenre() {
	 return genre;
 }
 
 public List<Book> getBooks(){
	 return books;
 }
 
//setters
 public void setId(int id) {
	 this.id = id;
 }
 
 public void setName(String name) {
	 this.name = name;
 }
 
 public void setGenre(String genre) {
	 this.genre = genre;
 }
 
 public void setBooks(List<Book> books){
	 this.books = books;
 }
}
