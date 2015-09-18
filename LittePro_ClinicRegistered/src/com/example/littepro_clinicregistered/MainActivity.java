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
    	spnDoctor.setOnItemSelectedListener(spnDoctorListener);
    	
    	spnClinicTime = (Spinner)findViewById(R.id.spnIdClinicTime);
    	spnClinicTime.setOnItemSelectedListener(spnCTListener);
    	
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
			
			stDivision = parent.getSelectedItem().toString();
			//選擇內科
			if(stDivision.equals("內科")){
				String[] MedicineDtor = {"令狐沖", "任盈盈"};//內科醫師
				ArrayAdapter<String> MDoctors = new ArrayAdapter<String>
				(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, MedicineDtor);
				spnDoctor.setAdapter(MDoctors);
				
				
			//選擇外科
			}else if(stDivision.equals("外科")){
				String[] SurgicalDtor = {"楊過", "小龍女"};//外科醫師
				ArrayAdapter<String> SDoctors = new ArrayAdapter<String>
				(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, SurgicalDtor);
				
				spnDoctor.setAdapter(SDoctors);
				
//				stDivision = parent.getSelectedItem().toString();
	
				
			//選擇婦產科
			}else if(stDivision.equals("婦產科")){
				String[] ObstetricsDtor = {"郭靖", "黃蓉"};//婦產科醫師
				ArrayAdapter<String> ODoctors = new ArrayAdapter<String>
					(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, ObstetricsDtor);
				
				spnDoctor.setAdapter(ODoctors);
				
//				stDivision = parent.getSelectedItem().toString();
				
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
    
    //醫師 spinner
    private OnItemSelectedListener spnDoctorListener = new OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
//			String[] LingDtorCT = {"星期一早上","星期二晚上","星期三晚上","星期四下午","星期五晚上"};
//			String[] RenDtorCT = {"星期一下午","星期二早上","星期三下午","星期四早上","星期五下午"};
//			String[] YangDtorCT = {"星期一晚上","星期二晚上","星期三早上","星期四下午","星期五晚上"};
//			String[] XlaoDtorCT = {"星期一下午","星期二早上","星期三晚上","星期四早上","星期五下午"};
//			String[] GuoDtorCT = {"星期一晚上","星期二下午","星期三晚上","星期四下午","星期五晚上"};
//		　
			
			//令狐沖醫師
			stDoctor = parent.getSelectedItem().toString();
			if(stDoctor.equals("令狐沖")){
				String[] LingDtorCT = {"星期一早上","星期二晚上","星期三晚上","星期四下午","星期五晚上"};
				ArrayAdapter<String> LinCTList = new ArrayAdapter<String>(
						MainActivity.this, 
						android.R.layout.simple_spinner_dropdown_item, LingDtorCT);
				spnClinicTime.setAdapter(LinCTList);
				
			//任盈盈醫師
			}else if(stDoctor.equals("任盈盈")){
				String[] RenDtorCT = {"星期一下午","星期二早上","星期三下午","星期四早上","星期五下午"};
				ArrayAdapter<String> RenCTList = new ArrayAdapter<String>(
						MainActivity.this, 
						android.R.layout.simple_spinner_dropdown_item, RenDtorCT);
				spnClinicTime.setAdapter(RenCTList);
				
			//楊過醫師
			}else if(stDoctor.equals("楊過")){
				String[] YangDtorCT = {"星期一晚上","星期二晚上","星期三早上","星期四下午","星期五晚上"};
				ArrayAdapter<String> YangCTList = new ArrayAdapter<String>(
						MainActivity.this, 
						android.R.layout.simple_spinner_dropdown_item, YangDtorCT);
				spnClinicTime.setAdapter(YangCTList);
			
			//小龍女醫師	
			}else if(stDoctor.equals("小龍女")){
				String[] XlaoDtorCT = {"星期一下午","星期二早上","星期三晚上","星期四早上","星期五下午"};
				ArrayAdapter<String> XlaoCTList = new ArrayAdapter<String>(
						MainActivity.this, 
						android.R.layout.simple_spinner_dropdown_item, XlaoDtorCT);
				spnClinicTime.setAdapter(XlaoCTList);
				
			//郭靖醫師
			}else if(stDoctor.equals("郭靖")){
				String[] GuoDtorCT = {"星期一晚上","星期二下午","星期三晚上","星期四下午","星期五晚上"};
				ArrayAdapter<String> GuoCTList = new ArrayAdapter<String>(
						MainActivity.this, 
						android.R.layout.simple_spinner_dropdown_item, GuoDtorCT);
				spnClinicTime.setAdapter(GuoCTList);
			
			//黃蓉醫師
			}else if(stDoctor.equals("黃蓉")){
				String[] HuangDtorCT = {"星期一下午","星期二早上","星期三早上","星期四早上","星期五早上"};
				ArrayAdapter<String> HuangCTList = new ArrayAdapter<String>(
						MainActivity.this,
						android.R.layout.simple_spinner_dropdown_item, HuangDtorCT);
				spnClinicTime.setAdapter(HuangCTList);
			}
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
    	
    };
    
    
    private OnItemSelectedListener  spnCTListener = new OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			 stClinicTime = parent.getItemAtPosition(position).toString();
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
    	
    };
    
    private OnClickListener determineListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			
			String Name = etName.getText().toString().trim();
//			if(!Name.equals("")){
//				tvMsg.setText(Name + stSex + "您好\n" +
//					"您掛的門診為" + stDivision +  "\n" + 
//					 "門診時段為:" + stClinicTime + "\n" +
//					 "為您看診的是:" + stDoctor + "醫師");
//			}else{
//				tvMsg.setText("尚未完成掛號");
//			}
			
			//這個邏輯性比較順
			if(Name.equals("")){
				tvMsg.setText("請輸入姓名");
			}else{
				tvMsg.setText(Name + stSex + "您好\n" +
					"您掛的門診為" + stDivision +  "\n" + 
					 "門診時段為:" + stClinicTime + "\n" +
					 "為您看診的是:" + stDoctor + "醫師");
			}
			
		}
    	
    };
    
    //離開程式
    private OnClickListener LeaveListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			finish();
			
		}
    	
    };
}//end class MainActivity.
