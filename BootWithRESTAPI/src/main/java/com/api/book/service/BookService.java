package com.api.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.entities.Book;
@Component
public class BookService {
	private static List<Book> list=new ArrayList<>();
	
	static {
		list.add(new Book(1,"summar Love", "subin Bhattarai"));
		list.add(new Book(2,"Priya Sufi", "subin Bhattarai"));
		list.add(new Book(3,"Palpasa cafe","Narayan Wagle"));
		list.add(new Book(4,"China haraeko Manche","Haribansha Acharya"));
		
	}
	
	public List<Book> getAllBooks(){
		return list;
	}
	
	public Book getBookById(int id) {
		Book book=null;
		
		 
	book=list.stream().filter(e->e.getId()==id).findFirst().get();
	return book;
		
	}
	
	//adding the Book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	
	//delete book
	
	public void deleteBook(int bid) {
		list=list.stream().filter(e->e.getId()!=bid).collect(Collectors.toList());
	}
	
	//update the book
	
	public void updateBook(Book book,int bookId) {
		
		list=list.stream().map(e->{
			if(e.getId()==bookId) {
				e.setTitle(book.getTitle());
				e.setAuthor(book.getAuthor());
			}
			
			return e;
			
		}).collect(Collectors.toList());
		
	}

}
