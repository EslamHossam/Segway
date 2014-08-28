package com.example.helloworldandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button button;
	private EditText text1;
	private EditText text2;
	private TextView textView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		construct();
		addListenerOnButton();
	}

	private void construct() {
		button = (Button) findViewById(R.id.button1);
		text1 = (EditText)findViewById(R.id.editText1);
		text2 = (EditText)findViewById(R.id.editText2);
		textView = (TextView) findViewById(R.id.textView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
    public void addListenerOnButton() {
    //Select a specific button to bundle it with the action you want
    button.setOnClickListener(new OnClickListener() {
    
    	@Override
        public void onClick(View view) {
        	int number1 = Integer.parseInt(text1.getText().toString());
        	int number2 = Integer.parseInt(text2.getText().toString());
        	int number3 = number1 + number2;
        	textView.setText(Integer.toString(number3));
        }
        
    });
    
    } 
}
        
	
	
//	private Button button;	
//	    @Override
//	    public void onCreate(Bundle savedInstanceState) {
//	        super.onCreate(savedInstanceState);
//	        setContentView(R.layout.main);	
//	        addListenerOnButton();
//	    }
//	
//	    public void addListenerOnButton() {
//	        //Select a specific button to bundle it with the action you want
//	        button = (Button) findViewById(R.id.button1);
//	        button.setOnClickListener(new OnClickListener() {
//	
//	            @Override	
//	            public void onClick(View view) {
//	              Intent openBrowser =  new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.javacodegeeks.com"));	
//	              startActivity(openBrowser);
//	            }


