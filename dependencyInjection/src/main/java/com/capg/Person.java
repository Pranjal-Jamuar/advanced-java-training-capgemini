package com.capg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
	
	@Value("101")
	private int id;
	@Value("Aman")
	private String name;
//	@Autowired                      //DI for Object            //Field DI
//	private AadharCard card;
	
//	@Autowired
//	@Qualifier(value="bike") //Bike
	private Vehicle v; //Car, Bike
	
	public Person(Vehicle v) {
		this.v = v;
	}

	public Vehicle getV() {
		return v;
	}

	public void setV(Vehicle v) {
		this.v = v;
	}	
	
//	public Person() {}
//	
//	@Autowired //if we are using 1 constructor then we dont need to write Autowired
//	public Person(AadharCard card) {
//		this.card=card;
//	}
	
//	public AdharCard getCard() {
//		return card;
//	}
	
////	@Autowired                      //DI for obejct            //Setter DI
//	public void setCard(AadharCard card) {
//		this.card = card;
//	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
}