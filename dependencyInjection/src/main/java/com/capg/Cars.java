package com.capg;

import org.springframework.stereotype.Component;

@Component
public class Cars implements Vehicle{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Car Started");
	}

}