package com.example.littepro_ldealweight;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private EditText etHeight, etWeight;
	private RadioGroup rgGender;
	private TextView tvShow;
	private Button btnOk, btnLeave;
	private WeightCalculate wc;
	String stSex;
	String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wc = new WeightCalculate();
        buildViews();
    }
    
    private void buildViews(){
    	etHeight = (EditText)findViewById(R.id.etIdHeight);
    	etWeight = (EditText)findViewById(R.id.etIdWeight);
    	
    	rgGender = (RadioGroup)findViewById(R.id.rgIdSex);
    	rgGender.setOnCheckedChangeListener(genderListener);
    	
    	tvShow = (TextView)findViewById(R.id.tvShow);
    	
    	btnOk = (Button)findViewById(R.id.btnDetermine);
    	btnLeave = (Button)findViewById(R.id.btnLeave);
    	btnOk.setOnClickListener(okListener);
    	btnLeave.setOnClickListener(leaveListener);
    }
    
    private OnClickListener okListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
//			int nowWeight =  Integer.parseInt(etWeight.getText().toString()); 
			float nowHeight =  Float.parseFloat(etHeight.getText().toString());
			float nowWeight = Float.parseFloat(etWeight.getText().toString());
			
//			原本寫法:錯誤
//			try {
//				if((nowHeight < 110) || nowHeight > 210){
//					throw new Exception();
//				}
//			} catch (Exception e) {
//				tvShow.setText("身高不正確，成人應介於110至210之間");
////				e.printStackTrace();
//			}
			
			
//			if((nowHeight < 110) || nowHeight > 210){
//				try {
//					throw new Exception();
//				} catch (Exception e) {
//					tvShow.setText("身高不正確，成人應介於110至210之間");
//					return;
//				}
			
			//判斷身高
			if((nowHeight < 110) || nowHeight > 210){
				tvShow.setText("身高不正確，成人應介於110至210之間");
				return;
			}
			
			//判斷體重
			if((nowWeight < 25) || (nowWeight > 200)){
				tvShow.setText("體重不正確，成人應介於25至200之間");
			}else{
				int checkedRB =  rgGender.getCheckedRadioButtonId();
				switch(checkedRB){
				//男性選項
				case R.id.rbIdMale:
					float mHeight = Float.parseFloat(etHeight.getText().toString());
					float idealMale = wc.maleCalculate(mHeight);
					
					if(nowWeight - idealMale > (idealMale*0.1f)){
						msg = "你稍微胖了些，請少飲酒少應酬!";
					}else if((idealMale - nowWeight) > (idealMale *0.1f)) {
						msg = "你稍微瘦了些，請多補充些營養!";
					}else{
						msg = "你的體態控制的不錯!";
					}

					tvShow.setText("你的理想體重為 " + idealMale + "公斤" + "\n" + msg);
					break;
				
				//女性選項	
				case R.id.rbIdFemale:
					float fHeight = Float.parseFloat(etHeight.getText().toString());
					float idealFemale = wc.femaleCalculate(fHeight);
					
					if(nowWeight - idealFemale > (idealFemale*0.1f)){
						msg = "妳稍微胖了些，請節制飲食多做運動!";
					}else if((idealFemale - nowWeight) > (idealFemale *0.1f)) {
						msg = "妳稍微瘦了些，請多補充些營養!";
					}else{
						msg = "妳的身材維持得很好!";
					}

					
					tvShow.setText("妳的理想體重為 " + idealFemale + "公斤" + "\n" + msg);
					break;
				}
			}
		}
    	
    };
    private OnClickListener leaveListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			System.exit(0);
			
		}
    	
    };
    

	private OnCheckedChangeListener genderListener = new OnCheckedChangeListener(){

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
//			int checkedRB =  rgGender.getCheckedRadioButtonId();
//			switch(checkedRB){
//			case R.id.rbIdMale:
//				int heightM = Integer.parseInt(etHeight.getText().toString());
//				float male = wc.maleCalculate(heightM);
//				
//				tvShow.setText("你的理想體重為 " + male + "公斤");
//				
//				stSex = "男性";
//				break;
//			case R.id.rbIdFemale:
//				int heightF = Integer.parseInt(etHeight.getText().toString());
//				float female = wc.femaleCalculate(heightF);
//				
//				tvShow.setText("妳的理想體重為 " + female + "公斤");
//				
//				stSex = "女性";
//				break;
//			}
			
		}
    	
    };
}
