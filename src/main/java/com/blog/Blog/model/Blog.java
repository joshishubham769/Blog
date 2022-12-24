package com.blog.Blog.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blogid")
    private int blogId;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "username")
    private String userName;


    @Column(name = "createdat")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private ZonedDateTime createdAt;

    @Column(name = "modifiedat")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private ZonedDateTime modifiedAt;


}
