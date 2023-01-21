package com.blog.Blog.controller;

import com.blog.Blog.dto.BlogDto;
import com.blog.Blog.dto.ResponseObject;
import com.blog.Blog.dto.UserDto;
import com.blog.Blog.service.BlogService;
import com.blog.Blog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @GetMapping("/health/stats")
    private ResponseEntity<String> wokingStatus() {
        return new ResponseEntity<>("Working", HttpStatus.OK);
    }

    @PostMapping("/user")
    private ResponseEntity<ResponseObject> registerUser(@RequestBody UserDto userDto) {
        ResponseObject serviceResp = userService.registerUser(userDto);

        return new ResponseEntity<>(
                serviceResp,
                serviceResp.getIsSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);

    }

    // @GetMapping("/blog")
    // private ResponseEntity<ResponseObject> getBlog(@RequestBody GetBlogDto
    // getBlogDto) {

    // ResponseObject serviceResp = blogService.getBlog(blogDto);

    // return new ResponseEntity<>(
    // serviceResp,
    // serviceResp.getIsSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);

    // }

    @PostMapping("/blog")
    private ResponseEntity<ResponseObject> createBlog(@RequestBody BlogDto blogDto) {

        ResponseObject serviceResp = blogService.createBlog(blogDto);

        return new ResponseEntity<>(
                serviceResp,
                serviceResp.getIsSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);

    }
}
