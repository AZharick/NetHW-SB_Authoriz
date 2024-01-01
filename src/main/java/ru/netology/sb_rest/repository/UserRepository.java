package ru.netology.sb_rest.repository;

import ru.netology.sb_rest.Authorities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UserRepository {
   private static HashMap<String, String> usersPasswords = new HashMap<>();

   public List<Authorities> getUserAuthorities(String user, String password) {
      usersPasswords.put("Alex", "1234"); // test data

      if (usersPasswords.containsKey(user) && usersPasswords.get(user).equals(password)) {
         return Arrays.asList(Authorities.values());
      } else {
         return new ArrayList<>(0);
      }
   }

}