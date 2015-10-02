package com.example.sharedpreferencestest3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        userName = (EditText)findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText2);
    }
    
    //XML 加入屬性 android:onClick="save"
    //然後在Activity 加入 method:
    public void save(View view){
    	//設定偏好檔
    	SharedPreferences  sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
    	SharedPreferences.Editor editor = sharedPreferences.edit();
    	editor.putString("name", userName.getText().toString());
    	editor.putString("password", password.getText().toString());
    	editor.commit();
    	
    	
    	Toast.makeText(MainActivity.this, "Data was saved successfully ", Toast.LENGTH_LONG).show();
    }
    
    //intent:到 ActivityB.class
    public void next(View view){
    	Toast.makeText(MainActivity.this, "Next", Toast.LENGTH_LONG).show();
    	Intent intent = new Intent(this, ActivityB.class);
    	startActivity(intent);
    }
}
