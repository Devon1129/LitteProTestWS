package com.example.sharedpreferencestest3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityB extends ActionBarActivity{
	
	//將 default設定成 static final
	public  static final String DEFAULT = "N/A";
	private TextView userNameTv, passwordTv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		userNameTv = (TextView)findViewById(R.id.textView2);
		passwordTv = (TextView)findViewById(R.id.textView4);
	}
	
	//讀取設定的偏好檔
	public void load(View view){
		SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
		String name = sharedPreferences.getString("name", DEFAULT);
		String password = sharedPreferences.getString("password", DEFAULT);
		
		//判斷讀取的 string，如果跟 default值一樣，則顯示 Toast: "No Data was Found"
		if(name.equals(DEFAULT) || password.equals(DEFAULT)){
			Toast.makeText(ActivityB.this, "No Data was Found", Toast.LENGTH_LONG).show();
		//不是 default的話，將讀取到的 string設給TextView
		}else{
			Toast.makeText(ActivityB.this, "Data Loaded Successfully", Toast.LENGTH_LONG).show();
			userNameTv.setText(name);
			passwordTv.setText(password);
		}
	}
	
	//回到 MainActivity.class
	public void previous(View view){
		Toast.makeText(ActivityB.this, "Previous", Toast.LENGTH_LONG).show();
		Intent intent = new Intent(ActivityB.this, MainActivity.class);
		startActivity(intent);
	}
	
	

}
