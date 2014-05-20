import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class RobotSameThread implements Runnable {
	private int[] xs = new int[9];
	private int[] ys = new int[9];
	private boolean running;
	private Robot robot;
	private int maxRed;

	RobotSameThread(int[] xs, int[] ys, int maxRed) {
		this.xs = xs;
		this.ys = ys;
		try {
			this.robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.running = true;
		this.maxRed = maxRed;
	}

	@Override
	public void run() {
		while(running) {
			
			for(int i = 0; i<9; i++) {
				if(robot.getPixelColor(xs[i],ys[i]).getRed() > maxRed) {
					robot.mouseMove(xs[i]+(int)(Math.random()*20)-10, 
							ys[i]+(int)(Math.random()*20)-10);
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
				}
			}
		}
	}

	public void stopRunning() {
		running = false;
	}

}
