package com.lpu.coupling;


//tight coupling --> not adaptable to changes , highly interdependent, any changes in one component affects the other components 
//loose coupling --> adaptable to changes, less dependent, flexible
public class Ride {
	
	Vehicle v;
	
	public void startRide() {
		v.start();
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ride ride = new Ride();
		ride.v = new Car();//upcasting the Vehicle reference
		ride.startRide();
		ride.v = new Bike();
		ride.startRide();

	}

}