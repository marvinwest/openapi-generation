package generated.server.book;

import java.util.UUID;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Not Implemented")
public class SimpleServerIT extends SystemTest {

	@Test
	@DisplayName("in Response for deletion")
	void delete() {
		// given
		final var bookId = UUID.randomUUID();

		// when
		Response response = bookSystem.tryDeletingBookByBookId(bookId);

		// then
		bookSystem.getVerifier().verifyNotImplemented(response);
	}

	@Test
	@DisplayName("in Response for post on book")
	void post() {
		// given
		final var book = bookSystem.buildOrwell();

		// when
		Response response = bookSystem.tryStoringBook(book);

		// then
		bookSystem.getVerifier().verifyNotImplemented(response);
	}

	@Test
	@DisplayName("in Response for get on books")
	void getBooks() {
		// when
		Response response = bookSystem.tryFetchingBooks();

		// then
		bookSystem.getVerifier().verifyNotImplemented(response);
	}

	@Test
	@DisplayName("in Response for get on book by bookId")
	void getBook() {
		// given
		final var bookId = UUID.randomUUID();

		// when
		Response response = bookSystem.tryFetchingBookbyBookId(bookId);

		// then
		bookSystem.getVerifier().verifyNotImplemented(response);
	}

}
