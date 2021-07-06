package ru.master.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.master.restapi.entity.UserEntity;
import ru.master.restapi.entity.UserTaskEntity;
import ru.master.restapi.exception.UserAlreadyExistsException;
import ru.master.restapi.exception.UserNotFoundException;
import ru.master.restapi.service.UserService;
import ru.master.restapi.service.UserTaskService;

@RestController
@RequestMapping(name = "/tasks")
public class UserTaskController {
  // region Поля

  private final UserTaskService userTaskService;

  // endregion Поля

  // region Инициализация

  @Autowired
  public UserTaskController(UserTaskService userTaskService) {
    this.userTaskService = userTaskService;
  }

  // endregion Инициализация

  // region addUserTask

  /**
   * Создание/Сохранение сущности "Задание" в БД
   * @param userTaskEntity Сохраняемая сущность
   * @param userId ID пользователя
   * @return Строка состояния выполнения процесса
   */
  @PostMapping
  public ResponseEntity<String> addUserTask(@RequestBody  UserTaskEntity userTaskEntity,
                                            @RequestParam Long           userId) {
    try {
      /*userTaskService.addUserTask(userTaskEntity);*/
      return ResponseEntity.ok("Задание добавлено");
    } /*catch (UserAlreadyExistsException ex) {
      return ResponseEntity.badRequest().body(ex.getLocalizedMessage());
    }*/ catch (Exception ex) {
      return ResponseEntity.badRequest().body("Что-то пошло не так...");
    }
  }

  // endregion addUserTask

  // region completeUserTask

  /**
   * Имитация выполнения задания
   * @param userTaskId ID задания
   * @return Объект состояния процесса
   */
  @GetMapping
  public ResponseEntity completeUserTask(@RequestParam(name = "id") Long userTaskId) {
    try {
      return ResponseEntity.ok(""/*userTaskService.getOneUser(userTaskId)*/);
    } /*catch (UserNotFoundException ex) {
      return ResponseEntity.badRequest().body(ex.getLocalizedMessage());
    }*/ catch (Exception ex) {
      return ResponseEntity.badRequest().body("Что-то пошло не так...");
    }
  }

  // endregion completeUserTask
}
