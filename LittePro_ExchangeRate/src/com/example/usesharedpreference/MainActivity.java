package com.example.usesharedpreference;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private EditText etExchangeRate, etNT;
	private TextView tv;
	private Button btnCalc;
	
	public static final String PREF_ExchangeRate = "Exchange_Rate";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        etExchangeRate = (EditText)findViewById(R.id.editText1);
        etNT = (EditText)findViewById(R.id.editText2);
        tv = (TextView)findViewById(R.id.tvresult);
        
        btnCalc = (Button)findViewById(R.id.button1);
        btnCalc.setOnClickListener(btnClickListener);
    }
    
    private OnClickListener btnClickListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			double ExchangeRate = Double.parseDouble(etExchangeRate.getText().toString());
			double NTD = Double.parseDouble(etNT.getText().toString());
			
			//小數點格式:顯示小數點後兩位
			NumberFormat NF = new DecimalFormat(".##");
			
			/*
			 *CharSequence android.content.Context.getText(int resId):
			 *getText(R.string.result):要 call getText()，才抓得到 R檔 裡的 string，
			 *後面接上顯示小數點後兩位的數字 string
			 *
			 */

			tv.setText(getText(R.string.result) + NF.format(NTD/ExchangeRate));
		}
    };


	@Override
	protected void onResume() {
		super.onResume();
		//讀取偏好設定
		SharedPreferences settings = getSharedPreferences(PREF_ExchangeRate, Context.MODE_PRIVATE);
		etExchangeRate.setText(settings.getString("ExchangeRate", "No things?"));
	}

	@Override
	protected void onPause() {
		super.onPause();
		//儲存偏好設定
		SharedPreferences settings = getSharedPreferences(PREF_ExchangeRate, Context.MODE_PRIVATE);
		settings.edit()
		.putString("ExchangeRate", etExchangeRate.getText().toString())
		.commit();
		
	}
}
