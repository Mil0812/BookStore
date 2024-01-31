package com.mil0812.bookstore.domain.fillingEntities;

import com.mil0812.bookstore.domain.CreateEntities;
import com.mil0812.bookstore.domain.entities.InventoryBook;
import com.mil0812.bookstore.domain.entities.Publication;
import com.mil0812.bookstore.domain.entities.User;
import java.util.List;


/**
 * Клас для створення списку записів інвентарної книги
 * {@link InventoryBook},
 * що наслідує інтерфейс {@link CreateEntities}.
 */
public class InventoryBookEntityFilling  implements CreateEntities<InventoryBook>{

  @Override
  public List<InventoryBook> createdObjects() {
    return List.of(
        //new InventoryBook()
        // TODO: list InventoryBook
    );
  }
}

