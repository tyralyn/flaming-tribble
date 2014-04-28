package edu.ucsb.cs.cs185.tyralyn.tyralynScoring;

import java.util.Calendar;

import android.support.v4.app.DialogFragment;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.DatePicker;

public class DatePickerFragment extends DialogFragment  {
	Handler myHandler;
	int myDay=15, myMonth=7, myYear=2013;
	
	public DatePickerFragment() {
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) { 
		Bundle b = getArguments();
		
        final Calendar c = Calendar.getInstance();
        myYear = c.get(Calendar.YEAR);
        myMonth = c.get(Calendar.MONTH);
        myDay = c.get(Calendar.DAY_OF_MONTH); 
        //dateEditorFragment listener = new 
		DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
			@Override
			public void onDateSet(DatePicker view, int year, int month, int day) {
				myDay = day;
				myMonth = month;
				myYear = year;
				Bundle b = new Bundle();
				b.putInt("setDay", myDay);
				b.putInt("setMonth", myMonth);
				b.putInt("setYear", myYear);
				//b.putString("setDate",getDateString());
				Message message = new Message();
				message.setData(b);
				myHandler.sendMessage(message);
			}
			
		};
		return new DatePickerDialog(getActivity(), listener, myYear, myMonth, myDay);
	}
	
	public String getDateString() {
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
