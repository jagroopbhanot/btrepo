package com.bt.microservices.blogservice.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bt.microservices.blogservice.service.EndPoint;
import com.bt.microservices.blogservice.service.RestTemplateClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JPHRestClient implements IJPHRestClient{
	private final Logger logger = LoggerFactory.getLogger(JPHRestClient.class);

	@Value("${app.ExternalClientProtocol}")
	private String EXTERNAL_API_END_POINT_PROTOCOL = "";

	@Value("${app.ExternalClientDNS}")
	private String EXTERNAL_API_END_POINT_DNS = "";

	public static final String SLASH = "/";

	@Autowired
	private RestTemplateClass restTemplate;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder)
	{
		return builder.build();
	}
	
	public JPHRestClient(RestTemplateClass restTemplate) {
		// TODO Auto-generated constructor stub
		this.restTemplate = restTemplate;
	}

	
	/**
	 * @return
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	@Override
	public <T,R> R fetchAllDetail(String endPoint, Class<R> responseType) throws JsonProcessingException, JsonMappingException {
		logger.info("Received request to get AllUsers{} in JPHRestClient layer...");
			
		try
		{	
			ResponseEntity<String> responseEntity = restTemplate.getForEntity
					(getExternalURL(EndPoint.fromValue(endPoint)), String.class);
			
			logger.info("Received response to get AllUsers{} in JPHRestClient layer...");

			if(responseEntity.getStatusCode() == HttpStatus.OK)
			{
				logger.info("Response Received from external API for getAllUsers{}...");
				return parseResponse(responseEntity, responseType);
			}
			return null;

		}
		catch(Exception e)
		{
			logger.error("Unable to complete the request {}...", e.getMessage());
			throw e;
		}
			
	}

	/**
	 * @return
	 */
	private String getExternalURL(EndPoint endPoint) {
		return EXTERNAL_API_END_POINT_PROTOCOL+EXTERNAL_API_END_POINT_DNS+SLASH+endPoint;
	}

	
	/**
	 * @param responseEntity
	 * @param response
	 * @param getAllUserResponse
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	private <T,R> R parseResponse(ResponseEntity<String> responseEntity, Class<R> responseType) throws JsonProcessingException, JsonMappingException {

		if(responseEntity !=null)
		{
			if(responseEntity.getBody() != null)
			{
				final ObjectMapper objectMapper = new ObjectMapper();
				return objectMapper.readValue(responseEntity.getBody(), responseType);
			}
			return null;
		}
		return null;
	}	
}
