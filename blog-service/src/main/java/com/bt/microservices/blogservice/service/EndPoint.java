package com.bt.microservices.blogservice.service;

public enum EndPoint {

	Users("users"),
	Posts("posts");
	
	private final String text;
	
	private EndPoint(final String text) {
		// TODO Auto-generated constructor stub
		this.text = text;
	}

	public static EndPoint fromValue(String value)
	{
		for(EndPoint b : EndPoint.values())
		{
			if(b.getValue().equals(value))
			{
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + value + "'");
	}
	
	public String getValue()
	{
		return text;
	}
	
	@Override
	public String toString()
	{
		return text;
	}
}
