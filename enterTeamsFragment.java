package edu.ucsb.cs.cs185.tyralyn.tyralynScoring;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class enterTeamsFragment extends DialogFragment {
	String team1; String team2, score1, score2;
	TextView firstTeamPrompt, firstScorePrompt, secondTeamPrompt, secondScorePrompt;
	EditText firstScore, secondScore;
	AutoCompleteTextView firstTeamName, secondTeamName;
	Button doneButton;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
        String[] teams = getResources().getStringArray(R.array.teams_array);
        ArrayAdapter<String> adapter = 
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, teams);
        
        
		View view = inflater.inflate(R.layout.fragment_main, container);
        firstTeamPrompt=(TextView) view.findViewById(R.id.first_team);
        firstTeamName=(AutoCompleteTextView) view.findViewById(R.id.first_team_name);
        firstScorePrompt=(TextView) view.findViewById(R.id.first_team_score);
        firstScore=(EditText) view.findViewById(R.id.first_team_score_value);
        secondTeamPrompt=(TextView) view.findViewById(R.id.second_team);
        secondTeamName=(AutoCompleteTextView) view.findViewById(R.id.second_team_name);
        secondScorePrompt=(TextView) view.findViewById(R.id.second_team_score);
        secondScore=(EditText) view.findViewById(R.id.second_team_score_value);
        doneButton = (Button) view.findViewById(R.id.done_button);
        firstTeamName.setThreshold(2);
        firstTeamName.setAdapter(adapter);
        secondTeamName.setThreshold(2);
        secondTeamName.setAdapter(adapter);
        
        doneButton.setOnClickListener(new OnClickListener() {
        	public void onClick( View v) {
        		team1=firstTeamName.getText().toString();
        		team2=secondTeamName.getText().toString();
        		score1=firstScore.getText().toString();
        		score2=secondScore.getText().toString();
        		
        		dismiss();
        		
        	}
        });
        getDialog().setTitle("Hello");

        return view;
    }
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstance) {
		Dialog dialog = super.onCreateDialog(savedInstance);
		return dialog;
	}
}
