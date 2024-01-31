package com.mil0812.bookstore.businessLogic;

import java.util.UUID;

/**
 * Абстрактний клас сутностей,
 * що генерує унікальний ідентифікатор
 */
public abstract class Entity {
  protected final UUID id;

  protected Entity() {
    this.id = UUID.randomUUID();
  }

}
