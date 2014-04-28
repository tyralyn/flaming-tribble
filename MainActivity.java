package edu.ucsb.cs.cs185.tyralyn.tyralynScoring;

import java.util.Calendar;




//import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.app.DatePickerDialog;
//import android.app.Activity;
//import android.app.DatePickerDialog;
//import android.app.Dialog;
//import android.app.DialogFragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
//import android.os.Message;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
//import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
//import android.widget.DatePicker;
import android.widget.TextView;
//import android.os.Build;

public class MainActivity extends FragmentActivity {

	Button dateButton, gameButton, nextButton;
	TextView dateTextView; 
	String dateString = "blah";
	int myDay, myMonth, myYear;
	Handler myHandler;
	
	public MainActivity() {
        final Calendar c = Calendar.getInstance();
        myYear = c.get(Calendar.YEAR);
        myMonth = c.get(Calendar.MONTH);
        myDay = c.get(Calendar.DAY_OF_MONTH);
	}
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dateButton = (Button) findViewById(R.id.date_button);
		dateTextView= (TextView) findViewById(R.id.date_text);
		gameButton = (Button) findViewById(R.id.game_button);
		nextButton = (Button) findViewById(R.id.next_button);
		
		dateButton.setOnClickListener(new OnClickListener() {
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
			}
		});
	}
	
	private DatePickerDialog.OnDateSetListener myDateSetListener =
			new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int month, int day) {
			myDay = day;
			myMonth = month;
			myYear = year;
			dateTextView.setText(makeDateString());
		}
	};
	
	public String makeDateString() {
		String dateString;
		String monthString;
		switch (myMonth) {
		case 0:
			monthString = "Jan";
			break;
		case 1:
			monthString = "Feb";
			break;
		case 2:
			monthString = "Mar";
			break;
		case 3:
			monthString = "Apr";
			break;
		case 4:
			monthString = "May";
			break;
		case 5:
			monthString = "Jun";
			break;
		case 6:
			monthString = "Jul";
			break;
		case 7:
			monthString = "Aug";
			break;
		case 8:
			monthString = "Sept";
			break;
		case 9:
			monthString = "Oct";
			break;
		case 10:
			monthString = "Nov";
			break;
		case 11:
			monthString = "Dec";
			break;
		default:
			monthString = "Invalid Month";
			break;
		}
		
		dateString = monthString + " " + myDay + ", " + myYear;
		return dateString;
	}
}

	/*Handler myHandler = new Handler() {
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
				dateTextView.setText(dateString);
			}
 
		};
 
		dateButton.setOnClickListener(listener);
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	} 

}*/
