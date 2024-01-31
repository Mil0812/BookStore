package com.mil0812.bookstore.domain.workWithEntities;

import com.mil0812.bookstore.domain.entities.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що перевіряє правильність введення всіх даних користувача
 */
public class UserChecking {
  private static UserChecking userChecking;
  private List<String> userErrors;

  private UserChecking(){}

  // метод для отримання єдиного екземпляра класу
  public static synchronized UserChecking getInstance() {
    if (userChecking == null) {
      userChecking = new UserChecking();
    }
    return userChecking;
  }

  // отримання списку помилок користувача
  public List<String> getUserErrors(String username, String password) {
    userErrors = new ArrayList<>();
    if (usernameAndPasswordAreValid(username, password)) {
      return userErrors;
    }
    User authUser = UserRepository.getInstance().getAllObjects().stream()
        .filter(user -> user.geUsername().equals(username)).findFirst().orElse(null);
if(authUser != null){
  if (authUser.getPassword()
      .equals(PasswordHashing.getInstance().hashedPassword(password))) {
    return userErrors;
  }
  userErrors.add(ErrorTemplates.WRONG_VALUE.getTemplate().formatted("пароль"));
} else {
  userErrors.add(ErrorTemplates.USER_NOT_EXIST.getTemplate());
}
    return userErrors;
  }

  //перевірка, чи логін та пароль валідні
  public boolean usernameAndPasswordAreValid(String username, String password) {
    if (username.isBlank()) {
      userErrors.add(ErrorTemplates.EMPTY_STRING.getTemplate().formatted("логін"));
    }
    if (password.isBlank()) {
      userErrors.add(ErrorTemplates.EMPTY_STRING.getTemplate().formatted("пароль"));
    }
    return userErrors.isEmpty();
  }
}
