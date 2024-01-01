package ru.netology.sb_rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.sb_rest.Authorities;
import ru.netology.sb_rest.service.AuthorizationService;
import java.util.List;

@RestController
public class AuthorizationController {
   AuthorizationService service;

   @GetMapping("/authorize")
   public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
      return service.getAuthorities(user, password);
   }
}