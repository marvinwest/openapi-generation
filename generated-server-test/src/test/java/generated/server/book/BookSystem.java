package generated.server.book;

import java.util.UUID;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import generated.server.System;

public class BookSystem extends System {
	
	private static final String RESOURCE_LOCATION = "books";
	
	BookVerifier bookVerifier = new BookVerifier();
	
	public Response tryStoringBook(BookRequest book) {
		return this.fetchOrigin()
				.path(RESOURCE_LOCATION)
				.request()
				.post(Entity.json(book));
	}
	
	public Response tryFetchingBooks() {
		return this.fetchOrigin()
				.path(RESOURCE_LOCATION)
				.request()
				.get();
	}
	
	public Response tryFetchingBookbyBookId(UUID bookId) {
		final var bookIdString = bookId.toString();
		
		return this.fetchOrigin()
				.path(RESOURCE_LOCATION)
				.path(bookIdString)
				.request()
				.get();
	}

	public Response tryDeletingBookByBookId(UUID bookId) {
		final var bookIdString = bookId.toString();
		
		return this.fetchOrigin()
				.path(RESOURCE_LOCATION)
				.path(bookIdString)
				.request()
				.delete();
	}
	
	public BookRequest buildOrwell() {
		BookRequest orwell = new BookRequest();
		orwell.title = "Animal Farm";
		orwell.author = "George Orwell";
		orwell.year = 1945;
		
		return orwell;
	}
	
	public BookRequest buildHuxley() {
		BookRequest huxley = new BookRequest();
		huxley.title = "Brave New World";
		huxley.author = "Aldous Huxley";
		huxley.year = 1932;
		
		return huxley;
	}
}
