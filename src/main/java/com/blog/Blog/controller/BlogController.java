package com.blog.Blog.controller;

import com.blog.Blog.model.Blog;
import com.blog.Blog.model.User;
import com.blog.Blog.model.UserDto;
import com.blog.Blog.service.BlogService;
import com.blog.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> register(UserDto userDto) {
        userService.registerUser(userDto);
        return new ResponseEntity<>("Done",HttpStatus.ACCEPTED);
    }

    @PostMapping("/addBlog")
    public ResponseEntity<String> addBlog(Blog blog){
        if(blogService.addBlog(blog))return new ResponseEntity<>("Success",HttpStatus.OK);
        else return new ResponseEntity<>("Fail",HttpStatus.OK);
    }

}
