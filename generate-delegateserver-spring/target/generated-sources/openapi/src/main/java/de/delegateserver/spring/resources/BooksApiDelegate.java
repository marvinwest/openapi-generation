package de.delegateserver.spring.resources;

import de.delegateserver.spring.model.Book;
import de.delegateserver.spring.model.BookInformation;
import de.delegateserver.spring.model.BookInformationList;
import java.util.UUID;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link BooksApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-16T16:03:53.688844200+01:00[Europe/Berlin]")
public interface BooksApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /books/{bookId} : Delete a book from the storage
     * Delete a book from the storage
     *
     * @param bookId UUID of the book (required)
     * @return no content (status code 204)
     *         or Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required (status code 400)
     * @see BooksApi#booksBookIdDelete
     */
    default ResponseEntity<Void> booksBookIdDelete(UUID bookId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /books/{bookId} : Fetch a book by its bookId
     * Fetch a book by its bookId
     *
     * @param bookId UUID of the book (required)
     * @return OK (status code 200)
     *         or Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required (status code 400)
     * @see BooksApi#booksBookIdGet
     */
    default ResponseEntity<Book> booksBookIdGet(UUID bookId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"year\" : 0, \"author\" : \"author\", \"title\" : \"title\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /books : Fetch a list of information about the books in your storage
     * Find the information about the books in your storage, maybe filtered by title, author or year.
     *
     * @param title Title of the book (optional)
     * @param author Author of the book (optional)
     * @param year Year the book was published (optional)
     * @return OK (status code 200)
     *         or Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required (status code 400)
     * @see BooksApi#booksGet
     */
    default ResponseEntity<BookInformationList> booksGet(String title,
        String author,
        Integer year) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data\" : [ { \"title\" : \"title\", \"bookId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"title\" : \"title\", \"bookId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /books : Add a book to your storage
     * Add a book to your storage.
     *
     * @param book empty for now (optional)
     * @return created (status code 201)
     *         or Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required (status code 400)
     * @see BooksApi#booksPost
     */
    default ResponseEntity<BookInformation> booksPost(Book book) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"title\" : \"title\", \"bookId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
