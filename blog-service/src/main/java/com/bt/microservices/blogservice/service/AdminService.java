package com.bt.microservices.blogservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bt.microservices.blogservice.client.IJPHRestClient;
import com.bt.microservices.blogservice.client.response.UserPostsDetail;
import com.bt.microservices.blogservice.client.response.posts.GetPostsResponse;
import com.bt.microservices.blogservice.client.response.posts.Post;
import com.bt.microservices.blogservice.client.response.users.GetUsersResponse;
import com.bt.microservices.blogservice.client.response.users.User;

@Service
public class AdminService implements IAdminService{

	private IJPHRestClient iJPHRestClient;
	private final Logger logger = LoggerFactory.getLogger(AdminService.class);

	public AdminService(IJPHRestClient iJPHRestClient) {
		this.iJPHRestClient = iJPHRestClient;
	}

	@Override
	public List<UserPostsDetail> getAllUserPosts() throws Exception {
		// TODO Auto-generated method stub
		logger.info("Received request to get AllUserPost{} in Service layer...");

		//get all users
		User[] usersList = iJPHRestClient.fetchAllDetail(EndPoint.Users.toString(), User[].class);
		logger.info("Received usersList{}...");

		GetUsersResponse getUsersResponse = new GetUsersResponse();
		if(usersList !=null)
			getUsersResponse.setAllUsers(usersList);
		//get all posts
		
		Post[] postsList = iJPHRestClient.fetchAllDetail(EndPoint.Posts.toString(), Post[].class);
		logger.info("Received postsList{}...");

		GetPostsResponse getPostsResponse = new GetPostsResponse();
		if(postsList !=null)
			getPostsResponse.setAllPosts(postsList);
		
		
		//combine the result somehow and then return the collective response
		List<UserPostsDetail> userPostsDetail = prepareResponse(getUsersResponse, getPostsResponse);
		//GetUsersResponse response = iJPHRestClient.getAllUserPosts();
		logger.info("Received response for get AllUserPost{} in Service layer...");

		return userPostsDetail;
	}




	private List<UserPostsDetail> prepareResponse(GetUsersResponse getUsersResponse, GetPostsResponse getPostsResponse) {
		logger.info("Received request for prepareResponse{} in Service layer...");
		
		List<User> userList = Arrays.asList(getUsersResponse.getAllUsers());
		
		List<Post> postList = Arrays.asList(getPostsResponse.getAllPosts());
		
		List<UserPostsDetail> result = userList.stream()
			    .flatMap(p -> postList.stream()
			        .filter(u -> p.getId().equals(u.getUserId()))
			        .map(u -> new UserPostsDetail(p, u)))
			    .collect(Collectors.toList());
		logger.info("prepareResponse{} in completed...");

		return result;
		
	}

}
