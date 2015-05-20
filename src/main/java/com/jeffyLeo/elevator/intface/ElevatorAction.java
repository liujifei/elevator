package com.jeffyLeo.elevator.intface;

public interface ElevatorAction {

	//电梯升一层楼需要的时间
	final Integer speed = 2;

	/**
	 * 移动
	 */
	public void moveTo(Integer goal);

}
