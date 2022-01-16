package de.delegateserver.spring.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * Simplified information for finding books in your storage
 */
@ApiModel(description = "Simplified information for finding books in your storage")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-16T16:49:36.702674800+01:00[Europe/Berlin]")
public class BookInformation   {
  @JsonProperty("bookId")
  private UUID bookId;

  @JsonProperty("title")
  private String title;

  public BookInformation bookId(UUID bookId) {
    this.bookId = bookId;
    return this;
  }

  /**
   * The UUID of the book in your storage
   * @return bookId
  */
  @ApiModelProperty(required = true, value = "The UUID of the book in your storage")
  @NotNull

  @Valid

  public UUID getBookId() {
    return bookId;
  }

  public void setBookId(UUID bookId) {
    this.bookId = bookId;
  }

  public BookInformation title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Title of the book
   * @return title
  */
  @ApiModelProperty(required = true, value = "Title of the book")
  @NotNull


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookInformation bookInformation = (BookInformation) o;
    return Objects.equals(this.bookId, bookInformation.bookId) &&
        Objects.equals(this.title, bookInformation.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookId, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookInformation {\n");
    
    sb.append("    bookId: ").append(toIndentedString(bookId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

