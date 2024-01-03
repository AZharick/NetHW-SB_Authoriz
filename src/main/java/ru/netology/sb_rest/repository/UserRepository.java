package ru.netology.sb_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.sb_rest.service.Authorities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
   private static ConcurrentHashMap<String, String> usersPasswords = new ConcurrentHashMap<>();

   public UserRepository() {
   }

   public List<Authorities> getUserAuthorities(String user, String password) {
      usersPasswords.put("Alex", "1234"); // test data

      if (usersPasswords.containsKey(user) && usersPasswords.get(user).equals(password)) {
         return Arrays.asList(Authorities.values());
      } else {
         return new ArrayList<>(0);
      }
   }

}