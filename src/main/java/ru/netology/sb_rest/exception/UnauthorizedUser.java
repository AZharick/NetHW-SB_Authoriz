package ru.netology.sb_rest.exception;

public class UnauthorizedUser extends RuntimeException {
   public UnauthorizedUser(String msg) {
      super(msg);
   }
}