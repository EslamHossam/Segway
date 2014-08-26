

import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends IOIOActivity {

	ToggleButton btnToggleLed;
	TextView txtLedStatus;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnToggleLed = (ToggleButton) findViewById(R.id.btnToggleLed);
		txtLedStatus = (TextView) findViewById(R.id.txtLedStatus);
	}

	@Override
	protected IOIOLooper createIOIOLooper() {
		return new Looper(this);
	}

	public void updateLedStatus(final boolean newStatus) {
		runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				txtLedStatus.setText("Status is " + newStatus);
				
			}
		});
		
	}



}
