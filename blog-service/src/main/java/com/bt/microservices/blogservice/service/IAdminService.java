package com.bt.microservices.blogservice.service;

import java.util.List;

import com.bt.microservices.blogservice.client.response.UserPostsDetail;

public interface IAdminService {

	/*
	 * Method to get All Posts of All Users
	 * */
	List<UserPostsDetail> getAllUserPosts() throws Exception;
}
