package com.bt.microservices.blogservice.client.response.users;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

	@JsonProperty("street")
	private String street;
	
	@JsonProperty("suite")
	private String suite;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("zipcode")
	private String zipcode;
	
	@JsonProperty("geo")
	private Geo geo;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", suite=" + suite + ", city=" + city + ", zipcode=" + zipcode + ", geo="
				+ geo + "]";
	}
	
	
}
