package com.exam.solid.l.badexample;

public class PetrolCar extends Vehicle {

	public PetrolCar(String type, int age) {
		super(type, age);
	}

	@Override
	protected void speedUp() {
		System.out.println("Petrol car is speeding up...");
	}
	
	@Override
	protected void slowDown() {
		System.out.println("Petrol car is slowing down...");
	}
	
	@Override
	public void fuel() {
		System.out.println("We can use petrol without any problem");
	}
}
