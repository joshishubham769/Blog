package com.blog.Blog.mapper;

import com.blog.Blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,String>{

    List<User> findByUserName(String userName);
    //A implements C
    //B implements C
    //A extends B

    //C-->B(method definations)

}
