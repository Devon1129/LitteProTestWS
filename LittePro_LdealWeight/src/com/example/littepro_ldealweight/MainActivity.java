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
			
//			�쥻�g�k:���~
//			try {
//				if((nowHeight < 110) || nowHeight > 210){
//					throw new Exception();
//				}
//			} catch (Exception e) {
//				tvShow.setText("���������T�A���H������110��210����");
////				e.printStackTrace();
//			}
			
			
//			if((nowHeight < 110) || nowHeight > 210){
//				try {
//					throw new Exception();
//				} catch (Exception e) {
//					tvShow.setText("���������T�A���H������110��210����");
//					return;
//				}
			
			//�P�_����
			if((nowHeight < 110) || nowHeight > 210){
				tvShow.setText("���������T�A���H������110��210����");
				return;
			}
			
			//�P�_�魫
			if((nowWeight < 25) || (nowWeight > 200)){
				tvShow.setText("�魫�����T�A���H������25��200����");
			}else{
				int checkedRB =  rgGender.getCheckedRadioButtonId();
				switch(checkedRB){
				//�k�ʿﶵ
				case R.id.rbIdMale:
					float mHeight = Float.parseFloat(etHeight.getText().toString());
					float idealMale = wc.maleCalculate(mHeight);
					
					if(nowWeight - idealMale > (idealMale*0.1f)){
						msg = "�A�y�L�D�F�ǡA�Фֶ��s�����S!";
					}else if((idealMale - nowWeight) > (idealMale *0.1f)) {
						msg = "�A�y�L�G�F�ǡA�Цh�ɥR����i!";
					}else{
						msg = "�A����A�������!";
					}

					tvShow.setText("�A���z�Q�魫�� " + idealMale + "����" + "\n" + msg);
					break;
				
				//�k�ʿﶵ	
				case R.id.rbIdFemale:
					float fHeight = Float.parseFloat(etHeight.getText().toString());
					float idealFemale = wc.femaleCalculate(fHeight);
					
					if(nowWeight - idealFemale > (idealFemale*0.1f)){
						msg = "�p�y�L�D�F�ǡA�и`����h���B��!";
					}else if((idealFemale - nowWeight) > (idealFemale *0.1f)) {
						msg = "�p�y�L�G�F�ǡA�Цh�ɥR����i!";
					}else{
						msg = "�p�����������o�ܦn!";
					}

					
					tvShow.setText("�p���z�Q�魫�� " + idealFemale + "����" + "\n" + msg);
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
//				tvShow.setText("�A���z�Q�魫�� " + male + "����");
//				
//				stSex = "�k��";
//				break;
//			case R.id.rbIdFemale:
//				int heightF = Integer.parseInt(etHeight.getText().toString());
//				float female = wc.femaleCalculate(heightF);
//				
//				tvShow.setText("�p���z�Q�魫�� " + female + "����");
//				
//				stSex = "�k��";
//				break;
//			}
			
		}
    	
    };
}
