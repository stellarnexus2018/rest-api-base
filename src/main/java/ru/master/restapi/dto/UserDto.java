package ru.master.restapi.dto;

import lombok.*;
import ru.master.restapi.entity.UserEntity;

/**
 * DTO для представления "Пользователь"
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserDto {
  private Long    id;
  private String  firstName;
  private String  secondName;
  private String  patronymic;
  private String  login;
  private Integer age;

  public static UserDto toDto(UserEntity userEntity) {
    return UserDto.builder()
        .id(userEntity.getId())
        .firstName(userEntity.getFirstName())
        .secondName(userEntity.getSecondName())
        .patronymic(userEntity.getPatronymic())
        .login(userEntity.getLogin())
        .age(userEntity.getAge())
        .build();
  }
}