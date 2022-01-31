package de.delegateserver.spring.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.delegateserver.spring.model.BookList;
import de.delegateserver.spring.model.BookPatchRequest;
import de.delegateserver.spring.model.BookRequest;
import de.delegateserver.spring.model.BookResponse;

@Service
public class BookStorageService implements BooksApiDelegate {

	Map<UUID, BookRequest> bookMap = new HashMap<>();
	
	@Override
	public ResponseEntity<Void> booksBookIdDelete(UUID bookId) {
		bookMap.remove(bookId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@Override
	public ResponseEntity<BookResponse> booksBookIdGet(UUID bookId) {
		BookRequest book = bookMap.get(bookId);
		
		BookResponse response = buildBookResponse(bookId, book);
		
		return new ResponseEntity<>(response, HttpStatus.OK);	
	}
	
	@Override
	public ResponseEntity<Void> booksBookIdPatch(UUID bookId, BookPatchRequest request) {
		BookRequest book = bookMap.get(bookId);
		
		String newAuthor = request.getAuthor();
		String newTitle = request.getTitle();
		Integer newYear = request.getYear();
		String newSummary = request.getSummary();
		
		if (newAuthor != null) {
			book.setAuthor(newAuthor);
		}
		if (newTitle != null) {
			book.setTitle(newTitle);
		}
		if (newYear != null) {
			book.setYear(newYear);
		}
		if (newSummary != null) {
			book.setSummary(newSummary);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@Override 
	public ResponseEntity<Void> booksBookIdPut(UUID bookId, @Valid @NotNull BookRequest request) {
		bookMap.put(bookId, request);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@Override
	public ResponseEntity<BookList> booksGet(Optional<String> title, Optional<String> author,
        Optional<Integer> year) {
		Stream<BookRequest> bookStream = bookMap.values().stream();
		
		if (title.isPresent()) {
			bookStream = bookStream.filter(book -> book.getTitle().equals(title.get()));
		}
		if (author.isPresent()) {
			bookStream = bookStream.filter(book -> book.getAuthor().equals(author.get()));
		}
		if (year.isPresent()) {
			bookStream = bookStream.filter(book -> book.getYear().equals(year.isPresent()));
		}
		
		List<BookRequest> filteredBooks = bookStream.collect(Collectors.toList());
		
		List<BookResponse> bookList = new ArrayList<>();
		for(UUID key : bookMap.keySet()) {
			for (BookRequest filteredBook : filteredBooks) {
				if (filteredBook.equals(bookMap.get(key))) {
					BookResponse book = buildBookResponse(key, filteredBook);
					bookList.add(book);
					break;
				}
			}
		}
		
		BookList responseList = new BookList();
		responseList.setData(bookList);
		
		return new ResponseEntity<>(responseList, HttpStatus.OK);
	}
	
	
	@Override
	public ResponseEntity<BookResponse> booksPost(@Valid @NotNull BookRequest request) {
		UUID bookId = UUID.randomUUID();
		bookMap.put(bookId, request);
		
		BookResponse response = buildBookResponse(bookId, request);
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	private BookResponse buildBookResponse(UUID bookId, BookRequest book) {
		BookResponse response = new BookResponse();
		response.setBookId(bookId);
		response.setAuthor(book.getAuthor());
		response.setTitle(book.getTitle());
		response.setYear(book.getYear());
		response.setSummary(book.getSummary());
		
		return response;	
	}
	
 }

