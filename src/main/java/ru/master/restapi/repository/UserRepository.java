package ru.master.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.master.restapi.entity.UserEntity;

/**
 *  Репозиторий для сущности "Пользователь"
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findByFirstNameAndLastNameAndPatronymic(String firstName, String lastName, String patronymic);
}