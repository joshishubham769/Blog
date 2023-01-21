package com.blog.Blog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseObject {
    private Boolean isSuccess;
    private String msg;
    private Integer id;
    private String error;

    //why can't make it private??
    public ResponseObject(Boolean isSuccess, String msg, Integer id, String error) {
        this.isSuccess = isSuccess;
        this.msg = msg;
        this.id = id;
        this.error = error;
    }
}