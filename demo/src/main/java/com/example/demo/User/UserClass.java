package com.example.demo.User;

import javax.persistence.*;

@Entity
@Table
public class UserClass {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String user_name;
    private String user_password;

    public UserClass() {
    }

    public UserClass(Long id, String name, String password) {
        this.id = id;
        this.user_name = name;
        this.user_password = password;
    }

    public UserClass( String name, String password) {
        this.user_name = name;
        this.user_password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String name) {
        this.user_name = name;
    }

    public String getPassword() {
        return user_password;
    }

    public void setPassword(String password) {
        this.user_password= password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", toDoListId=" +
                ", name='" + user_name + '\'' +
                ", password='" + user_password + '\'' +
                '}';
    }
}
