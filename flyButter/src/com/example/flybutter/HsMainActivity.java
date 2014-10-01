package com.example.flybutter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class HsMainActivity extends Activity {

	TextView t1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		t1 = (TextView) findViewById(R.id.textView1asd);
		t1.setText(MainActivitygame.getHS() + " ");
		
		setContentView(R.layout.activity_hs_main);
		
	}

}
