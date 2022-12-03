package com.blog.Blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name="userName")
    private String userName;

    @Column(name="password")
    private String password;//needs to be encrypted

    @Column(name="blogIds")
    private List<String> blogIds;


}
