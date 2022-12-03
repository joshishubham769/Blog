package com.blog.Blog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Blog {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String blogId;//needs to randomly generated


    @Column(name="title")
    private String title;

    @Column(name="body")
    private String body;

    @Column(name="writer")
    private String userName;
}
