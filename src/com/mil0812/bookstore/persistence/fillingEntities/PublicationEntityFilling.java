package com.mil0812.bookstore.domain.fillingEntities;

import com.mil0812.bookstore.domain.CreateEntities;
import com.mil0812.bookstore.domain.entities.Publication;
import com.mil0812.bookstore.domain.entities.User;
import java.util.List;

/**
 * Клас для створення списку видавництв {@link Publication},
 * що наслідує інтерфейс {@link CreateEntities}.
 */
public class PublicationEntityFilling implements CreateEntities<Publication> {

  @Override
  public List<Publication> createdObjects() {
    return List.of(
        new Publication("А-БА-БА-ГА-ЛА-МА-ГА"));
        ////////////
        //TODO: list Publication

  }
}
