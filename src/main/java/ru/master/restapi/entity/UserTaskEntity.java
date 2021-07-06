package ru.master.restapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserTaskEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long    id;
  private String  taskTitle;
  private Boolean taskCompleted;

  @ManyToOne
  @JoinColumn(name = "id")
  private UserEntity user;
}