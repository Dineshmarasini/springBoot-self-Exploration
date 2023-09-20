package com.api.book.controller;



 
import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	//GET ALL BOOK HANDLERS
	@GetMapping("/books")
	public List<Book> getBooks() {
		 return bookService.getAllBooks();			
	}
	
	//GET SINGLE BOOK HANDLERS
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
		
	}
	
	//NEW BOOK HANDLER
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b= bookService.addBook(book);
		System.out.println(book);
		return b;
	}
	
	//DELETE BOOK HANDLERS
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		this.bookService.deleteBook(id);
	}
	
	
	//UPDATE BOOK HANDLERS
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		
		this.bookService.updateBook(book, bookId);
		return book;
		
	}
		
	
	
	

}
