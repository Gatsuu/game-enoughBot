import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class Main {
	
	public static void main(String[] args) {
		
		int[] xs = {311,516,721,243,516,789,174,515,857};
		int[] ys = {257,257,257,328,327,327,414,411,414};
		int[] xc = {337,549,695,303,575,729,187,558,849};
		int[] yc = {310,311,313,435,440,438,561,563,565};
		
		//RobotSameThread rob = new RobotSameThread(xs, ys, 200);
		//RobotClickerPerfect rob = new RobotClickerPerfect(xs, ys, xc, yc, 200, 140, 175);
		RobotMoveToTarget rob = new RobotMoveToTarget(xs, ys, xc, yc, 200, 140, 175);
		Thread t = new Thread(rob);
		t.start();
		
		startGame();
		
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//rob.stopRunning();
		
		/*
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			Point loc = MouseInfo.getPointerInfo().getLocation();
			System.out.println("x: "+loc.x+" y: "+loc.y);

			System.out.println(robot.getPixelColor(loc.x, loc.y));
			//System.out.println(MouseInfo.getPointerInfo().getLocation());
		}*/
		
		
       /* try {
			robot = new Robot();
			robot.mouseMove(515, 411);
			Color color1 = Color.black, color2 = Color.black;
			while(true) {
				Point loc = MouseInfo.getPointerInfo().getLocation();
				if(color1.getRed() > 200 && color2.getRed() > 200 && robot.getPixelColor(loc.x, loc.y).getRed() > 200) {
					System.err.println("shoot");
					mouseClick();
				}
				
				color1 = color2;
				color2 = robot.getPixelColor(loc.x, loc.y);
				
				System.out.println(robot.getPixelColor(loc.x, loc.y));
				//System.out.println(MouseInfo.getPointerInfo().getLocation());
			}
			
			int startPosX = 440 + (int)(Math.random()*(600-440));
			int startPosY = 483 + (int)(Math.random()*(523-483));
			System.out.println("startx: " + startPosX + " y: " + startPosY);
			robot.mouseMove(startPosX, startPosY);
			System.out.println(robot.getPixelColor(startPosX, startPosY));
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
            
	}

	private static void startGame() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int startPosX = 440 + (int)(Math.random()*(600-440));
		int startPosY = 483 + (int)(Math.random()*(523-483));
		robot.mouseMove(startPosX, startPosY);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
	}
}
