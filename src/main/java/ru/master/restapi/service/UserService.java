package ru.master.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.master.restapi.dto.UserDto;
import ru.master.restapi.entity.UserEntity;
import ru.master.restapi.exception.UserAlreadyExistsException;
import ru.master.restapi.exception.UserNotFoundException;
import ru.master.restapi.repository.UserRepository;

@Service
public class UserService {
  UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserEntity registerUser(UserEntity userEntity) throws UserAlreadyExistsException {
    if (userRepository.findByFirstNameAndAndSecondNameAndPatronymic(userEntity.getFirstName(), userEntity.getSecondName(), userEntity.getPatronymic()) != null) {
      throw new UserAlreadyExistsException("Такой пользователь уже существует");
    }
    return userRepository.save(userEntity);
  }

  public UserDto getOneUser(Long userId) throws UserNotFoundException {
    UserEntity userEntity = userRepository.findById(userId).orElse(null);
    if (userEntity == null) {
      throw new UserNotFoundException("Пользователь не найден");
    }
    return UserDto.toDto(userEntity);
  }

}
