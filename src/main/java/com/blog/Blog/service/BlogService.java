package com.blog.Blog.service;

import com.blog.Blog.dto.BlogDto;
import com.blog.Blog.mapper.BlogRepository;
import com.blog.Blog.model.Blog;
import com.blog.Blog.dto.ResponseObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    // @Autowired
    // private ResponseObject responseObject;

    public ResponseObject createBlog(BlogDto blogDto) {
        try {
            Blog blog = new Blog();
            blog.setBody(blogDto.getBody());
            blog.setTitle(blogDto.getTitle());
            blog.setUserName(blogDto.getUserName());

            Blog resp = blogRepository.save(blog);

            ResponseObject returnResponse = new ResponseObject(
                    true,
                    "Blog created successfully!",
                    resp.getBlogId(),
                    null);

            return returnResponse;
        } catch (Exception e) {
            ResponseObject returnResponse = new ResponseObject(
                    false,
                    "Blog creation failed!",
                    null,
                    e.getMessage()// error.message
            );

            return returnResponse;
        }
    }

    // check if the blog was written by the same person who is trying to edit it if
    // yes edit it
    // public boolean editBlog(User userName, Blog blog, String blogId) throws
    // Exception {
    // Optional<Blog> existingBlog = blogRepository.findById(blogId);
    // if (existingBlog.isEmpty() ||
    // !existingBlog.get().getUserName().equals(userName)) {
    // return false;
    // }
    // blog.setBlogId(blogId);
    // blogRepository.save(blog);
    // return true;
    // }

    // check if blog is written by the same user who is trying to delete and then
    // delete
    // public boolean deleteBlog(User userName, String blogId) {
    // if (blogRepository.findById(blogId).get().getUserName().equals(userName)) {
    // blogRepository.deleteById(blogId);
    // return true;
    // }
    // return false;
    // }
}
