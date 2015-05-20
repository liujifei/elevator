package com.jeffyLeo.elevator.object;

import com.jeffyLeo.elevator.intface.CallbackTimeRunTask;
import com.jeffyLeo.elevator.intface.ElevatorAction;
import com.jeffyLeo.elevator.utils.TimeRun;

public class Elevator implements ElevatorAction {

	//
	private String elevatorName;
	//位置
	private Integer position;
	//运行方式 >0：上行	0：停止	<0：下行
	private Integer moveType;

	public Elevator(String name){
		elevatorName = name;
		position = 1;
		moveType = 0;
	}
	public void moveTo(final Integer goal) {
		moveType = goal - this.position;
		if(moveType != 0){
			new TimeRun(speed, new CallbackTimeRunTask(){
	
				public void timeRunTask() {
					// 位置变动
					position += moveType/Math.abs(moveType);
					System.out.println("电梯_" + elevatorName + "位置： " + position);
				}
				
			});
			if(position != goal){
				moveTo(goal);
			} else {
				System.out.println("position == goal");
			}
		} else {
			System.out.println("除数为零！");
			return;
		}
	}
	public String getElevatorName() {
		return elevatorName;
	}
	public void setElevatorName(String elevatorName) {
		this.elevatorName = elevatorName;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Integer getMoveType() {
		return moveType;
	}
	public void setMoveType(Integer moveType) {
		this.moveType = moveType;
	}

}
