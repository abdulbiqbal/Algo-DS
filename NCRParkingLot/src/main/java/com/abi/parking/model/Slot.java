package com.abi.parking.model;

/**
 * @author Abdul
 *
 */
public class Slot implements Comparable<Slot>{
	
	Integer number;
	Car car;
	
	Slot(int number){
		this.number = number;
	}

	@Override
	public int compareTo(Slot o) {
		return number.compareTo(o.number);
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Integer getNumber() {
		return number;
	}

}
