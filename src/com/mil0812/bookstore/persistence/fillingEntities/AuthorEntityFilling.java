package com.mil0812.bookstore.domain.fillingEntities;

import com.mil0812.bookstore.domain.CreateEntities;
import com.mil0812.bookstore.domain.entities.Author;
import com.mil0812.bookstore.domain.entities.Book;
import java.util.List;

/**
 * Клас для створення списку авторів книг {@link Author},
 * що наслідує інтерфейс {@link CreateEntities}.
 */
public class AuthorEntityFilling implements CreateEntities<Author> {

  @Override
  public List<Author> createdObjects() {
    return
        List.of(
          //  new Author()
            ////////////
            //TODO: list of authors
        );
  }
}
