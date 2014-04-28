package edu.ucsb.cs.cs185.tyralyn.tyralynScoring;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends FragmentActivity {

	Button dateButton, gameButton, nextButton;
	TextView dateTextView; 
	String dateString = "Date";
	int myDay = 15;
	int myMonth = 7;
	int myYear = 2012;
	Handler myHandler = new Handler() {
		@Override
		public void handleMessage(Message m) {
			Bundle b=m.getData();
			myDay = b.getInt("setDay");
			myMonth = b.getInt("setMonth");
			myYear = b.getInt("setYear");
			dateString = b.getString("setDate");
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dateButton = (Button) findViewById(R.id.date_button);
		dateTextView= (TextView) findViewById(R.id.date_text);
		gameButton = (Button) findViewById(R.id.game_button);
		nextButton = (Button) findViewById(R.id.next_button);
		
		OnClickListener listener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				Bundle b = new Bundle();
				b.putInt("setDay", myDay);
				b.putInt("setMonth", myMonth);
				b.putInt("setYear", myYear);
				
				DatePickerFragment dpf = new DatePickerFragment();
				dpf.myHandler = myHandler;
				dpf.setArguments(b);
				FragmentManager fm = getSupportFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();
				ft.add(dpf, "date_picker");
				ft.commit();
				dateString=dpf.getDateString(); 
			}
 
		};
		dateTextView.setText("hi"); 
		dateButton.setOnClickListener(listener);
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	} 

}
