package ru.master.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.master.restapi.dto.UserDto;
import ru.master.restapi.entity.UserEntity;
import ru.master.restapi.exception.UserAlreadyExistsException;
import ru.master.restapi.exception.UserNotFoundException;
import ru.master.restapi.repository.UserRepository;

/**
 * Подсистема для работы с бизнес и системной логикой сущности "Пользователь"
 */
@Service
public class UserService {
  // region Поля

  UserRepository userRepository;

  // endregion Поля

  // region Инициализация

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  // endregion Инициализация

  // region registerUser

  /**
   * Сохранение сущности "Пользователь"
   * @param userEntity Сущность "Пользователь" на сохранение
   * @return Сохранённая сущность
   * @throws UserAlreadyExistsException
   */
  public UserEntity registerUser(UserEntity userEntity) throws UserAlreadyExistsException {
    if (userRepository.findByFirstNameAndLastNameAndPatronymic(userEntity.getFirstName(), userEntity.getLastName(), userEntity.getPatronymic()) != null) {
      throw new UserAlreadyExistsException("Такой пользователь уже существует");
    }
    return userRepository.save(userEntity);
  }

  // endregion registerUser

  // region getOneUser

  /**
   * Получение сущности "Пользователь" по идентификатору в БД
   * @param userId ID пользователя в БД
   * @return Сущность "Пользователь"
   * @throws UserNotFoundException
   */
  public UserDto getOneUser(Long userId) throws UserNotFoundException {
    UserEntity userEntity = userRepository.findById(userId).orElse(null);
    if (userEntity == null) {
      throw new UserNotFoundException("Пользователь не найден");
    }
    return UserDto.toDto(userEntity);
  }

  // endregion getOneUser
}