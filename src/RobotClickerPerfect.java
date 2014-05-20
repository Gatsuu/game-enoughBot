import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;


public class RobotClickerPerfect implements Runnable {
	private int[] xs = new int[9];
	private int[] ys = new int[9];
	private int[] xc = new int[9];
	private int[] yc = new int[9];
	private boolean running;
	private Robot robot;
	private int maxBlue;
	private int maxGreen;
	private int maxRed;
	RobotClickerPerfect(int[] xs, int[] ys, int[] xc, int[] yc, int maxRed, int maxGreen, int maxBlue) {
		this.xs = xs;
		this.ys = ys;
		this.xc = xc;
		this.yc = yc;
		try {
			this.robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.running = true;
		this.maxBlue = maxBlue;
		this.maxGreen = maxGreen;
		this.maxRed = maxRed;
	}

	@Override
	public void run() {
		while(running) {
			for(int i = 0; i<9; i++) {
				Color c = robot.getPixelColor(xc[i],yc[i]);
				//Color c2 = robot.getPixelColor(xs[i],ys[i]);
				if((c.getBlue() >= maxBlue && c.getGreen() >= maxGreen) 
						/*|| c2.getRed() >= maxRed*/) {
					robot.mouseMove(xs[i], ys[i]);
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
