package com.klef.jfsd.exam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService
{

	@Autowired
	private BookRepo repo;
	@Override
	public String addbook(Book B) {
		repo.save(B);
		return "Book Data addedsuccesfully";
		
	}

	@Override
	public String updateBook(Book B) 
	{
		 Optional<Book> obj = repo.findById(B.getBookId());
		    String msg = null;
		    if (obj.isPresent()) {
		        Book book = obj.get();
		        // Update operation code
		        book.setTitle(B.getTitle());
		        book.setAuthor(B.getAuthor());
		        book.setGenre(B.getGenre());
		        book.setPrice(B.getPrice());
		        book.setPublishedYear(B.getPublishedYear());

		        repo.save(book);
		        msg = "Book updated successfully";
		    } else {
		        msg = "Book ID not found";
		    }
		    return msg;
	}
	
	
	

}


