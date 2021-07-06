package ru.master.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.master.restapi.entity.UserEntity;
import ru.master.restapi.entity.UserTaskEntity;
import ru.master.restapi.exception.UserAlreadyExistsException;
import ru.master.restapi.exception.UserNotFoundException;
import ru.master.restapi.exception.UserTaskNotFoundException;
import ru.master.restapi.repository.UserRepository;
import ru.master.restapi.repository.UserTaskRepository;

@Service
public class UserTaskService {
  private final UserRepository userRepository;
  private final UserTaskRepository userTaskRepository;

  @Autowired
  public UserTaskService(UserRepository userRepository, UserTaskRepository userTaskRepository) {
    this.userRepository = userRepository;
    this.userTaskRepository = userTaskRepository;
  }

  public UserTaskEntity addUserTask(UserTaskEntity userTaskEntity, Long userId) throws UserNotFoundException {
    UserEntity userEntity = userRepository.findById(userId).orElse(null);

    if (userEntity == null) {
      throw new UserNotFoundException("Не найден пользователь");
    }

    userTaskEntity.setUsr(userEntity);
    return userTaskRepository.save(userTaskEntity);
  }


  public UserTaskEntity completeUserTask(Long userTaskId) throws UserTaskNotFoundException {
    UserTaskEntity userTaskEntity = userTaskRepository.findById(userTaskId).orElse(null);

    if (userTaskEntity == null) {
      throw new UserTaskNotFoundException("Не найдено задание");
    }

    userTaskEntity.setTaskCompleted(!userTaskEntity.getTaskCompleted());
    return userTaskRepository.save(userTaskEntity);
  }


}