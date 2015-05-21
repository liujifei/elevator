package com.jeffyLeo.elevator.object;

import java.util.Timer;
import java.util.TimerTask;

import com.jeffyLeo.elevator.intface.ElevatorAction;

public class Elevator implements ElevatorAction {

	//电梯名
	private String elevatorName;
	//位置
	private Integer position;
	//运行方式 >0：上行	0：停止	<0：下行
	private Integer moveType;
	//
	Timer timer;
	TimeTask task;
	public Elevator(String name){
		timer = new Timer();
		elevatorName = name;
		position = 1;
		moveType = 0;
	}
	public synchronized void moveTo(final Integer goal) {
		if(Thread.currentThread()!=null){
			task = new TimeTask(goal);
			moveType = goal - position;
			timer.schedule(task, 0, speed * 1000);
		}
	}

	class TimeTask extends TimerTask{
		Integer moveGoal;
		public TimeTask(final Integer goal){
			moveGoal = goal;
		}
		@Override
		public void run() {
			if(moveGoal == position){
				timer.cancel();
			} else {
				change();
			}
		}
	}

	private synchronized void change(){
		// 位置变动
		position += moveType/Math.abs(moveType);
		System.out.println("电梯_" + elevatorName + "位置： " + position);
		System.out.println(Thread.currentThread().getName());
		
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
