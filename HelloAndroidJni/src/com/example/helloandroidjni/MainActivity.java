package com.example.helloandroidjni;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		String msg = myNativeFunction();
		Toast.makeText(this, msg , Toast.LENGTH_LONG).show();
		
		msg = multiHopFunction();
		Toast.makeText(this, msg , Toast.LENGTH_LONG).show();
		
	}

    public String myJavaFunction(String text) {
	    Toast.makeText(this, "Hello from myJavaFunction, received: " +  text, Toast.LENGTH_SHORT).show();
	    return "x";
	}

    public native String myNativeFunction();
    public native String multiHopFunction();
    
    
    
	static {
        System.loadLibrary("native-sensors-lib");
    }
	
}
