package com.example.littepro_clinicregistered;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {
	private EditText etName;
	private Spinner spnSex, spnDivision, spnDoctor, spnClinicTime;
	private Button btnDetermine,btnLeave;
	private String[] doctors = {"¥Oª°¨R", "¥ô¬Õ¬Õ", "·¨¹L", "¤pÀs¤k", "³¢¹t", "¶À»T"};
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buildViews();
    }
    
    private void buildViews(){
    	etName = (EditText)findViewById(R.id.etIdName);
    	
    	spnSex = (Spinner)findViewById(R.id.spnIdSex);
    	ArrayAdapter<CharSequence> adSexList = ArrayAdapter.createFromResource(
    			this, R.array.spnSex, android.R.layout.simple_spinner_dropdown_item);
    	adSexList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spnSex.setAdapter(adSexList);
    	spnSex.setOnItemSelectedListener(spnSexListener);
    	
    	
    	spnDivision = (Spinner)findViewById(R.id.spnIdDivisions);
    	ArrayAdapter<CharSequence> adDivisionList = ArrayAdapter.createFromResource(
    			this, R.array.spnDivisions, android.R.layout.simple_spinner_dropdown_item);
    	adDivisionList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spnDivision.setAdapter(adDivisionList);
    	spnDivision.setOnItemSelectedListener(spnDivisionListener);
    	
    	spnDoctor = (Spinner)findViewById(R.id.spnIdDoctor);
    	spnClinicTime = (Spinner)findViewById(R.id.spnIdClinicTime);
    	
    	btnDetermine = (Button)findViewById(R.id.btnDetermine);
    	btnLeave = (Button)findViewById(R.id.btnLeave);
    	btnDetermine.setOnClickListener(determineListener);
    	btnLeave.setOnClickListener(LeaveListener);
    }
    
    private OnItemSelectedListener spnSexListener = new OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
    	
    };
    
    private OnItemSelectedListener spnDivisionListener = new OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			
//			ArrayAdapter<String> adapterD1 = new ArrayAdapter<String>(
//					this, android.R.layout.simple_spinner_item, doctors);
//			spnDoctor.setAdapter(adapterD1);
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
    	
    };
    
    private OnClickListener determineListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
    	
    };
    
    private OnClickListener LeaveListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
    	
    };
}//end class MainActivity.
