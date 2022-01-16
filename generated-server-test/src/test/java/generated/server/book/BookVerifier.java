package generated.server.book;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;

public class BookVerifier {

	public void assertBookInformationInBookInformationList(BookInformation info, BookInformationList infoList) {
		List<BookInformation> filteredList = infoList.data.stream()
			.filter(b -> b.bookId.equals(info.bookId))
			.collect(Collectors.toList());
		Assertions.assertEquals(1, filteredList.size());
	}
	
	public void booksAreEqual(Book expected, Book found) {
		Assertions.assertAll("Two Books are Equal",
				() -> Assertions.assertEquals(expected.title,  found.title),
				() -> Assertions.assertEquals(expected.author, found.author),
				() -> Assertions.assertEquals(expected.year, found.year)
				);
	}
}
