package com.capg;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Bike implements Vehicle{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Bike Started");
	}

}