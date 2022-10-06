/**
 * 
 */
package com.bt.microservices.blogservice.client.response;

import com.bt.microservices.blogservice.client.response.posts.Post;
import com.bt.microservices.blogservice.client.response.users.User;

/**
 * @author jagro
 *
 */
public class UserPostsDetail {

	User user;
	
	Post post;
	
	public UserPostsDetail(User users, Post posts) {
		// TODO Auto-generated constructor stub
		
		user = users;
		post = posts;
	}
	public User getUserList() {
		return user;
	}
	public void setUserList(User user) {
		this.user = user;
	}
	public Post getPostList() {
		return post;
	}
	public void setPostList(Post post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "UserPostsDetail [userList=" + user + ", postList=" + post + "]";
	}
	
	
}
