package ru.master.restapi.dto;

import lombok.*;
import ru.master.restapi.entity.UserTaskEntity;

/**
 * DTO для представления "Задание"
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserTaskDto {
  private Long    id;
  private String  taskTitle;
  private Boolean taskCompleted;

  public static UserTaskDto toDto(UserTaskEntity userTaskEntity) {
    return UserTaskDto.builder()
        .id(userTaskEntity.getId())
        .taskTitle(userTaskEntity.getTaskTitle())
        .taskCompleted(userTaskEntity.getTaskCompleted())
        .build();
  }
}