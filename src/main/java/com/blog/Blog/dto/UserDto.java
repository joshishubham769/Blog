package com.blog.Blog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
     public String userName;
     public String password;
     public String email;
     public Long phoneNumber;
     public boolean isActive;
}
