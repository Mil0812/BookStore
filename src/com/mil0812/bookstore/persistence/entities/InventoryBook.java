package com.mil0812.bookstore.domain.entities;

import com.mil0812.bookstore.domain.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

/**
 * Клас-сутність "ІНВЕНТАРНА КНИГА",
 * що наслідує "Сутність"
 * і яка зберігає в собі загальні відомості
 * про книги в книгарні
 */
public class InventoryBook extends Entity {
  private Book book;

  //кількість примірників
  private int numberOfBookCopies;
  public double totalCost;

  //дата надходження
  private String dateOfReceipt;

  //джерело надходження
  private String sourceOfReceipt;

  public InventoryBook(Book book, int numberOfBookCopies, String sourceOfReceipt) {
    super();
    this.book = book;
    this.numberOfBookCopies = numberOfBookCopies;
    setTotalCost();
    dateOfReceipt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    this.sourceOfReceipt = sourceOfReceipt;
  }

  /**
   * Метод отримання унікального ідентифікатора {@link Entity#id}
   * @return "id"
   */
  public UUID getId() {
    return id;
  }

  public Book getBook() {
    return book;
  }

  public int getNumberOfBookCopies() {
    return numberOfBookCopies;
  }

  public double getTotalCost() {
    return totalCost;
  }

  public String getDateOfReceipt() {
    return dateOfReceipt;
  }

  public String getSourceOfReceipt() {
    return sourceOfReceipt;
  }

  // метод, що встановлює ціну партії книг,
  // відповідно до ціни однієї книги
  // та їх загальної кількості
  public void setTotalCost(){
    double singleBooksPrice = book.getPrice();
    totalCost = singleBooksPrice * numberOfBookCopies;
  }

  @Override
  public String toString() {
    return "Інвентарна книга{" +
        "книга: " + book +
        ", id: " + id +
        ", кількість книг: " + numberOfBookCopies +
        ", дата надходження: " + dateOfReceipt +
        ", джерело надходження(видавництво): '" + sourceOfReceipt + '\'' +
        ", загальна сума: " + totalCost +
        '}';
  }
}
