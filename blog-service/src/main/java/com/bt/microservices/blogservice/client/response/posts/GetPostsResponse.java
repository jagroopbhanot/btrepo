package com.bt.microservices.blogservice.client.response.posts;

import org.springframework.cache.annotation.CacheConfig;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
@CacheConfig(cacheNames={"GetPostResponse"}) 
public class GetPostsResponse {
	Post[] allPosts;

	public Post[] getAllPosts() {
		return allPosts;
	}

	public void setAllPosts(Post[] allPosts) {
		this.allPosts = allPosts;
	}

	@Override
	public String toString() {
		return "GetPostResponse [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
