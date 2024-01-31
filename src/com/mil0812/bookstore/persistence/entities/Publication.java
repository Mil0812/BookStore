package com.mil0812.bookstore.domain.entities;

import com.mil0812.bookstore.domain.Entity;
import java.util.UUID;

/**
 * Клас-сутність "ВИДАВНИЦТВО",
 * що наслідує "Сутність"
 */
public class Publication extends Entity {
  private final String publicationName;

  public Publication(String publicationName) {
    super();
    this.publicationName = publicationName;
  }
  /**
   * Метод отримання унікального ідентифікатора {@link Entity#id}
   * @return "id"
   */
  public UUID getId() {
    return id;
  }

  public String getPublicationName() {
    return publicationName;
  }

  @Override
  public String toString() {
    return "Видавництво: '" +
        publicationName + '\'';
  }
}
