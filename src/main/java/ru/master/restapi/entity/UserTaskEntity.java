package ru.master.restapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_tasks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserTaskEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "task_title")
  private String taskTitle;

  @Column(name = "task_completed")
  private Boolean taskCompleted;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity usr;
}