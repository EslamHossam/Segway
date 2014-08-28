package com.example.ioio_motor2;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.PwmOutput;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.BaseIOIOLooper;

/**
 * This is the thread on which all the IOIO activity happens. It will be run
 * every time the application is resumed and aborted when it is paused. The
 * method setup() will be called right after a connection with the IOIO has
 * been established (which might happen several times!). Then, loop() will
 * be called repetitively until the IOIO gets disconnected.
 */
class Looper extends BaseIOIOLooper {
	MainActivity mainActivity;
//	DigitalOutput led;
	DigitalOutput pin5;
	DigitalOutput pin6;
//	PwmOutput pin5;
//	PwmOutput pin6;
	int i;
	PwmOutput pin7;
	
	public Looper(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}
	/**
	 * Called every time a connection with IOIO has been established.
	 * Typically used to open pins.
	 * 
	 * @throws ConnectionLostException When IOIO connection is lost.
	 * 
	 */
	protected void setup() throws ConnectionLostException {
//		led = ioio_.openDigitalOutput(0, true);
		pin5 = ioio_.openDigitalOutput(5);
		pin6 = ioio_.openDigitalOutput(6);
//		pin5 = ioio_.openPwmOutput(5, 50);
//		pin6 = ioio_.openPwmOutput(6, 50);
		pin7 = ioio_.openPwmOutput(7, 100);
	}

	/**
	 * Called repetitively while the IOIO is connected.
	 * 
	 * @throws ConnectionLostException When IOIO connection is lost.
	 * 
	 */
	public void loop() throws ConnectionLostException {
//		boolean newStatus = mainActivity.btnToggleLed.isChecked();
//		led.write(newStatus);
//		mainActivity.updateLedStatus(newStatus);
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//		}
//		try {
//			pin1.write(true);
//			pin2.write(false);
//			Thread.sleep(3000);
//			
//			pin1.write(false);
//			pin2.write(true);
//			Thread.sleep(3000);
//			
//		} catch (Exception e) {
//		}
		
// code to turn clockwise and anti-clockwise each 3 seconds
//		try {
//			pin5.setDutyCycle((float) 0.8);
//			pin6.setDutyCycle(0);
//			Thread.sleep(3000);
//			pin5.setDutyCycle(0);
//			pin6.setDutyCycle(1024);
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
		
//		try {
//			for(float i = 0.3f; i <= 1f; i += 0.1f){
//				Thread.sleep(1000);
//				for(int j = 0 ; j < 1000000000 ; j++){
//				pin5.setDutyCycle(i);				
//				pin6.setDutyCycle(0);
//				}
//				for(int j = 0 ; j < 1000000000 ; j++){
//				pin5.setDutyCycle(0);				
//				pin6.setDutyCycle(0);
//				}
//			}
//		
//		} catch (Exception e) {
//		}
		for(i=0.8;)
		pin7.setDutyCycle((float) 0.8);
		pin5.write(true);
		pin6.write(false);
		try{
			Thread.sleep(10);
		}catch(InterruptedException e){
			
		}
	
//	for (int j =100000;j>=50000; j-=10000){
//			try {
//				pin5.setPulseWidth(j);
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//			}
//	}
}
}

		
		
