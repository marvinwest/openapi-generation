/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package de.delegateserver.spring.resources;

import de.delegateserver.spring.model.BookList;
import de.delegateserver.spring.model.BookPatchRequest;
import de.delegateserver.spring.model.BookRequest;
import de.delegateserver.spring.model.BookResponse;
import java.util.UUID;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-31T20:35:57.697530700+01:00[Europe/Berlin]")
@Validated
@Api(value = "books", description = "the books API")
public interface BooksApi {

    default BooksApiDelegate getDelegate() {
        return new BooksApiDelegate() {};
    }

    /**
     * DELETE /books/{bookId} : Delete a book from the storage
     * Delete a book from the storage
     *
     * @param bookId UUID of the book (required)
     * @return no content (status code 204)
     *         or Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required (status code 400)
     */

    @ApiOperation(value = "Delete a book from the storage", nickname = "booksBookIdDelete", notes = "Delete a book from the storage", tags={ "Books", })
    @ApiResponses(value = { 

        @ApiResponse(code = 204, message = "no content"),

        @ApiResponse(code = 400, message = "Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required") })
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/books/{bookId}"
    )
    default ResponseEntity<Void> booksBookIdDelete(@ApiParam(value = "UUID of the book", required = true) @PathVariable("bookId") UUID bookId

) {
        return getDelegate().booksBookIdDelete(bookId);
    }


    /**
     * GET /books/{bookId} : Fetch a book by its bookId
     * Fetch a book by its bookId
     *
     * @param bookId UUID of the book (required)
     * @return OK (status code 200)
     *         or Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required (status code 400)
     */

    @ApiOperation(value = "Fetch a book by its bookId", nickname = "booksBookIdGet", notes = "Fetch a book by its bookId", response = BookResponse.class, tags={ "Books", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "OK", response = BookResponse.class),

        @ApiResponse(code = 400, message = "Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/books/{bookId}",
        produces = { "application/json" }
    )
    default ResponseEntity<BookResponse> booksBookIdGet(@ApiParam(value = "UUID of the book", required = true) @PathVariable("bookId") UUID bookId

) {
        return getDelegate().booksBookIdGet(bookId);
    }


    /**
     * PATCH /books/{bookId} : Update a stored book
     * Update a stored book
     *
     * @param bookId UUID of the book (required)
     * @param bookPatchRequest Book to be updated (optional)
     * @return No Content (status code 204)
     *         or Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required (status code 400)
     */

    @ApiOperation(value = "Update a stored book", nickname = "booksBookIdPatch", notes = "Update a stored book", tags={ "Books", })
    @ApiResponses(value = { 

        @ApiResponse(code = 204, message = "No Content"),

        @ApiResponse(code = 400, message = "Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required") })
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/books/{bookId}",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> booksBookIdPatch(@ApiParam(value = "UUID of the book", required = true) @PathVariable("bookId") UUID bookId

,

@ApiParam(value = "Book to be updated" )   @Valid @RequestBody(required = false) BookPatchRequest bookPatchRequest) {
        return getDelegate().booksBookIdPatch(bookId, bookPatchRequest);
    }


    /**
     * PUT /books/{bookId} : Add a new book or replace the book given at that resource
     * Add a new book or replace the book given at that resource
     *
     * @param bookId UUID of the book (required)
     * @param bookRequest Book to be updated (required)
     * @return No Content (status code 204)
     *         or Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required (status code 400)
     */

    @ApiOperation(value = "Add a new book or replace the book given at that resource", nickname = "booksBookIdPut", notes = "Add a new book or replace the book given at that resource", tags={ "Books", })
    @ApiResponses(value = { 

        @ApiResponse(code = 204, message = "No Content"),

        @ApiResponse(code = 400, message = "Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required") })
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/books/{bookId}",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> booksBookIdPut(@ApiParam(value = "UUID of the book", required = true) @PathVariable("bookId") UUID bookId

,

@ApiParam(value = "Book to be updated", required = true )   @Valid @RequestBody BookRequest bookRequest) {
        return getDelegate().booksBookIdPut(bookId, bookRequest);
    }


    /**
     * GET /books : Fetch a list of the books in your storage filtered by title, author or year
     * Find the information about the books in your storage, maybe filtered by title, author or year.
     *
     * @param title Title of the book (optional)
     * @param author Author of the book (optional)
     * @param year Year the book was published (optional)
     * @return OK (status code 200)
     *         or Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required (status code 400)
     */

    @ApiOperation(value = "Fetch a list of the books in your storage filtered by title, author or year", nickname = "booksGet", notes = "Find the information about the books in your storage, maybe filtered by title, author or year.", response = BookList.class, tags={ "Books", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "OK", response = BookList.class),

        @ApiResponse(code = 400, message = "Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/books",
        produces = { "application/json" }
    )
    default ResponseEntity<BookList> booksGet(@ApiParam(value = "Title of the book") @Valid @RequestParam(value = "title", required = false) Optional<String> title

,@ApiParam(value = "Author of the book") @Valid @RequestParam(value = "author", required = false) Optional<String> author

,@ApiParam(value = "Year the book was published") @Valid @RequestParam(value = "year", required = false) Optional<Integer> year

) {
        return getDelegate().booksGet(title, author, year);
    }


    /**
     * POST /books : Store a book
     * Add a book to your storage.
     *
     * @param bookRequest Book to be created (required)
     * @return created (status code 201)
     *         or Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required (status code 400)
     */

    @ApiOperation(value = "Store a book", nickname = "booksPost", notes = "Add a book to your storage.", response = BookResponse.class, tags={ "Books", })
    @ApiResponses(value = { 

        @ApiResponse(code = 201, message = "created", response = BookResponse.class),

        @ApiResponse(code = 400, message = "Bad Request: if the request cannot be processed due to a client error.    For example:    - invalid request syntax   - semantical error in request, like:     - invalid reference in request data (for instance bookId refers to a Book that does not exist)     - missing field that is required") })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/books",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<BookResponse> booksPost(

@ApiParam(value = "Book to be created", required = true )   @Valid @RequestBody BookRequest bookRequest) {
        return getDelegate().booksPost(bookRequest);
    }

}
