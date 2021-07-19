package ru.master.restapi.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Сущность для представления "Пользователь"
 */
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "patronymic")
  private String patronymic;

  @Column(name = "login")
  private String login;

  @Column(name = "password")
  private String password;

  @Column(name = "age")
  private Integer age;

  @Column(name = "status")
  private Integer status;

  @Column(name = "vdat")
  private LocalDateTime vdat;

  @OneToMany(mappedBy = "usr", cascade = CascadeType.ALL)
  private List<UserTaskEntity> userTaskEntityList;
}