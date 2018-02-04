package ex03;

import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
					//	new Thread (()-> {
						//	while(window.frame.isVisible()){
							TimerTask timerTask = new TimerTask(){
								public void run(){
									System.out.println("0");
									window.ifModified();
								}
							};
							Timer timer = new Timer();
							timer.schedule(timerTask, 100,60*100);
							}
					//	}).start();
					
			//	}
			catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
