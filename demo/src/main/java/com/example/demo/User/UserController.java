package com.example.demo.User;


import com.example.demo.Task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="user/")
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(path = "userId={userId}")
  public UserClass getUser(@PathVariable Long userId) {
    return userService.getUser(userId);
  }

  @PostMapping(path = "add/name={name}&password={password}")
  public void registerNewUser(@PathVariable String name, @PathVariable String password){
    UserClass user = new UserClass(name, password);

    userService.addNewUser(user);
  }

  @PutMapping(path = "update/userId={userId}&newPassword={newPassword}")
  public void updateUserPassword(@PathVariable Long userId, @PathVariable String newPassword){
    userService.updateUserPassword(userId,newPassword);
  }

  @DeleteMapping(path = "delete/userId={userId}")
  public void deleteUser(@PathVariable("userId") Long userId){
    userService.deleteUser(userId);
  }

  @PostMapping(path = "task/addTask/userId={userId}&description={description}")
  public void addTask(@PathVariable Long userId, @PathVariable String description){
    Task task = new Task(userId,description);

    userService.addTask(task);
  }

  @GetMapping(path = "task/allTasks/userId={userId}")
  public List<Task> getTasks(@PathVariable Long userId){
    return userService.getTasks(userId);
  }

  @DeleteMapping(path = "/task/delete/taskId={taskId}")
  public void deleteTask(@PathVariable Long taskId){
    userService.deleteTask(taskId);
  }

  @PutMapping(path = "task/updateTask/taskId={taskId}&newDescription={newDescription}")
  public void updateTask(@PathVariable Long taskId, @PathVariable String newDescription){
    userService.updateTask(taskId,newDescription);
  }

}
