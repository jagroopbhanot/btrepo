package com.bt.microservices.blogservice.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bt.microservices.blogservice.client.response.UserPostsDetail;
import com.bt.microservices.blogservice.service.AdminService;

@RestController
@RequestMapping("/v1/admin")
public class AdminResource {
	
	private final Logger logger = LoggerFactory.getLogger(AdminResource.class);
	private final AdminService adminService;
	
	
	public AdminResource(AdminService adminService) {
		this.adminService = adminService;
	}


	@GetMapping("/allUserPosts")
	public List<UserPostsDetail> getAllUserPosts() throws Exception
	{
		logger.info("Received request to get AllUserPost{}...");
		List<UserPostsDetail> getResponse= adminService.getAllUserPosts();
		logger.info("Received response to get AllUserPost{}...");
		return getResponse;

	}

}
