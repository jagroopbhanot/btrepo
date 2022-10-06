package com.bt.microservices.blogservice.client.response.users;

import org.springframework.cache.annotation.CacheConfig;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
@CacheConfig(cacheNames={"GetUsersResponse"}) 
public class GetUsersResponse {

	User[] allUsers;

	

	public User[] getAllUsers() {
		return allUsers;
	}



	public void setAllUsers(User[] allUsers) {
		this.allUsers = allUsers;
	}



	@Override
	public String toString() {
		return "GetAllUserResponse [allUsers=" + allUsers + "]";
	}
	
	
	
}
