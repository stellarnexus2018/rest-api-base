package ru.master.restapi.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Сущность для представления "Пользователь"
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long          id;
  private String        firstName;
  private String        secondName;
  private String        patronymic;
  private String        login;
  private String        password;
  private Integer       age;
  private LocalDateTime vdat;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  private List<UserTaskEntity> userTaskEntityList;
}