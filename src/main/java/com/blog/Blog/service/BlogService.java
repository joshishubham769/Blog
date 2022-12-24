//package com.blog.Blog.service;
//
//import com.blog.Blog.mapper.BlogRepository;
//import com.blog.Blog.model.Blog;
//import com.blog.Blog.model.NewBlogRequest;
//import com.blog.Blog.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.time.ZonedDateTime;
//
//import java.util.Date;
//import java.util.Optional;
//
//@Service
//public class BlogService {
//    @Autowired
//    private BlogRepository blogRepository;
//
//    //check with blogId if the blog is already saved i not save it
//    public boolean addBlog(Blog blog){
////        Blog blog=new Blog();
////        blog.setBody(newBlogRequest.getBody());
////        blog.setTitle(newBlogRequest.getTitle());
////        blog.setUserName(newBlogRequest.getUserName());
//        blog.setCreatedAt(ZonedDateTime.now());
//        blogRepository.save(blog);
//        return true;
//
//    }
//
//    //check if the blog was written by the same person who is trying to edit it if yes edit it
//    public boolean editBlog(User userName,Blog blog,String blogId) throws Exception{
//        Optional<Blog> existingBlog=blogRepository.findById(blogId);
//        if(existingBlog.isEmpty() || !existingBlog.get().getUserName().equals(userName)){
//            return false;
//        }
//        blog.setBlogId(blogId);
//        blogRepository.save(blog);
//        return true;
//    }
//
//    //check if blog is written by the same user who is trying to delete and then delete
//    public boolean deleteBlog(User userName, String blogId){
//        if(blogRepository.findById(blogId).get().getUserName().equals(userName)){
//            blogRepository.deleteById(blogId);
//            return true;
//        }
//        return false;
//    }
//}
