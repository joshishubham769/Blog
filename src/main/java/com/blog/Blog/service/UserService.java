package com.blog.Blog.service;

import com.blog.Blog.mapper.UserRepository;
import com.blog.Blog.model.User;

import com.blog.Blog.ResponseObject.ResponseObject;
import com.blog.Blog.dto.UserDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MissingRequestValueException;

import javax.management.InstanceAlreadyExistsException;
import javax.xml.bind.ValidationException;
import java.util.List;

@Service
@Slf4j
public class UserService {

    // @Autowired
    // private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    private boolean checkForUniqueUserName(String userName) throws InstanceAlreadyExistsException {
        if (userRepository.findByUserName(userName).isEmpty()) return true;
        else throw new InstanceAlreadyExistsException("User with userName \'"+ userName+"\' already exist.");
    }


    public ResponseObject registerUser(UserDto userdto) throws InstanceAlreadyExistsException {
        ResponseObject returnResponse=null;
        if (checkForUniqueUserName(userdto.getUserName())) {
            User user = new User(userdto);
            userRepository.save(user);
            log.info(getUsers(user.getUserName()).get(0).toString());
            returnResponse = new ResponseObject(true, "User Created successfully!", user.getId());
        }
        return returnResponse;
    }

    public List<User> getUsers(String userName) {
        if (userName == null) {
            return userRepository.findAll();
        }
        List<User> result = userRepository.findByUserName(userName);
        if(!result.isEmpty())return result;
        else{
            throw new EntityNotFoundException("user/users not found");
        }

    }


    public boolean loginUser() {// deal with token probabily create and return token
        return false;
    }

    public boolean logoutUser() {
        return false;
    }

    public UserDto modifyUser(UserDto modified_userdto) {
        User user=getUsers(modified_userdto.getUserName()).get(0);
        userRepository.save(new User(modified_userdto));
        return modified_userdto;
    }

    public User deleteUser(String userName) throws MissingRequestValueException {
        if(userName!=null){
            User user = getUsers(userName).get(0);
            user.setIsActive(false);
            userRepository.save(user);
            return user;
        }
        else{
            throw new MissingRequestValueException("Please give userName");
        }
    }
}
