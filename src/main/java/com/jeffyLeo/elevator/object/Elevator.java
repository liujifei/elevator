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
		if(moveType == 0){
			return;
		} else {
			new TimeRun(speed * 1000, new CallbackTimeRunTask(){

				public void timeRunTask() {
					// 位置变动
					if(position != goal){
						Integer move = Math.abs(moveType);
						if(move!=0){
							position += moveType/move;
						} else {
							return;
						}
						System.out.println("电梯_" + elevatorName + "位置： " + position);
						moveTo(goal);
					} else {
						return;
					}
				}
				
			});
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
