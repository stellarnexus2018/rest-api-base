package ru.master.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.master.restapi.entity.UserEntity;
import ru.master.restapi.exception.UserAlreadyExistsException;
import ru.master.restapi.exception.UserNotFoundException;
import ru.master.restapi.service.UserService;

/**
 * Контроллер для инфраструктуры "Пользователь"
 */
@RestController
@RequestMapping("/users")
public class UserController {
  // region Поля

  private final UserService userService;

  // endregion Поля

  // region Инициализация

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  // endregion Инициализация

  // region registerUser

  /**
   * Сохранение сущности "Пользователь" в БД
   * @param userEntity Сохраняемая сущность
   * @return Строка состояния выполнения процесса
   */
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

  // endregion registerUser

  // region getOneUser

  /**
   * Получение сущности "Пользователь" по идентификатору из БД
   * @param userId ID пользователя в БД
   * @return Объект состояния процесса получения целевой сущности
   */
  @GetMapping
  public ResponseEntity getOneUser(@RequestParam(name = "id") Long userId) {
    try {
      return ResponseEntity.ok(userService.getOneUser(userId));
    } catch (UserNotFoundException ex) {
      return ResponseEntity.badRequest().body(ex.getLocalizedMessage());
    } catch (Exception ex) {
      return ResponseEntity.badRequest().body("Что-то пошло не так...");
    }
  }

  // endregion getOneUser
}