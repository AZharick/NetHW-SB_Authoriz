package ru.netology.sb_rest.service;

import ru.netology.sb_rest.Authorities;
import ru.netology.sb_rest.exception.InvalidCredentials;
import ru.netology.sb_rest.exception.UnauthorizedUser;
import ru.netology.sb_rest.repository.UserRepository;
import java.util.List;

public class AuthorizationService {
   UserRepository userRepository;

   // made this public
   public List<Authorities> getAuthorities(String user, String password) {
      if (isEmpty(user) || isEmpty(password)) {
         throw new InvalidCredentials("User name or password is empty");
      }
      List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
      if (isEmpty(userAuthorities)) {
         throw new UnauthorizedUser("Unknown user " + user);
      }
      return userAuthorities;
   }

   private boolean isEmpty(String str) {
      return str == null || str.isEmpty();
   }
   private boolean isEmpty(List<?> str) {
      return str == null || str.isEmpty();
   }
}