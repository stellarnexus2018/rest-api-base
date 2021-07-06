package ru.master.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.master.restapi.entity.UserTaskEntity;

public interface UserTaskRepository extends CrudRepository<UserTaskEntity, Long> {




}
