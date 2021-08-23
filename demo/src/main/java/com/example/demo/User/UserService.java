package com.example.demo.User;

import com.example.demo.Task.Task;
import com.example.demo.Task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public UserService(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public UserClass getUser(Long userId){
        Optional<UserClass> userById = userRepository.findById(userId);

        UserClass user = userById.get();
       return user;
    }

    public void addNewUser(UserClass user){
       Optional<UserClass> userByName = userRepository.findUserByName(user.getUserName());

        if(userByName.isPresent()){
            throw new IllegalStateException("name taken");
        }

        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
      boolean exists =  userRepository.existsById(userId);
      if(!exists){
          throw new IllegalStateException("user with id "+userId +" does not exists");
      }
      userRepository.deleteById(userId);
    }

    public void updateUserPassword(Long userId, String newPassword) {
        Optional<UserClass> userById = userRepository.findById(userId);

        UserClass user = userById.get();

        user.setPassword(newPassword);

        userRepository.save(user);
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getTasks(Long userId) {

        return taskRepository.findTaskByUserId(userId);
    }



    public void deleteTask(Long taskId) {
        Optional<Task> taskById = taskRepository.findTaskById(taskId);

        Task task = taskById.get();

        taskRepository.delete(task);
    }

    public void updateTask(Long taskId, String newDescription) {
        Optional<Task> taskById = taskRepository.findTaskById(taskId);

        Task task = taskById.get();
        task.setDescription(newDescription);

        taskRepository.save(task);
    }
}
