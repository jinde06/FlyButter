package com.example.flybutter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ButterNet extends Activity {
	Button a;
	Button b;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_fbmain);
	    a = (Button)findViewById(R.id.dan);
	    b = (Button) findViewById(R.id.button2);
	    
	}
	public void dan(View v){
		Intent a = new Intent(this,MainActivitygame .class);
		startActivity(a);
	
	}
	public void bim(View v){
		Intent b = new Intent(this,HsMainActivity .class);
		startActivity(b);

	}
	public void ins (View v){
		Dialog d = new Dialog(this);
		d.setTitle("Invalid");
		d.setContentView(R.layout.activity_main_activityinstruction);
		d.show();
	}
}