package ru.master.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import ru.master.restapi.entity.UserEntity;

/**
 *  Репозиторий для сущности "Пользователь"
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {
  UserEntity findByFirstNameAndAndSecondNameAndPatronymic(String firstName, String secondName, String patronymic);


}