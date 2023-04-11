package com.exam.solid.l.badexample;

public class App {

	public static void main(String[] args) {
		
		Vehicle v = new PetrolCar("Toyota", 3);
		
		v.speedUp();
		v.slowDown();
		v.fuel();

		// design smell
		Vehicle v1 = new ElectricCar("Toyota", 3);
		v.speedUp();
		v.slowDown();
		// we don't put any normal fuel to electric car
		v.fuel();
	}
}
