package com.example.littepro_clinicregistered;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	private EditText etName;
	private TextView tvMsg;
	private Spinner spnSex, spnDivision, spnDoctor, spnClinicTime;
	private Button btnDetermine,btnLeave;
	String stSex, stDivision, stDoctor, stClinicTime, msg;
	
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
        
    private OnItemSelectedListener spnSexListener = new OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
//			Toast.makeText(MainActivity.this, ""+id, Toast.LENGTH_SHORT).show();
//			Toast.makeText(MainActivity.this, 
//					parent.getItemAtPosition(position).toString(), 
//					Toast.LENGTH_SHORT).show();
			stSex = parent.getSelectedItem().toString();
			
//			String Name = etName.getText().toString();
//			tvMsg.setText(Name + stClinicRg);
			
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
    	
    };
    
    
//  private String[] MedicineDtor = {"令狐沖", "任盈盈"};//內科醫師
//  private String[] SurgicalDtor = {"楊過", "小龍女"};//外科醫師
//  private String[] ObstetricsDtor = {"郭靖", "黃蓉"};//婦產科醫師
    
    private OnItemSelectedListener spnDivisionListener = new OnItemSelectedListener(){
    	
		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
			int position, long id) {

			
			//選擇內科
			if((parent.getSelectedItem().toString()).equals("內科")){
				String[] MedicineDtor = {"令狐沖", "任盈盈"};//內科醫師
				ArrayAdapter<String> MDoctors = new ArrayAdapter<String>
				(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, MedicineDtor);
				
				spnDoctor.setAdapter(MDoctors);
				
				stDivision = parent.getSelectedItem().toString();
				
			
			//選擇外科
			}else if((parent.getSelectedItem().toString()).equals("外科")){
				String[] SurgicalDtor = {"楊過", "小龍女"};//外科醫師
				ArrayAdapter<String> SDoctors = new ArrayAdapter<String>
				(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, SurgicalDtor);
				
				spnDoctor.setAdapter(SDoctors);
				
				stDivision = parent.getSelectedItem().toString();
	
				
			//選擇婦產科
			}else if((parent.getSelectedItem().toString()).equals("婦產科")){
				String[] ObstetricsDtor = {"郭靖", "黃蓉"};//婦產科醫師
				ArrayAdapter<String> ODoctors = new ArrayAdapter<String>
					(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, ObstetricsDtor);
				
				spnDoctor.setAdapter(ODoctors);
				
				stDivision = parent.getSelectedItem().toString();
				
//				position 是spnDivisionListener的，因此出現 
//				indexoutofboundsexception index 2 size 2
//				stDoctor = ODoctors.getItem(position);
			}
			
			
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
			tvMsg.setText(Name + stSex + "\n" + "您已掛" +  
			stDivision + ":" + stDoctor + "醫師");
		}
    	
    };
    
    private OnClickListener LeaveListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			finish();
			
		}
    	
    };
}//end class MainActivity.
