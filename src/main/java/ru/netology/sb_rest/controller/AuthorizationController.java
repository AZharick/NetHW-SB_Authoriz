package ru.netology.sb_rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.sb_rest.exception.InvalidCredentials;
import ru.netology.sb_rest.exception.UnauthorizedUser;
import ru.netology.sb_rest.service.Authorities;
import ru.netology.sb_rest.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
   AuthorizationService service;

   public AuthorizationController(AuthorizationService service) {
      this.service = service;
   }

   @GetMapping("/authorize")
   public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
      return service.getAuthorities(user, password);
   }

   @GetMapping
   public String nginxTest() {
      return "Hello from 8080 app!";
   }

   //exception processing section ================
   @ExceptionHandler(InvalidCredentials.class)
   public ResponseEntity<String> icHandler(InvalidCredentials ic) {
      return new ResponseEntity<>(ic.getMessage(), HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(UnauthorizedUser.class)
   public ResponseEntity<String> uuHandler(UnauthorizedUser uu) {
      return new ResponseEntity<>(uu.getMessage(), HttpStatus.UNAUTHORIZED);
   }
}