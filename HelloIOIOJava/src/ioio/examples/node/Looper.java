package ioio.examples.node;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.IOIO;
import ioio.lib.api.Uart;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.BaseIOIOLooper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JToggleButton;

public class Looper extends BaseIOIOLooper  {

	DigitalOutput led;
	MainApp mainApp;

	public Looper(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	protected void setup() throws ConnectionLostException, InterruptedException {
		led = ioio_.openDigitalOutput(IOIO.LED_PIN, true);
	}

	@Override
	public void loop() throws ConnectionLostException, InterruptedException {

		try {
			led.write(mainApp.btnToggleLed.isSelected());

		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread.sleep(100);
	}
}
