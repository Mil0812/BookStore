package com.mil0812.bookstore.domain.entities;

import com.mil0812.bookstore.domain.Entity;
import java.util.UUID;

/**
 * Клас-сутність "ЖАНР",
 * що наслідує "Сутність"
 */
public class Genre extends Entity {
  private String genreName;
  private String genreDescription;

  public Genre(String genreName, String genreDescription) {
    super();
    this.genreName = genreName;
    this.genreDescription = genreDescription;
  }

  /**
   * Метод отримання унікального ідентифікатора {@link Entity#id}
   * @return "id"
   */
  public UUID getId() {
    return id;
  }

  public String getGenreName() {
    return genreName;
  }

  public String getGenreDescription() {
    return genreDescription;
  }

  @Override
  public String toString() {
    return "Жанр{" +
        "назва: '" + genreName + '\'' +
        ", опис: '" + genreDescription + '\'' +
        '}';
  }
}
