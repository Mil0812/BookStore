package com.mil0812.bookstore.domain.entities;

import com.mil0812.bookstore.domain.Entity;
import java.util.Date;
import java.util.UUID;

/**
 * Клас-сутність "АВТОР",
 * що наслідує "Сутність"
 */
public class Author extends Entity{
  private final String authorsName;
  private final String authorsSurname;
  private String authorsNationality;
  private Date authorsBirthday;
  private Publication publication;

  public Author(String authorsName, String authorsSurname, String authorsNationality,
      Date authorsBirthday, Publication publication) {
    super();
    this.authorsName = authorsName;
    this.authorsSurname = authorsSurname;
    this.authorsNationality = authorsNationality;
    this.authorsBirthday = authorsBirthday;
    this.publication = publication;
  }

  /**
   * Метод отримання унікального ідентифікатора {@link Entity#id}
   * @return "id"
   */
  public UUID getId() {
    return id;
  }

  public String getAuthorsName() {
    return authorsName;
  }

  public String getAuthorsSurname() {
    return authorsSurname;
  }

  public String getAuthorsNationality() {
    return authorsNationality;
  }

  public Date getAuthorsBirthday() {
    return authorsBirthday;
  }

  public Publication getPublication() {
    return publication;
  }

  @Override
  public String toString() {
    return "Автор{" +
        "ім'я:'" + authorsName + '\'' +
        ", прізвище: '" + authorsSurname + '\'' +
        ", національність: '" + authorsNationality + '\'' +
        ", дата народження: " + authorsBirthday +
        ", видання, в якому видає свої книги: " + publication +
        ", id=" + id +
        '}';
  }
}
