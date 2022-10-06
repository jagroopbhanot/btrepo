package com.bt.microservices.blogservice.client;

public interface IJPHRestClient {
	/*
	 * Method to call External API for all 
	 * */

	
	<T, R> R fetchAllDetail(String endPoint, Class<R> responseType) throws Exception;
}
