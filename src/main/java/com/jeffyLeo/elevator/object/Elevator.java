package com.jeffyLeo.elevator.object;

import java.util.Timer;
import java.util.TimerTask;

import com.jeffyLeo.elevator.intface.ElevatorAction;

public class Elevator implements ElevatorAction {

	//电梯名
	private String elevatorName;
	//位置
	private volatile Integer position;
	//运行方式 >0：上行	0：停止	<0：下行
	private volatile Integer moveType;
	//
	volatile Timer timer;
	TimeTask task;
	public Elevator(String name){
		elevatorName = name;
		position = 1;
		moveType = 0;
	}
	public synchronized void moveTo(Integer goal){
		timer = new Timer();
		task = new TimeTask(goal);
//		while(moveType != 0){
//			try {
//				this.wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		this.notify();
		moveType = goal - position;
		if(moveType != 0){
			timer.schedule(task, 0, speed * 1000);
		}
	}

	class TimeTask extends TimerTask{
		volatile Integer moveGoal;
		public TimeTask(final Integer goal){
			moveGoal = goal;
		}
		@Override
		public void run() {
			synchronized(this){
				if(moveGoal != position){
					// 位置变动
					position += moveType/Math.abs(moveType);
					moveType = moveGoal - position;
					System.out.println("电梯_" + elevatorName + "  位置： " + position + "  moveType: " + moveType);
				}else{
					timer.cancel();
				}
			}
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
