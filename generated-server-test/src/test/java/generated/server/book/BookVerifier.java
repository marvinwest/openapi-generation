package generated.server.book;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;

public class BookVerifier {

	public void assertBookIsInBookList(BookResponse book, BookList bookList) {
		List<BookResponse> filteredList = bookList.data.stream()
			.filter(b -> b.bookId.equals(book.bookId))
			.collect(Collectors.toList());
		Assertions.assertEquals(1, filteredList.size());
	}
	
	public void assertBookIsNotInBookList(BookResponse book, BookList books) {
		List<BookResponse> filteredList = books.data.stream()
			.filter(b -> b.bookId.equals(book.bookId))
			.collect(Collectors.toList());
		Assertions.assertEquals(0, filteredList.size());
	}
	
	public void booksAreEqual(BookRequest expected, BookResponse found) {
		Assertions.assertAll("Two Books are Equal",
				() -> Assertions.assertEquals(expected.title,  found.title),
				() -> Assertions.assertEquals(expected.author, found.author),
				() -> Assertions.assertEquals(expected.year, found.year),
				() -> Assertions.assertEquals(expected.summary, found.summary)
				);
	}
}
