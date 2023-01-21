package com.blog.Blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.ZonedDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment, generated by db
    private Integer id;

    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;//needs to be encrypted

    @CreationTimestamp
    @Column(name="createdat")
    private ZonedDateTime createdAt = ZonedDateTime.now();

    @UpdateTimestamp
    @Column(name="modifiedat")
    private ZonedDateTime modifiedAt = ZonedDateTime.now();

    @Column(name="email")
    private String email;

    @Column(name="phonenumber")
    private Long phoneNumber;

    @Column(name="isactive")
    private Boolean isActive = true;
}
