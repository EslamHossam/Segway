package com.example.helloioioandroid;

import ioio.lib.api.DigitalOutput;
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
	DigitalOutput led;
	
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
		led = ioio_.openDigitalOutput(0, true);
	}

	/**
	 * Called repetitively while the IOIO is connected.
	 * 
	 * @throws ConnectionLostException When IOIO connection is lost.
	 * 
	 */
	public void loop() throws ConnectionLostException {
		boolean newStatus = mainActivity.btnToggleLed.isChecked();
		led.write(newStatus);
		mainActivity.updateLedStatus(newStatus);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}
}