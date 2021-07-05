package ru.master.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.master.restapi.dto.UserDto;
import ru.master.restapi.entity.UserEntity;
import ru.master.restapi.exception.UserAlreadyExistsException;
import ru.master.restapi.exception.UserNotFoundException;
import ru.master.restapi.repository.UserRepository;
import ru.master.restapi.service.UserService;

/**
 * Контроллер для инфраструктуры "Пользователь"
 */
@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<String> registerUser(@RequestBody UserEntity userEntity) {
    try {
      userService.registerUser(userEntity);
      return ResponseEntity.ok("Пользователь сохранён");
    } catch (UserAlreadyExistsException ex) {
      return ResponseEntity.badRequest().body(ex.getLocalizedMessage());
    } catch (Exception ex) {
      return ResponseEntity.badRequest().body("Что-то пошло не так...");
    }
  }

  @GetMapping
  public ResponseEntity getOneUser(@RequestParam Long id) {
    try {
      return ResponseEntity.ok(userService.getOneUser(id));
    } catch (UserNotFoundException ex) {
      return ResponseEntity.badRequest().body(ex.getLocalizedMessage());
    } catch (Exception ex) {
      return ResponseEntity.badRequest().body("Что-то пошло не так...");
    }
  }
}