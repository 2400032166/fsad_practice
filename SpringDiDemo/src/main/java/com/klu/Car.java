package com.klu;

public class Car {
private Engine engine; //creating an variable for the class

public Car(Engine engine) {
	this.engine=engine;
}
public void drive() {
	engine.start();
	System.out.println("Initiated Car drive...");
}
}
