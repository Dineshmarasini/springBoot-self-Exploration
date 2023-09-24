package com.api.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;
@Component
public class BookService {
	@Autowired
	private BookRepository bookRepository;
//	private static List<Book> list=new ArrayList<>();
	
//	static {
//		list.add(new Book(1,"summar Love", "subin Bhattarai"));
//		list.add(new Book(2,"Priya Sufi", "subin Bhattarai"));
//		list.add(new Book(3,"Palpasa cafe","Narayan Wagle"));
//		list.add(new Book(4,"China haraeko Manche","Haribansha Acharya"));
//		
//	}
	//GET ALL BOOKS
	public List<Book> getAllBooks(){
		
		List<Book> list=(List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	//GET Books by id
	
	public Book getBookById(int id) {
		Book book=null;
		try {
//			book=list.stream().filter(e->e.getId()==id).findFirst().get();
			book=this.bookRepository.findById(id); 
			
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 
	return book;
		
	}
	
	//adding the Book
	public Book addBook(Book b) {
		 Book result=bookRepository.save(b);
		return result;
	}
	
	//delete book
	
	public void deleteBook(int bid) {
		
		 
//			list=list.stream().filter(e->e.getId()!=bid).collect(Collectors.toList());
		bookRepository.deleteById(bid);
			
		 
		
	}
	
	//update the book
	
	public void updateBook(Book book,int bookId) {
		
		book.setId(bookId);
		
		bookRepository.save(book);
		
//		list=list.stream().map(e->{
//			if(e.getId()==bookId) {
//				e.setTitle(book.getTitle());
//				e.setAuthor(book.getAuthor());
//			}
//			
//			return e;
//			
//		}).collect(Collectors.toList());
//		
    }

}
