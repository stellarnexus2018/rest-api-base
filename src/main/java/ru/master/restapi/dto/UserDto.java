package ru.master.restapi.dto;

import lombok.*;
import ru.master.restapi.entity.UserEntity;

/**
 * DTO для представления "Пользователь"
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {
  private Long    id;
  private String  firstName;
  private String  lastName;
  private String  patronymic;
  private String  login;
  private Integer age;
  private Integer status;

  public static UserDto toDto(UserEntity userEntity) {
    return UserDto.builder()
        .id(userEntity.getId())
        .firstName(userEntity.getFirstName())
        .lastName(userEntity.getLastName())
        .patronymic(userEntity.getPatronymic())
        .login(userEntity.getLogin())
        .age(userEntity.getAge())
        .status(userEntity.getStatus())
        .build();
  }
}