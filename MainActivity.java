package edu.ucsb.cs.cs185.tyralyn.tyralynScoring;

import java.util.Calendar;


//import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
//import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
//import android.widget.DatePicker;
import android.widget.TextView;
//import android.os.Build;

public class MainActivity extends android.support.v4.app.FragmentActivity implements OnClickListener {

	Button dateButton, gameButton, nextButton;
	TextView dateTextView, firstTeam, firstTeamScore, secondTeam, secondTeamScore; 
	String dateString = "blah";
	int myDay, myMonth, myYear;
	int myHour, myMinute;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dateButton = (Button) findViewById(R.id.date_button);
		dateTextView= (TextView) findViewById(R.id.date_text);
		gameButton = (Button) findViewById(R.id.game_button);
		firstTeam= (TextView) findViewById(R.id.date_text);
		firstTeamScore= (TextView) findViewById(R.id.date_text);
		secondTeam= (TextView) findViewById(R.id.date_text);
		secondTeamScore= (TextView) findViewById(R.id.date_text);
		nextButton = (Button) findViewById(R.id.next_button);
		String[] teams = {
				"Hello, Android - Ed Burnette",
				"Professional Android 2 App Dev - Reto Meier",
				"Unlocking Android - Frank Ableson",
				"Android App Development - Blake Meike",
				"Pro Android 2 - Dave MacLean",
				"Beginning Android 2 - Mark Murphy",
				"Android Programming Tutorials - Mark Murphy",
				"Android Wireless App Development - Lauren Darcey",
				"Pro Android Games - Vladimir Silva",
				};
        ArrayAdapter<String> adapter = 
                new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, teams);

		AutoCompleteTextView a = (AutoCompleteTextView) findViewById(R.id.second_team_name);
        a.setAdapter(adapter);
        
		
		dateButton.setOnClickListener(this);
		gameButton.setOnClickListener(this);
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
		
		else if (v==gameButton) {
			dateTextView.setText("jijijiji");
			//FragmentManager fm = getSupportFragmentManager();
			//enterTeamsFragment ETF = new enterTeamsFragment();
			//ETF.show(this.getSupportFragmentManager(), "MyDialog");
			showEnterTeamsFragment();

		}
	}
	
	private void showEnterTeamsFragment() {
        FragmentManager fm = getFragmentManager();
        enterTeamsFragment editNameDialog = new enterTeamsFragment();
        editNameDialog.show(fm, "fragment_edit_name");
	}
}
 