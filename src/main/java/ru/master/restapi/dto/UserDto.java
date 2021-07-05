package ru.master.restapi.dto;

import lombok.*;

/**
 * DTO для представления "Пользователь"
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
  private Long    id;
  private String  firstName;
  private String  secondName;
  private String  patronymic;
  private String  login;
  private Integer age;
}