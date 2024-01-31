package com.mil0812.bookstore.domain.fillingEntities;

import com.mil0812.bookstore.domain.CreateEntities;
import com.mil0812.bookstore.domain.entities.Genre;
import java.util.List;

/**
 * Клас для створення списку жанрів книг
 * {@link Genre},
 * що наслідує інтерфейс {@link CreateEntities}.
 */
public class GenreEntityFilling implements CreateEntities<Genre>{

  @Override
  public List<Genre> createdObjects() {
    return List.of(
        //new Genre() ///////////////
    ); //TODO: list Genres
  }
}