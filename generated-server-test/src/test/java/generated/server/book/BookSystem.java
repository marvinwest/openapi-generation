package generated.server.book;

import java.util.UUID;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import generated.server.System;

public class BookSystem extends System {
	
	private static final String RESOURCE_LOCATION = "books";
	
	BookVerifier bookVerifier = new BookVerifier();
	
	public BookResponse storeBook(BookRequest book) {
		Response response = this.tryStoringBook(book);
		return response.readEntity(BookResponse.class);
	}
	
	public Response tryStoringBook(BookRequest book) {
		return this.fetchOrigin()
				.path(RESOURCE_LOCATION)
				.request()
				.post(Entity.json(book));
	}
	
	public BookList fetchBooks() {
		final Response response = tryFetchingBooks();
		return response.readEntity(BookList.class);
	}
	
	public Response tryFetchingBooks() {
		return this.fetchOrigin()
				.path(RESOURCE_LOCATION)
				.request()
				.get();
	}
	
	public BookResponse fetchBookByBookId(String bookId) {
		final Response response = tryFetchingBookByBookId(bookId);
		return response.readEntity(BookResponse.class);
	}
	
	public Response tryFetchingBookByBookId(String bookId) {
		return this.fetchOrigin()
				.path(RESOURCE_LOCATION)
				.path(bookId)
				.request()
				.get();
	}
	
	public Response tryUpdatingBookByBookId(String bookId, BookRequest book) {
		return this.fetchOrigin()
				.path(RESOURCE_LOCATION)
				.path(bookId)
				.request()
				.method(HttpMethod.PUT, Entity.json(book));
	}
	
	public Response tryPatchingBookByBookId(String bookId, BookRequest book) {
		return this.fetchOrigin()
				.path(RESOURCE_LOCATION)
				.path(bookId)
				.request()
				.method(HttpMethod.PATCH, Entity.json(book));
	}

	public Response tryDeletingBookByBookId(String bookId) {	
		return this.fetchOrigin()
				.path(RESOURCE_LOCATION)
				.path(bookId)
				.request()
				.delete();
	}
	
	public BookRequest buildOrwell() {
		BookRequest orwell = new BookRequest();
		orwell.title = "Animal Farm";
		orwell.author = "George Orwell";
		orwell.year = 1945;
		orwell.summary = "All animals are equal, but some animals are more equal than others.";
		
		return orwell;
	}
	
	public BookRequest buildHuxley() {
		BookRequest huxley = new BookRequest();
		huxley.title = "Brave New World";
		huxley.author = "Aldous Huxley";
		huxley.year = 1932;
		
		return huxley;
	}
	
	public BookRequest buildInvalidBook() {
		return new BookRequest();
	}
}
