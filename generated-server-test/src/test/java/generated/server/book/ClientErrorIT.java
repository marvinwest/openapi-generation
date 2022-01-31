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
	
	@Disabled("Returns SUCCESSFUL for delegate server and CLIENT_ERROR for simple server,even though required attributes title, author and year in BookRequest are missing")
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
	@DisplayName("If required fields for BookRequest are not set in PUT (only for delegate server, given is not implemented in simple server)")
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
	
	@Test
	@DisplayName("If BookRequest is null in PUT (only for delegate server, given is not implemented in simple server)")
	void bookRequestIsNullInPut() {
		//given
		final var validRequest = bookSystem.buildHuxley();
		final var postResponse = bookSystem.storeBook(validRequest);
		
		//when
		final var response = bookSystem.tryUpdatingBookByBookId(postResponse.bookId, null);
		
		//then
		bookSystem.getVerifier().verifyClientError(response);
	}
	
	@Test
	@DisplayName("If BookRequest is null in POST")
	void bookRequestIsNullInPost() {	
		//when
		final var response = bookSystem.tryStoringBook(null);
		
		//then
		bookSystem.getVerifier().verifyClientError(response);
	}
	
}
