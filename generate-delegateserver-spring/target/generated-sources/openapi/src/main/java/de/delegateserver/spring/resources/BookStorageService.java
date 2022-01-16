package de.delegateserver.spring.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.delegateserver.spring.model.Book;
import de.delegateserver.spring.model.BookInformation;
import de.delegateserver.spring.model.BookInformationList;

@Service
public class BookStorageService implements BooksApiDelegate {
	
	Map<UUID, Book> bookMap = new HashMap<>();

	@Override
	public ResponseEntity<BookInformation> booksPost(Book book) {
		UUID randomBookId = UUID.randomUUID();
        bookMap.put(randomBookId, book);
        
        BookInformation response = new BookInformation();
        response.setBookId(randomBookId);
        response.setTitle(book.getTitle());
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<Void> booksBookIdDelete(UUID bookId) {
    	bookMap.remove(bookId);
    	
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	@Override
	public ResponseEntity<Book> booksBookIdGet(UUID bookId) {
		Book response = bookMap.get(bookId);
        
        return new ResponseEntity<Book>(response, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<BookInformationList> booksGet(String title, String author, Integer year) {
		Stream<Book> bookStream = bookMap.values().stream();
        if (title != null) {
        	bookStream = bookStream.filter(b -> b.getTitle().equals(title));
        }
        if (author != null) {
        	bookStream = bookStream.filter(b -> b.getAuthor().equals(author));
        }
        if (year != null) {
        	bookStream = bookStream.filter(b -> b.getYear().equals(year));
        }
        
        List<Book> filteredBooks = bookStream.collect(Collectors.toList());
        
        List<BookInformation> bookInformations = filteredBooks.stream()
        		.map((Book b) -> {
        			for(UUID key : bookMap.keySet()) {
        				if(b.equals(bookMap.get(key))) {
        					BookInformation info = new BookInformation();
        					info.setBookId(key);
        					info.setTitle(b.getTitle());
        					return info;
        				}
        			}
        			return null;
        		})
        		.collect(Collectors.toList());
        
        BookInformationList response = new BookInformationList();
        response.setData(bookInformations);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
}
