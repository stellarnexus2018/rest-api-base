package ru.master.restapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для инфраструктуры "Пользователь"
 */
@RestController
@RequestMapping("/users")
public class UserController {
  @GetMapping
  public ResponseEntity getUsers() {
    try {
      return ResponseEntity.ok("Всё отлично работает!");
    } catch (Exception ex) {
      return ResponseEntity.badRequest().body("Что-то пошло не так...");
    }
  }
}