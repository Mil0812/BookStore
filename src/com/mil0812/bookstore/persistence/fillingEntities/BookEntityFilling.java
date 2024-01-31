package com.mil0812.bookstore.domain.fillingEntities;

import com.mil0812.bookstore.domain.CreateEntities;
import com.mil0812.bookstore.domain.entities.Book;
import com.mil0812.bookstore.domain.entities.User;
import java.util.List;

/**
 * Клас для створення списку книг {@link Book},
 * що наслідує інтерфейс {@link CreateEntities}.
 */
public class BookEntityFilling implements CreateEntities<Book> {

  @Override
  public List<Book> createdObjects() {
    return List.of(
        //new Book()
        ////////////
        //TODO: list of books
    );
  }
}