import java.awt.AWTException;


public class RobotHandler implements Runnable {

	@Override
	public void run() {
		try {
			TargetClicker[] pos = new TargetClicker[3];
			pos[0] = new TargetClicker(311, 516, 721, 257, 200);
			pos[1] = new TargetClicker(243, 516, 789, 327, 200);
			pos[2] = new TargetClicker(174, 515, 857, 413, 200);
			//pos[1] = new TargetClicker(516,257, 200);
			//pos[2] = new TargetClicker(721,257, 200);
			//pos[3] = new TargetClicker(243,327, 200);
			//pos[4] = new TargetClicker(516,327, 200);
//			pos[5] = new TargetClicker(789,327, 200);
//			pos[6] = new TargetClicker(174,413, 200);
//			pos[7] = new TargetClicker(515,413, 200);
//			pos[8] = new TargetClicker(857,413, 200);
			System.out.println(pos.length);
			
			Thread[] tPool = new Thread[3];		
			for(int i=0;i<pos.length;i++) {
				System.out.println(i);
				tPool[i] = new Thread(pos[i]);
				tPool[i].start();	
				System.out.println(i);
			}
			try {
				Thread.sleep(40000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0;i<pos.length;i++) {
				pos[i].stopRunning();			
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
