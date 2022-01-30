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
 * Request object of the book
 */
@ApiModel(description = "Request object of the book")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-30T14:19:44.509599900+01:00[Europe/Berlin]")
public class BookRequest   {
  @JsonProperty("title")
  private String title;

  @JsonProperty("author")
  private String author;

  @JsonProperty("year")
  private Integer year;

  @JsonProperty("summary")
  private String summary;

  public BookRequest title(String title) {
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

  public BookRequest author(String author) {
    this.author = author;
    return this;
  }

  /**
   * Name of the author of the book
   * @return author
  */
  @ApiModelProperty(required = true, value = "Name of the author of the book")
  @NotNull


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public BookRequest year(Integer year) {
    this.year = year;
    return this;
  }

  /**
   * The year the book was published
   * @return year
  */
  @ApiModelProperty(required = true, value = "The year the book was published")
  @NotNull


  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public BookRequest summary(String summary) {
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
    BookRequest bookRequest = (BookRequest) o;
    return Objects.equals(this.title, bookRequest.title) &&
        Objects.equals(this.author, bookRequest.author) &&
        Objects.equals(this.year, bookRequest.year) &&
        Objects.equals(this.summary, bookRequest.summary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, author, year, summary);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookRequest {\n");
    
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

