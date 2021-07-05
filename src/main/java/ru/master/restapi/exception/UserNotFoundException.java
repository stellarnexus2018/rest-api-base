package ru.master.restapi.exception;

public class UserNotFoundException extends Exception {
  public UserNotFoundException(String message) {
    super(message);
  }
}
