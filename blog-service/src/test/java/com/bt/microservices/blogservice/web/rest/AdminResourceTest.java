package com.bt.microservices.blogservice.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bt.microservices.blogservice.client.response.UserPostsDetail;
import com.bt.microservices.blogservice.client.response.posts.Post;
import com.bt.microservices.blogservice.client.response.users.User;
import com.bt.microservices.blogservice.service.AdminService;

@ExtendWith(MockitoExtension.class)
public class AdminResourceTest {

	@InjectMocks
	@Spy
	private AdminResource adminResource;
	
	@Mock
	private AdminService adminService;
	
	@Test
	void testGetAllUserPosts() throws Exception
	{
		List<UserPostsDetail> getDetail = createDataSet();
		//given
		Mockito.lenient().when(adminService.getAllUserPosts()).thenReturn(getDetail);
		
		//when
		List<UserPostsDetail> getResponse= adminService.getAllUserPosts();
		
		//then
		Assertions.assertNotNull(getResponse);
		Assertions.assertEquals(2, getResponse.size());
	}
	
	@Test
	void testGetAllUserPostsFailure() throws Exception
	{
		List<UserPostsDetail> getDetail = new ArrayList();
		//given
		Mockito.lenient().when(adminService.getAllUserPosts()).thenReturn(getDetail);
		
		//when
		List<UserPostsDetail> getResponse= adminService.getAllUserPosts();
		
		//then
		Assertions.assertNotNull(getResponse);
		Assertions.assertEquals(0, getResponse.size());
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
