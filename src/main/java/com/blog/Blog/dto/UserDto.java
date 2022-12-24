package com.blog.Blog.dto;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String userName;

    private String password;

    private String email;

    private int phoneNumber;

    private boolean isActive;
}
