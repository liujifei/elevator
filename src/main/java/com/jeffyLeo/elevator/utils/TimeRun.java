package com.jeffyLeo.elevator.utils;

import java.util.Timer;
import java.util.TimerTask;

import com.jeffyLeo.elevator.intface.CallbackTimeRunTask;

public class TimeRun {

	Timer timer;

	public TimeRun(int runTime, CallbackTimeRunTask callback){
		timer = new Timer();
		timer.schedule(new TimeTask(callback), runTime * 1000);
		timer.cancel();
	}

	public void stop(){
		timer.cancel();
	}

	class TimeTask extends TimerTask{

		CallbackTimeRunTask callbackTask;

		public TimeTask(CallbackTimeRunTask callback){
			callbackTask = callback;
		}
		@Override
		public void run() {
			callbackTask.timeRunTask();
		}
	}

}
