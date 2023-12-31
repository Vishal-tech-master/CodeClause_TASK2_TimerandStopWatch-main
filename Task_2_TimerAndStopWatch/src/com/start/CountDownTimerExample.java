package com.start;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class CountDownTimerExample {
	
	JFrame window;
	JLabel counterLabel;
	Font font1 = new Font("Arial", Font.PLAIN, 70);	
	Timer timer;	
	int second, minute;
	String ddSecond, ddMinute;	
	DecimalFormat dFormat = new DecimalFormat("00");
	

	public static void main(String[] args) {
		
		new CountDownTimerExample();		
	}
	
	public CountDownTimerExample() {
		
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		
		counterLabel = new JLabel("");
		counterLabel.setBounds(300, 230, 200, 100);
		counterLabel.setHorizontalAlignment(JLabel.CENTER);
		counterLabel.setFont(font1);
		
		window.add(counterLabel);
		window.setVisible(true);
		
// Enable this to use Simple Timer
//		second = 0;
//		simpleTimer();
//		timer.start();
		
// Enable this to use Normal Timer
//		counterLabel.setText("00:00");
//		second =0;
//		minute =0;
//		normalTimer();
//		timer.start();
		
		// Countdown Timer
		counterLabel.setText("03:00");
		second =0;
		minute =3;
		countdownTimer();
		timer.start();						
	}
    
// Enable this to use Simple Timer
//	public void simpleTimer() {
//		
//		timer = new Timer(1000, new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				second++;
//				
//				counterLabel.setText(""+ second);
//			}
//		});
//	}
	
// Enable this to use Normal Timer
//	public void normalTimer() {
//		
//		timer = new Timer(1000, new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				second++;
//				
//				ddSecond = dFormat.format(second);
//				ddMinute = dFormat.format(minute);				
//				counterLabel.setText(ddMinute + ":" + ddSecond);
//				
//				if(second==60) {
//					second=0;
//					minute++;
//					
//					ddSecond = dFormat.format(second);
//					ddMinute = dFormat.format(minute);
//					counterLabel.setText(ddMinute + ":" + ddSecond);
//				}
//			}
//		});
//	}
	public void countdownTimer() {
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);	
				counterLabel.setText(ddMinute + ":" + ddSecond);
				
				if(second==-1) {
					second = 59;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);	
					counterLabel.setText(ddMinute + ":" + ddSecond);
				}
				if(minute==0 && second==0) {
					timer.stop();
				}
			}
		});		
	}		
}
