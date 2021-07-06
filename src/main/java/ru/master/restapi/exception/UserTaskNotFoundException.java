package ru.master.restapi.exception;

public class UserTaskNotFoundException extends Exception {
  public UserTaskNotFoundException(String message) {
    super(message);
  }
}