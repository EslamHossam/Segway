
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
	DigitalOutput pin1;
	DigitalOutput pin2;
	PwmOutput pin3;
	PwmOutput pin4;
	
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
		pin1 = ioio_.openDigitalOutput(3, true);
		pin2 = ioio_.openDigitalOutput(4, true);
		pin3 = ioio_.openPwmOutput(5, 50);
		pin4 = ioio_.openPwmOutput
				(6, 50);
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
		try {
			pin1.write(true);
			pin2.write(false);
			Thread.sleep(3000);
			pin1.write(false);
			pin2.write(true);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
//		try {
//			pin3.setDutyCycle(100);
//			pin4.setDutyCycle(0);
//			Thread.sleep(3000);
//			pin3.setDutyCycle(0);
//			pin4.setDutyCycle(100);
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
	}
		
		
}
