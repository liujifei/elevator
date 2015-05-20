package com.jeffyLeo.elevator.utils;

import com.jeffyLeo.elevator.object.Elevator;

public class Main {

	public static void main(String[] args) {

		Elevator e1 = new Elevator("elevator1");
		e1.moveTo(10);
		e1.moveTo(5);
	}

}
