package com.blog.Blog.controller;

import com.blog.Blog.ResponseObject.ResponseObject;
import com.blog.Blog.dto.UserDto;
import com.blog.Blog.model.User;
import com.blog.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    private ResponseEntity<ResponseObject> registerUser(@RequestBody UserDto userDto) throws InstanceAlreadyExistsException {
        ResponseObject serviceResp = userService.registerUser(userDto);

        return new ResponseEntity<>(
                serviceResp,
                serviceResp.getIsSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);

    }

    @GetMapping//get user details by userName
    private ResponseEntity<List<User>> getUsers(@RequestParam(required = false) String userName){
        return new ResponseEntity<>(userService.getUsers(userName),HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<UserDto> putUser(@RequestBody(required = true) UserDto modifiedUserDto){
        return new ResponseEntity<>(userService.modifyUser(modifiedUserDto),HttpStatus.OK);
    } //update user details (userName -> check if new userName unique, Name, phoneNumber)

    @DeleteMapping
    private ResponseEntity<User> deleteUser(@RequestParam(required = true) String userName) throws MissingRequestValueException {
        return new ResponseEntity<>(userService.deleteUser(userName),HttpStatus.OK);
    }//delete user by username (disable, isActive false)
}
