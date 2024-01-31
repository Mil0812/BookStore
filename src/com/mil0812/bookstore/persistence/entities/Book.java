package com.mil0812.bookstore.domain.entities;

import com.mil0812.bookstore.domain.Entity;
import java.util.UUID;

/**
 * Клас-сутність "КНИГА",
 * що наслідує "Сутність"
 */
public class Book extends Entity {
  private final String bookTitle;
  private Author author;
  private Genre genre;
  private double price;
  private int pagesCount;

  public Book(String bookTitle, Author author, Genre genre, double price, int pagesCount) {
    super();
    this.bookTitle = bookTitle;
    this.author = author;
    this.genre = genre;
    this.price = price;
    this.pagesCount = pagesCount;
  }

  /**
   * Метод отримання унікального ідентифікатора {@link Entity#id}
   * @return "id"
   */
  public UUID getId() {
    return id;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public Author getAuthor() {
    return author;
  }

  public Genre getGenre() {
    return genre;
  }

  public double getPrice() {
    return price;
  }

  public int getPagesCount() {
    return pagesCount;
  }

  @Override
  public String toString() {
    return "Книга{" +
        "Назва:'" + bookTitle + '\'' +
        ", автор:" + author +
        ", жанр:" + genre +
        ", кількість сторінок: " + pagesCount +
        ", ціна: " + price + " грн." +
        ", id: " + id +
        '}';
  }
}
