package com.blog.Blog.service;

import com.blog.Blog.mapper.UserRepository;
import com.blog.Blog.model.User;
import com.blog.Blog.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    private boolean checkForUniqueUserName(String userName){
        if(userRepository.findById(userName)==null)return true;
        else return false;
    }
    public boolean registerUser(UserDto userdto){
        if(checkForUniqueUserName(userdto.getUserName())){
            User user=new User();
            user.setUserName(userdto.getUserName());
            user.setPassword(passwordEncoder.encode(userdto.getPassword()));
            userRepository.save(user);
            return true;
        }
        else return false;
    }


    public boolean removeUser(User user){
        if(userRepository.existsById(user.getUserName())){
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    public boolean loginUser(){//deal with token probabily create and return token
        return false;
    }

    public boolean logoutUser(){
        return false;
    }
}
