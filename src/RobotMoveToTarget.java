import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class RobotMoveToTarget implements Runnable {
	private int[] xs = new int[9];
	private int[] ys = new int[9];
	private int[] xc = new int[9];
	private int[] yc = new int[9];
	private boolean running;
	private Robot robot;
	private int maxBlue;
	private int maxGreen;
	private int maxRed;

	RobotMoveToTarget(int[] xs, int[] ys, int[] xc, int[] yc, int maxRed, int maxGreen, int maxBlue) {
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
				Point startLocation = MouseInfo.getPointerInfo().getLocation();
				int startX = startLocation.x;
				int startY = startLocation.y;
				Color c = robot.getPixelColor(xc[i],yc[i]);
				if((c.getBlue() >= maxBlue && c.getGreen() >= maxGreen) 
						|| c.getRed() >= maxRed) {
					int stopX = xs[i]+(int)(Math.random()*20)-10;
					int dx = stopX-startX;
					int stopY = ys[i]+(int)(Math.random()*20)-10;
					int dy = stopY-startY;
					double xAmount = (double)dx/3000;
					double yAmount = (double)dy/3000;
					
//					System.out.println("xamount = "+ xAmount + " yAmount = "+ yAmount
//							+ "\nstartX = "+startX + " startY = "+startY+"\nstopX = "
//							+stopX+" stopY = "+stopY + "\ndx = "+dx+" dy = "+dy);
					
					for(int j = 1; j<3000; j++) {
						//System.out.println(j);
						//System.out.println("x: "+startX+(int)(xAmount*j)+" y: "+startY+(int)(yAmount*j));
						robot.mouseMove(startX+(int)(xAmount*j), startY+(int)(yAmount*j));
					}
					
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
				} /*else {
					robot.mouseMove(startX+(int)(Math.random()*20)-10, 
							startY+(int)(Math.random()*20)-10);
				}*/
			}
		}
	}

	public void stopRunning() {
		this.running = false;
	}

}
