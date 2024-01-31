package com.mil0812.bookstore.domain.workWithEntities;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Хешування паролю за допомогою алгоритму BCrypt
 */
public class PasswordHashing {
  private static PasswordHashing passwordHashing;

  private PasswordHashing() {
  }

  // метод для отримання єдиного екземпляра класу
  public static synchronized PasswordHashing getInstance() {
    if (passwordHashing == null) {
      passwordHashing = new PasswordHashing();
    }
    return passwordHashing;
  }

  // хешування вхідного паролю алгоритмом BCrypt
  public String hashedPassword(String password) {
    return BCrypt.hashpw(password, BCrypt.gensalt());
  }

}
