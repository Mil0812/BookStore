package com.mil0812.bookstore.businessLogic;

import java.util.List;

/**
 * Інтерфейс, що дозволяє створити список об'єктів типу,
 * що схований в дженеріку
 * @param <T> "тип створених у класах-нащадках об'єктів"
 */
public interface CreateEntities<T> {
  public List<T> createdObjects();

}
