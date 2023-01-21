package com.blog.Blog.service;

import com.blog.Blog.mapper.UserRepository;
import com.blog.Blog.model.User;

import com.blog.Blog.dto.ResponseObject;
import com.blog.Blog.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // @Autowired
    // private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    // private boolean checkForUniqueUserName(String userName) {
    // // if(userRepository.findBy(User,(uName)->uName==userName))return true;
    // if (!userRepository.findByUserName(userName).isEmpty())
    // return true;
    // else
    // return false;
    // }

    public ResponseObject registerUser(UserDto userdto) {
        try {

            // if (checkForUniqueUserName(userdto.getUserName())) {
            User user = new User();
            user.setUserName(userdto.userName);
            user.setEmail(userdto.email);
            user.setPhoneNumber(userdto.phoneNumber);
            user.setPassword(userdto.password);

            // user.setPassword(passwordEncoder.encode(userdto.getPassword()));
            User resp = userRepository.save(user);

            ResponseObject returnResponse = new ResponseObject(
                    true,
                    "User Created successfully!",
                    resp.getId(),
                    null);

            return returnResponse;
        } catch (Exception e) {
            ResponseObject returnResponse = new ResponseObject(
                    false,
                    "User creation failed!",
                    null,
                    e.getMessage()// error.message
            );

            return returnResponse;
        }
    }

    public boolean loginUser() {// deal with token probabily create and return token
        return false;
    }

    public boolean logoutUser() {
        return false;
    }
}
