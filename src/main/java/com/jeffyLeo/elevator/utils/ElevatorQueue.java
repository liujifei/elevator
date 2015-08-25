package com.jeffyLeo.elevator.utils;

import java.util.ArrayList;
import java.util.List;

import com.jeffyLeo.elevator.object.Elevator;

public class ElevatorQueue {

	private List<Elevator> queue;
	public ElevatorQueue(){
		
	}
	public ElevatorQueue(int eNum){
		queue = new ArrayList<Elevator>();
		for(int i = 1; i <= eNum; i++){
			Elevator e = new Elevator("elevator" + i);
			queue.add(e);
		}
	}
	public Elevator getFreeElevator(){
		for(Elevator e : queue){
			if(e.getMoveType()!=0){
				return e;
			}
		}
		return null;
	}
}
