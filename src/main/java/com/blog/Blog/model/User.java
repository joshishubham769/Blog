package com.blog.Blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //private boolean setIsActive;
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;//needs to be encrypted

    @Column(name="createdat")
    private ZonedDateTime createdAt = ZonedDateTime.now();

    @Column(name="modifiedat")
    private ZonedDateTime modifiedAt = ZonedDateTime.now();

    @Column(name="email")
    private String email;

    @Column(name="phonenumber")
    private Integer phoneNumber;

    @Column(name="isactive")
    private Boolean isActive = true;
}
