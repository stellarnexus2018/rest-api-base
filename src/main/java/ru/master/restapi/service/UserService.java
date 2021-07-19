package ru.master.restapi.service;

import ru.master.restapi.dto.UserDto;
import ru.master.restapi.entity.UserEntity;
import ru.master.restapi.exception.UserAlreadyExistsException;
import ru.master.restapi.exception.UserNotFoundException;

/**
 * Подсистема для работы с бизнес и системной логикой сущности "Пользователь"
 */
public interface UserService {
  UserEntity registerUser(UserEntity userEntity) throws UserAlreadyExistsException;
  UserDto getOneUser(Long userId) throws UserNotFoundException;
}