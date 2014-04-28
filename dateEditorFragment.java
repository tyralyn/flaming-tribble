package edu.ucsb.cs.cs185.tyralyn.tyralynScoring;

import android.support.v4.app.FragmentActivity;
import android.widget.DatePicker;
import android.app.DatePickerDialog;

public class dateEditorFragment extends FragmentActivity 
					implements DatePickerDialog.OnDateSetListener {
	String dateString="Date";
	@Override
	public void onDateSet(DatePicker view, int year, int month, int day) {
		dateString = getDateString(month, day, year);
		
	}
	
	public String getDateString(int myMonth, int myDay, int myYear) {
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
