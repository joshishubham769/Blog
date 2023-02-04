package com.blog.Blog.mapper;

import com.blog.Blog.model.Blog;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BlogRepository extends JpaRepository<Blog, String> {
    List<Blog> findByUserName(Optional<String> userName);

    Blog findByBlogId(Integer blogId);

    List<Blog> deleteByBlogId(Integer blogId);
}
