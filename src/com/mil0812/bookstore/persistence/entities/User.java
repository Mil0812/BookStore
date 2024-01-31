package com.mil0812.bookstore.domain.entities;

import com.mil0812.bookstore.domain.Entity;
import com.mil0812.bookstore.domain.workWithEntities.PasswordHashing;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * Клас-сутність "КОРИСТУВАЧ",
 * що наслідує "Сутність"
 */
public class User extends Entity {
  private String username;
  private final String password;
  private String email;
  private Boolean isAdmin;

  public User(String username, String password, String email) {
    super();
    this.username = username;
    this.password = PasswordHashing.getInstance().hashedPassword(password);
    this.email = email;
    this.isAdmin = false;
  }

  /**
   * Метод отримання унікального ідентифікатора {@link Entity#id}
   * @return "id"
   */
  public UUID getId() {
    return id;
  }

  //всі ґеттери
  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  public boolean isAdmin() {
    return isAdmin;
  }

  // сеттери для деяких полів
  public void setUsername(String username) {
    this.username = username;
  }

  public void setAdmin(Boolean admin) {
    this.isAdmin = admin;
  }

  // Перевіряє рівність об'єктів користувача за логіном, паролем,
  // електронною поштою та статусом адміністратора.
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(isAdmin, user.isAdmin) && Objects.equals(username, user.username)
        && Objects.equals(password, user.password) && Objects.equals(email,
        user.email);
  }

  //  Генерація хеш-коду об'єкта на основі логіна, пароля,
  //  електронної пошти та статусу
  //  адміністратора.
  @Override
  public int hashCode() {
    return Objects.hash(username, password, email, isAdmin);
  }
}
