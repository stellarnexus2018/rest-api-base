package ru.master.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.master.restapi.repository.UserTaskRepository;

@Service
public class UserTaskService {
  private final UserTaskRepository userTaskRepository;

  @Autowired
  public UserTaskService(UserTaskRepository userTaskRepository) {
    this.userTaskRepository = userTaskRepository;
  }










}
