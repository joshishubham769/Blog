package com.blog.Blog.service;

import com.blog.Blog.mapper.UserRepository;
import com.blog.Blog.model.User;

import com.blog.Blog.dto.ResponseObject;
import com.blog.Blog.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // @Autowired
    // private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    private boolean checkForUniqueUserName(String userName) {

        return userRepository.findByUserName(userName).isEmpty();

    }

    public ResponseObject registerUser(UserDto userdto) {
        ResponseObject returnResponse;
        try {

            if (checkForUniqueUserName(userdto.getUserName())) {
                User user = new User();
                user.setUserName(userdto.userName);
                user.setEmail(userdto.email);
                user.setPhoneNumber(userdto.phoneNumber);
                user.setPassword(userdto.password);

                // user.setPassword(passwordEncoder.encode(userdto.getPassword()));
                User resp = userRepository.save(user);

                returnResponse = new ResponseObject(true, "User Created successfully!", resp.getId(), null);
            } else {
                returnResponse = new ResponseObject(false, "", null, "User Already Exist!");

               // return returnResponse;
            }

        } catch (Exception e) {
            returnResponse = new ResponseObject(false, "User creation failed!", null, e.getMessage()// error.message
            );

            //return returnResponse;
        }
        return returnResponse;
    }


    public boolean loginUser() {// deal with token probabily create and return token
        return false;
    }

    public boolean logoutUser() {
        return false;
    }
}
