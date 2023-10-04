package com.api.book.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	//GET ALL BOOK HANDLERS
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list= bookService.getAllBooks();	
		
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		 
		return ResponseEntity.status(HttpStatus.CREATED).body(list );
		
	}
	
	//GET SINGLE BOOK HANDLERS
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book= bookService.getBookById(id);
		
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
		
	}
	
	//NEW BOOK HANDLER
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b= null;
		try {
			b=bookService.addBook(book);
			System.out.println(book);
			return ResponseEntity.of(Optional.of(b));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	//DELETE BOOK HANDLERS
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
		
		try {
			this.bookService.deleteBook(id);
			return ResponseEntity.ok().build();
		}
		catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
			
		}
	}
	
	
	//UPDATE BOOK HANDLERS
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		
		try {
			this.bookService.updateBook(book, bookId);
			return ResponseEntity.ok().body(book);
		}
		 catch(Exception e){
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			 
		 }
		
	}
		
	
	
	

}
