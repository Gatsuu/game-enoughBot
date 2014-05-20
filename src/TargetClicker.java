import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;


public class TargetClicker implements Runnable {
	
	private int x1;
	private int x2;
	private int x3;
	private int y;
	private boolean running;
	private Robot robot;
	private int maxRed;
	
	TargetClicker(int x1, int x2, int x3, int y, int maxRed) throws AWTException {
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.y = y;
		this.robot = new Robot();
		this.running = true;
		this.maxRed = maxRed;
	}

	@Override
	public void run() {
		while(running) {
			int thisColor1 = robot.getPixelColor(x1, y).getRed();
			int thisColor2 = robot.getPixelColor(x2, y).getRed();
			int thisColor3 = robot.getPixelColor(x3, y).getRed();
			if(thisColor1 > maxRed) {
				System.err.println("shoot" + this);
				robot.mouseMove(x1, y);
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
			} else if(thisColor2 > maxRed) {
				System.err.println("shoot" + this);
				robot.mouseMove(x2, y);
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);				
			} else if(thisColor3 > maxRed) {
				System.err.println("shoot" + this);
				robot.mouseMove(x3, y);
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
			}
		}
	}
	
	public void stopRunning() {
		running = false;
	}

}
