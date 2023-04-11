package com.exam.solid.l.badexample;

public class ElectricCar extends Vehicle {

	public ElectricCar(String type, int age) {
		super(type, age);
	}

	@Override
	protected void speedUp() {
		System.out.println("Electric car is speeding up...");
	}
	
	@Override
	protected void slowDown() {
		System.out.println("Electric car is slowing down...");
	}

	@Override
	public void fuel() {
		throw new Error("Electric cars cn not be fueled...");
	}
}
