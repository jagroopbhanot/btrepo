package com.bt.microservices.blogservice.service;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bt.microservices.blogservice.client.JPHRestClient;
import com.bt.microservices.blogservice.client.response.UserPostsDetail;
import com.bt.microservices.blogservice.client.response.posts.GetPostsResponse;
import com.bt.microservices.blogservice.client.response.posts.Post;
import com.bt.microservices.blogservice.client.response.users.GetUsersResponse;
import com.bt.microservices.blogservice.client.response.users.User;
import com.fasterxml.jackson.databind.JsonMappingException;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {
	
	@InjectMocks
	@Spy
	AdminService adminService;

	@Mock
	JPHRestClient jphRestClient;
	
	@Test
	void testGetAllUserPosts() throws Exception
	{

		User[] users = createUserSet();
		
		Post[] posts = createPostSet();
		
		
		Mockito.lenient()
		.when(jphRestClient.fetchAllDetail(any(), eq(User[].class)))
		.thenReturn(users);

		Mockito.lenient()
		.when(jphRestClient.fetchAllDetail(any(), eq(Post[].class)))
		.thenReturn(posts);	
		
		List<UserPostsDetail> upd = createDataSet();
		
		GetUsersResponse getUserResponse = new GetUsersResponse();
		getUserResponse.setAllUsers(users);
		
		GetPostsResponse getPostResponse = new GetPostsResponse();
		getPostResponse.setAllPosts(posts);
		
		List<UserPostsDetail> updList = adminService.getAllUserPosts();
		
		Assert.assertNotNull(updList);
		Assert.assertEquals(2, updList.size());
		Assert.assertEquals("1", updList.get(0).getUserList().getId());
		Assert.assertEquals("Jagroop", updList.get(0).getUserList().getName());
		Assert.assertEquals("jb", updList.get(0).getUserList().getUsername());
		Assert.assertEquals("jb@test.com", updList.get(0).getUserList().getEmail());

	}
	
	@Test
	void testGetAllUserPosts_NoRecord() throws Exception
	{

		User[] users = new User[0];
		
		Post[] posts = new Post[0];
		
		
		Mockito.lenient()
		.when(jphRestClient.fetchAllDetail(any(), eq(User[].class)))
		.thenReturn(users);

		Mockito.lenient()
		.when(jphRestClient.fetchAllDetail(any(), eq(Post[].class)))
		.thenReturn(posts);	
		
		List<UserPostsDetail> upd = createDataSet();
		
		GetUsersResponse getUserResponse = new GetUsersResponse();
		getUserResponse.setAllUsers(users);
		
		GetPostsResponse getPostResponse = new GetPostsResponse();
		getPostResponse.setAllPosts(posts);
		
		List<UserPostsDetail> updList = adminService.getAllUserPosts();
		
		Assert.assertNotNull(updList);
		Assert.assertEquals(0, updList.size());
	}

	@Test
	void testGetAllUserPostsFailure() throws Exception
	{
		Mockito.lenient().when(jphRestClient.fetchAllDetail(any(),eq(User[].class)))
		.thenThrow(new JsonMappingException("Exception Occured in UpStream API"));
		
		Throwable exception = Assertions.assertThrows(JsonMappingException.class, () -> adminService.getAllUserPosts());
		Assert.assertThat(exception.getMessage(), CoreMatchers.containsString("Exception Occured in UpStream API"));
		
	}
	
	private User[] createUserSet()
	{
		User user = new User();
		user.setId("1");
		user.setName("Jagroop");
		user.setUsername("jb");
		user.setEmail("jb@test.com");
		
		User user1 = new User();
		user1.setId("2");
		user1.setName("Jagroop1");
		user1.setUsername("jb1");
		user1.setEmail("jb1@test.com");
		
		User[] users = new User[2];
		users[0] = user;
		users[1] = user1;
		
		return users;
	}
	
	private Post[] createPostSet()
	{
		Post post = new Post();
		post.setId("11");
		post.setUserId("1");
		post.setTitle("firstTitle");
		post.setBody("firstBody");

		
		Post post1 = new Post();
		post1.setId("12");
		post1.setUserId("1");
		post1.setTitle("secondTitle");
		post1.setBody("secondBody");
		
		Post[] posts = new Post[2];
		posts[0] = post;
		posts[1] = post1;
		
		return posts;
	}
	
	private List<UserPostsDetail> createDataSet() {
		// TODO Auto-generated method stub
		List<UserPostsDetail> userPostDetail = new ArrayList<UserPostsDetail>();
		
		User user = new User();
		user.setId("1");
		user.setName("Jagroop");
		user.setUsername("jb");
		user.setEmail("jb@test.com");
		
		Post post = new Post();
		post.setId("11");
		post.setUserId("1");
		post.setTitle("firstTitle");
		post.setBody("firstBody");
		UserPostsDetail upd = new UserPostsDetail(user, post);
		
		User user1 = new User();
		user1.setId("2");
		user1.setName("Jagroop1");
		user1.setUsername("jb1");
		user1.setEmail("jb1@test.com");
		
		Post post1 = new Post();
		post1.setId("12");
		post1.setUserId("1");
		post1.setTitle("secondTitle");
		post1.setBody("secondBody");
		UserPostsDetail upd1 = new UserPostsDetail(user, post);
		
		userPostDetail.add(upd);
		userPostDetail.add(upd1);

		return userPostDetail;
	}
}
