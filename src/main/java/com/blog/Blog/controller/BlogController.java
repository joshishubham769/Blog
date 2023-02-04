package com.blog.Blog.controller;

import com.blog.Blog.dto.BlogDto;
import com.blog.Blog.dto.BlogResponseObjectDto;
import com.blog.Blog.dto.ResponseObject;
import com.blog.Blog.dto.UserDto;
import com.blog.Blog.service.BlogService;
import com.blog.Blog.service.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/blog") // get all blogs
    // if query param in url, ?username="test123" -> posts of test123
    private ResponseEntity<BlogResponseObjectDto> getBlog(@RequestParam("username") Optional<String> userName) {
        BlogResponseObjectDto serviceResp = blogService.getBlogDetails(userName);

        return new ResponseEntity<>(
                serviceResp,
                serviceResp.getIsSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    // @PutMapping("/blog") // update Post details, based on post Id
    // private ResponseEntity<BlogResponseObjectDto> editBlog(@RequestParam("username") String userName,
    //         @RequestParam("blogid") Integer blogId) {
    //     BlogResponseObjectDto serviceRe  sp = blogService.editBlogDetails(userName, blogId);

    //     return new ResponseEntity<>(
    //             serviceResp,
    //             serviceResp.getIsSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND);

    // }

    @DeleteMapping("/blog") // delete blog post by Id
    // if query param in url, ?username="test123" -> delete all posts of test123
    private ResponseEntity<BlogResponseObjectDto> deleteBlog(@RequestParam("username") String userName,
            @RequestParam("blogid") Integer blogId) {
        BlogResponseObjectDto serviceResp = blogService.deleteBlogDetails(userName, blogId);

        return new ResponseEntity<>(
                serviceResp,
                serviceResp.getIsSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
