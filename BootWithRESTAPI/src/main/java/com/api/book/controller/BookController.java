package com.api.book.controller;



 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/book")
	public List<Book> getBooks() {
		 return this.bookService.getAllBooks();
				
	}
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return this.bookService.getBookById(id);
		
	}
	
	

}
