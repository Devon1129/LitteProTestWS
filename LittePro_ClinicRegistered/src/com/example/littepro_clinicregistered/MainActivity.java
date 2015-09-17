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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText etName;
	private TextView tvMsg;
	private Spinner spnSex, spnDivision, spnDoctor, spnClinicTime;
	private Button btnDetermine,btnLeave;
	String stClinicRg, msg;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buildViews();
    }
    
    private void buildViews(){
    	etName = (EditText)findViewById(R.id.etIdName);
    	tvMsg = (TextView)findViewById(R.id.tvMsg);
    	
    	spnSex = (Spinner)findViewById(R.id.spnIdSex);
    	ArrayAdapter<CharSequence> adSexList = ArrayAdapter.createFromResource(
    			this, R.array.spnSex, android.R.layout.simple_spinner_dropdown_item);
    	spnSex.setAdapter(adSexList);
    	spnSex.setOnItemSelectedListener(spnSexListener);
    	
    	
    	spnDivision = (Spinner)findViewById(R.id.spnIdDivisions);
    	ArrayAdapter<CharSequence> adDivisionList = ArrayAdapter.createFromResource(
    			this, R.array.spnDivisions, android.R.layout.simple_spinner_dropdown_item);
    	spnDivision.setAdapter(adDivisionList);
    	spnDivision.setOnItemSelectedListener(spnDivisionListener);
    	
    	spnDoctor = (Spinner)findViewById(R.id.spnIdDoctor);
    	spnClinicTime = (Spinner)findViewById(R.id.spnIdClinicTime);
    	
    	btnDetermine = (Button)findViewById(R.id.btnDetermine);
    	btnDetermine.setOnClickListener(determineListener);
    	
    	btnLeave = (Button)findViewById(R.id.btnLeave);
    	btnLeave.setOnClickListener(LeaveListener);
    }
    
//    private String[] doctors = {"令狐沖", "任盈盈", "楊過", "小龍女", "郭靖", "黃蓉"};
    private OnItemSelectedListener spnSexListener = new OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
//			Toast.makeText(MainActivity.this, ""+id, Toast.LENGTH_SHORT).show();
//			Toast.makeText(MainActivity.this, 
//					parent.getItemAtPosition(position).toString(), 
//					Toast.LENGTH_SHORT).show();
			stClinicRg = parent.getSelectedItem().toString();
			
//			String Name = etName.getText().toString();
//			tvMsg.setText(Name + stClinicRg);
			
			
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
//			String Name = etName.getText().toString();
//			tvMsg.setText(Name);
			
			String Name = etName.getText().toString();
			tvMsg.setText(Name + stClinicRg);
		}
    	
    };
    
    private OnClickListener LeaveListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			finish();
			
		}
    	
    };
}//end class MainActivity.
