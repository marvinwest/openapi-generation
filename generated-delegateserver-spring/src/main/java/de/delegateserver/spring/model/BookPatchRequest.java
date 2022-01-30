package de.delegateserver.spring.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * Request to update a book
 */
@ApiModel(description = "Request to update a book")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-30T14:19:44.509599900+01:00[Europe/Berlin]")
public class BookPatchRequest   {
  @JsonProperty("title")
  private String title;

  @JsonProperty("author")
  private String author;

  @JsonProperty("year")
  private Integer year;

  @JsonProperty("summary")
  private String summary;

  public BookPatchRequest title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Title of the book
   * @return title
  */
  @ApiModelProperty(value = "Title of the book")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BookPatchRequest author(String author) {
    this.author = author;
    return this;
  }

  /**
   * Name of the author of the book
   * @return author
  */
  @ApiModelProperty(value = "Name of the author of the book")


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public BookPatchRequest year(Integer year) {
    this.year = year;
    return this;
  }

  /**
   * The year the book was published
   * @return year
  */
  @ApiModelProperty(value = "The year the book was published")


  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public BookPatchRequest summary(String summary) {
    this.summary = summary;
    return this;
  }

  /**
   * Short summary of the book
   * @return summary
  */
  @ApiModelProperty(value = "Short summary of the book")


  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookPatchRequest bookPatchRequest = (BookPatchRequest) o;
    return Objects.equals(this.title, bookPatchRequest.title) &&
        Objects.equals(this.author, bookPatchRequest.author) &&
        Objects.equals(this.year, bookPatchRequest.year) &&
        Objects.equals(this.summary, bookPatchRequest.summary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, author, year, summary);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookPatchRequest {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
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

