package com.mil0812.bookstore.domain.fillingEntities;

import com.mil0812.bookstore.domain.CreateEntities;
import com.mil0812.bookstore.domain.entities.User;
import java.util.List;

/**
 * Клас для створення списку користувачів {@link User},
 * що наслідує інтерфейс {@link CreateEntities}.
 */
public class UserEntityFilling implements CreateEntities<User> {


  @Override
  public List<User> createdObjects() {
    return
        List.of(
            new User("mila", "programmer", "kulak.rylut@gmail.com")
            ////////////
            //TODO: list of users
        );
  }
}
