package com.blog.Blog.dto;

import java.util.List;

import com.blog.Blog.model.Blog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BlogResponseObjectDto {
    private Boolean isSuccess;
    private String msg;
    private List<Blog> data;
    private String error;
}