package generated.server.book;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("A Book")
public class DelegateServerIT extends SystemTest {

	@Test
	@DisplayName("can be Created")
	void post() {
		// given
		final var createRequest = bookSystem.buildOrwell();

		// when
		final var createResponse = bookSystem.tryStoringBook(createRequest);

		// then
		bookSystem.getVerifier().verifyStatus(createResponse, Response.Status.CREATED);
	}

	@Test
	@DisplayName("is found by bookId after creation")
	void CreatedBookisFoundByBookId() {
		// given
		final var createRequest = bookSystem.buildOrwell();
		final var createResponse = bookSystem.storeBook(createRequest);

		// when
		final var getResponse = bookSystem.fetchBookByBookId(createResponse.bookId);

		// then
		bookSystem.bookVerifier.booksAreEqual(createRequest, getResponse);
	}

	@Test
	@DisplayName("is found in BookInformation after Creation")
	void createdBookIsFound() {
		// given
		final var createRequest = bookSystem.buildOrwell();
		final var createResponse = bookSystem.storeBook(createRequest);

		// when
		Response getResponse = bookSystem.tryFetchingBooks();
		final var bookInformationList = getResponse.readEntity(BookList.class);

		// then
		Assertions.assertAll(
				() -> Assertions.assertEquals(createRequest.title, createResponse.title),
				() -> bookSystem.bookVerifier.assertBookIsInBookList(createResponse, bookInformationList));
	}

	@Test
	@DisplayName("can be updated (PUT) after creation")
	void createdBookCanBeUpdated() {
		// given
		final var createRequest = bookSystem.buildOrwell();
		final var createResponse = bookSystem.storeBook(createRequest);

		// when
		final var updateRequest = bookSystem.buildHuxley();
		bookSystem.tryUpdatingBookByBookId(createResponse.bookId, updateRequest);
		final var getResponse = bookSystem.fetchBookByBookId(createResponse.bookId);

		// then
		bookSystem.bookVerifier.booksAreEqual(updateRequest, getResponse);
	}

	@Test
	@DisplayName("can be updated (PATCH) after creation")
	void createdBookCanBePatched() {
		// given
		final var createRequest = bookSystem.buildHuxley();
		final var createResponse = bookSystem.storeBook(createRequest);

		// when
		final var patchRequest = bookSystem.buildOrwell();
		bookSystem.tryPatchingBookByBookId(createResponse.bookId, patchRequest);
		final var getResponse = bookSystem.fetchBookByBookId(createResponse.bookId);

		// then
		bookSystem.bookVerifier.booksAreEqual(patchRequest, getResponse);
	}

	@Test
	@DisplayName("can be deleted after creation")
	void createdBookCanBeDeleted() {
		// given
		final var createRequest = bookSystem.buildHuxley();
		final var createResponse = bookSystem.storeBook(createRequest);
		final var booksAfterCreation = bookSystem.fetchBooks();

		// when
		bookSystem.tryDeletingBookByBookId(createResponse.bookId);
		final var booksAfterDeletion = bookSystem.fetchBooks();

		// then
		Assertions.assertAll(
				() -> bookSystem.bookVerifier.assertBookIsInBookList(createResponse, booksAfterCreation),
				() -> bookSystem.bookVerifier.assertBookIsNotInBookList(createResponse, booksAfterDeletion));
	}

}
