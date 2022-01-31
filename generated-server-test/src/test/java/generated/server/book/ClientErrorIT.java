package generated.server.book;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("A ClientError")
public class ClientErrorIT extends SystemTest{

	@Test
	@DisplayName("if bookId is not in format of UUID in GET")
	void getWithIncorrectlyFormattedBookId() {
		//given
		final var incorrectBookId = "Not a UUID";
		
		//when
		final var response = bookSystem.tryFetchingBookByBookId(incorrectBookId);
		
		//then
		bookSystem.getVerifier().verifyClientError(response);
	}
	
	@Test
	@DisplayName("if bookId is not in format of UUID in PUT")
	void putWithIncorrectlyFormattedBookId() {
		//given
		final var incorrectBookId = "Not a UUID";
		final var putRequest = bookSystem.buildHuxley();
		
		//when
		final var response = bookSystem.tryUpdatingBookByBookId(incorrectBookId, putRequest);
		
		//then
		bookSystem.getVerifier().verifyClientError(response);
	}
	
	@Test
	@DisplayName("if bookId is not in format of UUID in PATCH")
	void patchWithIncorrectlyFormattedBookId() {
		//given
		final var incorrectBookId = "Not a UUID";
		final var patchRequest = bookSystem.buildHuxley();
		
		//when
		final var response = bookSystem.tryPatchingBookByBookId(incorrectBookId, patchRequest);
		
		//then
		bookSystem.getVerifier().verifyClientError(response);
	}
	
	@Test
	@DisplayName("if bookId is not in format of UUID in DELETE")
	void deleteWithIncorrectlyFormattedBookId() {
		//given
		final var incorrectBookId = "Not a UUID";
		
		//when
		final var response = bookSystem.tryDeletingBookByBookId(incorrectBookId);
		
		//then
		bookSystem.getVerifier().verifyClientError(response);
	}
	
	@Disabled("Returns successful, even though required attributes title, author and year in BookRequest are missing")
	@Test
	@DisplayName("If required fields for BookRequest are not set in POST")
	void requiredFieldsMissingPost() {
		//given
		final var invalidRequest = bookSystem.buildInvalidBook();
		
		//when
		final var response = bookSystem.tryStoringBook(invalidRequest);
		
		//then
		bookSystem.getVerifier().verifyClientError(response);
	}
	
	@Disabled("Returns successful, even though required attributes title, author and year in BookRequest are missing")
	@Test
	@DisplayName("If required fields for BookRequest are not set in PUT")
	void requiredFieldsMissingPut() {
		//given
		final var validRequest = bookSystem.buildHuxley();
		final var postResponse = bookSystem.storeBook(validRequest);
		final var invalidRequest = bookSystem.buildInvalidBook();
		
		//when
		final var response = bookSystem.tryUpdatingBookByBookId(postResponse.bookId, invalidRequest);
		
		//then
		bookSystem.getVerifier().verifyClientError(response);
	}
	
	@Disabled("Returns successful, even though required attributes title, author and year in BookRequest are missing")
	@Test
	@DisplayName("If required fields for BookRequest are not set in PATCH")
	void requiredFieldsMissingPatch() {
		//given
		final var validRequest = bookSystem.buildHuxley();
		final var postResponse = bookSystem.storeBook(validRequest);
		final var invalidRequest = bookSystem.buildInvalidBook();
		
		//when
		final var response = bookSystem.tryPatchingBookByBookId(postResponse.bookId, invalidRequest);
		
		//then
		bookSystem.getVerifier().verifyClientError(response);
	}
	
}
