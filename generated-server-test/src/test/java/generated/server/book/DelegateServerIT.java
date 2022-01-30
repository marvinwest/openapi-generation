package generated.server.book;

import java.util.UUID;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Book")
public class DelegateServerIT extends SystemTest {

	@Test
	@DisplayName("Can be Created")
	void post() {
		// given
		final var book = bookSystem.buildOrwell();

		// when
		Response response = bookSystem.tryStoringBook(book);

		// then
		bookSystem.getVerifier().verifyStatus(response, Response.Status.CREATED);
	}
	
	@Test
	@DisplayName("is found by bookId after creation")
	void CreatedBookisFoundByBookId() {
		// given
		final var expectedBook = bookSystem.buildOrwell();
		Response postResponse = bookSystem.tryStoringBook(expectedBook);
		final var bookResponse = postResponse.readEntity(BookResponse.class);
		
		//when
		final var bookId = UUID.fromString(bookResponse.bookId);
		Response getResponse = bookSystem.tryFetchingBookbyBookId(bookId);
		final var foundBook = getResponse.readEntity(BookRequest.class);
		
		//then
		bookSystem.bookVerifier.booksAreEqual(expectedBook, foundBook);
	}

	@Test
	@DisplayName("is Found in BookInformation after Creation")
	void createdBookIsFound() {
		// given
		final var book = bookSystem.buildOrwell();
		Response postResponse = bookSystem.tryStoringBook(book);
		final var bookInformation = postResponse.readEntity(BookResponse.class);

		// when
		Response getResponse = bookSystem.tryFetchingBooks();
		final var bookInformationList = getResponse.readEntity(BookList.class);
		

		// then
		Assertions.assertAll(
			() -> Assertions.assertEquals(book.title, bookInformation.title),
			() -> bookSystem.bookVerifier.assertBookInformationInBookInformationList(bookInformation, bookInformationList)
		);
	}

}
