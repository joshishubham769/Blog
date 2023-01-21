package com.blog.Blog.controller;

// import com.blog.Blog.model.Blog;
import com.blog.Blog.dto.UserDto;
import com.blog.Blog.service.UserService;
import com.blog.Blog.service.UserService.ResponseObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BlogController {

    // @Autowired
    // private BlogService blogService;

    @Autowired
    private UserService userService;

    @GetMapping("/health/stats")
    public ResponseEntity<String> wokingStatus() {
        return new ResponseEntity<>("Working", HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<ResponseObject> registerUser(@RequestBody UserDto userDto) {
        ResponseObject serviceResp = userService.registerUser(userDto);

        return new ResponseEntity<>(
                serviceResp,
                serviceResp.getIsSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);

    }

    // @PostMapping("/addBlog")
    // public ResponseEntity<String> addBlog(@RequestBody Blog blog){
    // if(blogService.addBlog(blog))return new
    // ResponseEntity<>("Success",HttpStatus.OK);
    // else return new ResponseEntity<>("Fail",HttpStatus.OK);
    // }

}
