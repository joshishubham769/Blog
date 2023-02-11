package com.blog.Blog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blogid")
    private int blogId;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "username")
    private String userName;

    @Column(name = "createdat")
    private ZonedDateTime createdAt = ZonedDateTime.now();

    @Column(name = "modifiedat")
    private ZonedDateTime modifiedAt = ZonedDateTime.now();
}
/**
 * try to implement this...
 *static class Parent{
 *         int x;
 *         int y;
 *     }
 *     static class Child extends Parent{
 *         int z;
 *     }
 * 	public static void main (String[] args) throws java.lang.Exception
 *        {
 * 		Child child=new Child();
 * 		child.x=1;
 * 		child.y=2;
 * 		child.z=3;
 *
 * 		Parent parent=(Parent)child;
 * 		System.out.println(parent.x+" "+parent.y);
 *
 * 		Child child2=(Child)parent;
 * 		child2.z=4;
 * 		System.out.println(child2.x+" "+child2.y+" "+child2.z);
 *    }
 */
