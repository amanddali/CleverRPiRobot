package org.jointheleague.ecolban.cleverrobot;

/*********************************************************************************************
 * Vic's ultrasonic sensor running with Erik's Clever Robot for Pi
 * version 0.9, 170227
 **********************************************************************************************/
import java.io.IOException;

import org.jointheleague.ecolban.rpirobot.IRobotAdapter;
import org.jointheleague.ecolban.rpirobot.IRobotInterface;
import org.jointheleague.ecolban.rpirobot.SimpleIRobot;

public class CleverRobot extends IRobotAdapter {
	Sonar sonar = new Sonar();

	public CleverRobot(IRobotInterface iRobot) {
		super(iRobot);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Try event listner, rev Monday 2030");
		IRobotInterface base = new SimpleIRobot();
		CleverRobot rob = new CleverRobot(base);
		rob.setup();
		while (rob.loop()) {
		}
		rob.shutDown();

	}

	private void setup() throws Exception {

	}

	private boolean loop() throws Exception {
		if (isCleanButtonDown())
			return false;
		driveDirect(200, 200);
		readSensors(SENSORS_GROUP_ID100);
		sensor();
		return true;
	}

	private void shutDown() throws IOException {
		reset();
		stop();
		closeConnection();
	}

	public void sensor() throws IOException, InterruptedException {

		if (isBumpLeft() == true) {
			driveDirect(-100, -100);
			Thread.sleep(1000);
			driveDirect(0, 200);
			Thread.sleep(1000);
			driveDirect(200, 200);
		}
		if (isBumpRight() == true) {
			driveDirect(-100, -100);
			Thread.sleep(1000);
			driveDirect(200, 0);
			Thread.sleep(1000);
			driveDirect(200, 200);
		}
	}
}
