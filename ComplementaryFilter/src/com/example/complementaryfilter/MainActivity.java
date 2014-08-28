package com.example.complementaryfilter;

import android.app.Activity; 
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class MainActivity extends Activity implements SensorEventListener{

	// my needs are:
	// a acceleromter sensor
	// - b Sensor manager
	// -- c Activity

	// listener to receive the events

	SensorManager sensorManager;
	Sensor accelerometer;
	Sensor gyro;
	
	float	correctAngle;
	float 	previousAccX;		// last reading from ACC in X direction
	float 	currentGyroY;		
	long 	previousTimestamp;	// the timestamp of the last Gyro reading
	float 	dt;
	int counter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initSensors();
	}

	private void initSensors() {
		
		// get the sensorManager object
		sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
		
		// get the default accelerometer fromt the sensorManager
		accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
		
		// connect 		the event-consumer (activity / this) 
		// with 		the event-provider (the sensor)
		sensorManager.registerListener(this , accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sensorManager.registerListener(this, gyro, SensorManager.SENSOR_DELAY_NORMAL);
		
		

	}

	
	//angle = (0.98)*(angle + gyro * dt) + (0.02)*(x_acc);

	@Override
	public void onSensorChanged(SensorEvent event) {
		
		counter++;
		if(counter==100)
			sensorManager.unregisterListener(this);
		
		if(previousTimestamp==0)
			previousTimestamp = event.timestamp;
		
		
		
		if(event.sensor == gyro)
		{
			
			if(event.values[1]>-0.01 || event.values[0]<0.01)
				currentGyroY = 0;
			else
				currentGyroY = event.values[1];
			
			
			// rotation around Y is currentGyroY
			dt = event.timestamp - previousTimestamp;
			dt = dt / 1000000000f;
//			System.out.println(dt);
			correctAngle = (0.98f)*(correctAngle + currentGyroY * dt) + (0.02f)*(previousAccX);
//			
			System.out.println("[" + dt + " , " +currentGyroY + " , " + correctAngle + " , " + previousAccX + "]");
//			System.out.println("currentGyroY * dt=" +currentGyroY * dt);
			
			previousTimestamp = event.timestamp;
		}
		if(event.sensor == accelerometer)
		{
			// Angle in X direction is event.values[0]/9.8
			
			/*if(event.values[0]>-0.01 || event.values[0]<0.01)
				previousAccX = 0;
			else
				*/previousAccX = event.values[0] / 9.8f;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//===================================================

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	
	

}
