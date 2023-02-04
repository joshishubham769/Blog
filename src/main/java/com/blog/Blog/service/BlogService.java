package com.blog.Blog.service;

import com.blog.Blog.dto.BlogDto;
import com.blog.Blog.dto.BlogResponseObjectDto;
import com.blog.Blog.mapper.BlogRepository;
import com.blog.Blog.model.Blog;
import com.blog.Blog.dto.ResponseObject;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    // @Autowired//to avoid creating new object
    // private ResponseObject responseObject;

    public ResponseObject createBlog(BlogDto blogDto) {
        ResponseObject returnResponse;
        try {
            Blog blog = new Blog();
            blog.setBody(blogDto.getBody());
            blog.setTitle(blogDto.getTitle());
            blog.setUserName(blogDto.getUserName());

            Blog resp = blogRepository.save(blog);

            returnResponse = new ResponseObject(
                    true,
                    "Blog created successfully!",
                    resp.getBlogId(),
                    null);

        } catch (Exception e) {
            System.out.println(e.getMessage());

            returnResponse = new ResponseObject(
                    false,
                    "Blog creation failed!",
                    null,
                    e.getMessage()// error.message
            );

        }
        return returnResponse;
    }

    public BlogResponseObjectDto getBlogDetails(Optional<String> userName) {
        BlogResponseObjectDto returnResponse;
        try {
            if (userName.isPresent()) {
                returnResponse = new BlogResponseObjectDto(
                        true,
                        "Data fetched!",
                        blogRepository.findByUserName(userName),
                        null);
            } else {
                returnResponse = new BlogResponseObjectDto(
                        true,
                        "Data fetched!",
                        blogRepository.findAll(),
                        null);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

            returnResponse = new BlogResponseObjectDto(
                    false,
                    null,
                    null,
                    "Data fetch error!");
        }

        return returnResponse;
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

    // public BlogResponseObjectDto editBlogDetails(String userName, Integer blogId)
    // {
    // BlogResponseObjectDto returnResponse;
    // try {
    // if (deleteBlogDetailsUtility(userName, blogId)) {
    // returnResponse = new BlogResponseObjectDto(
    // true,
    // "Data deleted!",
    // null,
    // null);
    // } else {
    // returnResponse = new BlogResponseObjectDto(
    // false,
    // null,
    // null,
    // "Data deletion failed!");
    // }

    // } catch (Exception e) {
    // System.out.println(e.getMessage());

    // returnResponse = new BlogResponseObjectDto(
    // false,
    // null,
    // null,
    // "Data fetch error!");
    // }

    // return returnResponse;
    // }

    // check if blog is written by the same user who is trying to delete and then
    // delete
    private boolean deleteBlogDetailsUtility(String userName, Integer blogId) {
        try {
            Blog blogInfo = blogRepository.findByBlogId(blogId);
            String writer = blogInfo.getUserName();

            if (writer.equals(userName)) {
                blogRepository.deleteByBlogId(blogId);
                return true;
            }

            return false;

        } catch (Exception e) {
            System.out.println(e.getMessage());

            return false;
        }
    }

    public BlogResponseObjectDto deleteBlogDetails(String userName, Integer blogId) {
        BlogResponseObjectDto returnResponse;
        try {
            if (deleteBlogDetailsUtility(userName, blogId)) {
                returnResponse = new BlogResponseObjectDto(
                        true,
                        "Data deleted!",
                        null,
                        null);
            } else {
                returnResponse = new BlogResponseObjectDto(
                        false,
                        null,
                        null,
                        "Data deletion failed!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

            returnResponse = new BlogResponseObjectDto(
                    false,
                    null,
                    null,
                    "Data fetch error!");
        }

        return returnResponse;
    }
}
