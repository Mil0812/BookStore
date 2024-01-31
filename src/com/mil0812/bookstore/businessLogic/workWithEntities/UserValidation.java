package com.mil0812.bookstore.domain.workWithEntities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Клас, де відбувається безпосередньо
 * перевірка та валідація
 * введених користувачем даних
 */
public class UserValidation {
  private static UserValidation userValidation;
  private List<String> userErrors;

  private UserValidation(){}

  // метод для отримання єдиного екземпляра класу
  public static synchronized UserValidation getInstance() {
    if (userValidation == null) {
      userValidation = new UserValidation();
    }
    return userValidation;
  }

  // отримання списку помилок користувача
  public List<String> getUserErrors(String username, String password, String email) {
    userErrors = new ArrayList<>();
    if (doesUsernameExist(username)) {
      userErrors.add(ErrorTemplates.LOGIN_EXIST.getTemplate());
    } else {
      validateUsername(username);
    }
    validatePassword(password);
    validateEmail(email);
    return userErrors;
  }

  private boolean doesUsernameExist(String username) {
    return UserRepository.getInstance().getAllObjects().stream()
        .anyMatch(user -> user.getUsername().equals(username));
  }

  /**
   * Валідація логіну
   * <p>
   * Цей метод встановлює ім’я користувача з указаними критеріями перевірки:
   * - не має бути порожнім;
   * - має містити більше ніж 3 символи;
   * - має містити менше ніж 24 символів;
   * - має складатися тільки з латинських літер.
   *
   * @param username логін користувача, що має відповідати вказаним вище критеріям
   */
  private void validateUsername(String username){
    final String templateName = "логін";

    if (username.isBlank()) {
      userErrors.add(ErrorTemplates.REQUIRED.getTemplate().formatted(templateName));
    }
    if (username.length() < 3) {
      userErrors.add(ErrorTemplates.MIN_LENGTH.getTemplate().formatted(templateName, 3));
    }
    if (username.length() > 21) {
      userErrors.add(ErrorTemplates.MAX_LENGTH.getTemplate().formatted(templateName, 24));
    }
    var pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
    if (!pattern.matcher(username).matches()) {
      userErrors.add(ErrorTemplates.ONLY_LATIN.getTemplate().formatted(templateName));
    }
  }

  /**
   *    Валідація паролю
   *    * <p>
   *    * Цей метод повертає пароль з указаними критеріями перевірки:
   *    * - не має бути порожнім;
   *    * - має містити не менше 4 символів;
   *    * - не має містити менше 24 символів;
   *    * - має складатися тільки з латинських літер +
   *    хоча б одну буква з великої, одну з малої та хоча б одну цифру
   *    *
   *
   * @param password "пароль, який відповідає всім критеріям"
   */
  private void validatePassword(String password) {
    final String templateName = "пароль";

    if (password.isBlank()) {
      userErrors.add(ErrorTemplates.REQUIRED.getTemplate().formatted(templateName));
    }
    if (password.length() < 8) {
      userErrors.add(ErrorTemplates.MIN_LENGTH.getTemplate().formatted(templateName, 4));
    }
    if (password.length() > 32) {
      userErrors.add(ErrorTemplates.MAX_LENGTH.getTemplate().formatted(templateName, 24));
    }
    var pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$");
    if (pattern.matcher(password).matches()) {
      userErrors.add(ErrorTemplates.PASSWORD.getTemplate().formatted(templateName, 24));
    }
  }
  /**
   * Валідація емейлу
   * <p>
   * Цей метод встановлює емейл користувача з указаними критеріями перевірки:
   * - поле не є пустим
   * - наявний символ «@»
   * - наявне ім'я домену
   * - найвне ім'я домену верхнього рівня з необов’язковими субдоменами
   * @param email "введений користувачем емейл"
   */

  private void validateEmail(String email) {

    final String templateName = "email@gmail.com";

    if (email.isBlank()) {
      userErrors.add(ErrorTemplates.REQUIRED.getTemplate().formatted(templateName));
    }

    var emailPattern = Pattern.compile
        ("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    if (!emailPattern.matcher(email).matches()) {
      userErrors.add(ErrorTemplates.EMAIL.getTemplate().formatted(templateName));
    }
  }
}