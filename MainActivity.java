package edu.ucsb.cs.cs185.tyralyn.tyralynScoring;

import java.util.Calendar;




//import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.app.DatePickerDialog;
import android.app.Activity;
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

public class MainActivity extends Activity implements OnClickListener {

	Button dateButton, gameButton, nextButton;
	TextView dateTextView; 
	String dateString = "blah";
	int myDay, myMonth, myYear;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dateButton = (Button) findViewById(R.id.date_button);
		dateTextView= (TextView) findViewById(R.id.date_text);
		gameButton = (Button) findViewById(R.id.game_button);
		nextButton = (Button) findViewById(R.id.next_button);
		
		dateButton.setOnClickListener(this);
	}
	
	public String makeDateString(DatePicker view, int year, int month, int day) {
		String monthString;
		switch (month) {
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
		myMonth = month;
		myDay = day;
		myYear = year;
		dateString = monthString + " " + Integer.toString(day) + ", " + Integer.toString(year);
		return dateString;
	}

	
	@Override
	public void onClick(View v){
		if (v==dateButton) {
			final Calendar c = Calendar.getInstance();
		    myYear = c.get(Calendar.YEAR);
		    myMonth = c.get(Calendar.MONTH);
		    myDay = c.get(Calendar.DAY_OF_MONTH);
			
			DatePickerDialog myDPD = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
				@Override 
				public void onDateSet(DatePicker view, int year, int month, int day) {
					dateTextView.setText(makeDateString(view, year, month, day));
				}
			}, myYear, myMonth, myDay);
			myDPD.show();
		}
	}
}
 