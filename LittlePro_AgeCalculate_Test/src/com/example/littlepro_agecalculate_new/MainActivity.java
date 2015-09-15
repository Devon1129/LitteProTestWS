package com.example.littlepro_agecalculate_new;

import java.text.ParseException;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText etYYYY, etMM, etdd;
	private Button btnResult;
	private Test test;
	private String msg;
	private int result;
	private int[] MMdate = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buildViews();
    }
    
    private void buildViews(){
    	etYYYY = (EditText)findViewById(R.id.etYYYY);
        etMM = (EditText)findViewById(R.id.etMM);
        etdd = (EditText)findViewById(R.id.etdd);
        
        btnResult = (Button)findViewById(R.id.btnResults);
        btnResult.setOnClickListener(ResultListener);
    }
    
    private OnClickListener ResultListener;
    
    private void ShowMsgAlertDialog(String msg){
    	Builder MyAlertDialog = new AlertDialog.Builder(this);
//    	MyAlertDialog.setTitle("你現在輸入的實際年齡為 " + msg + "歲");
    	MyAlertDialog.setMessage(msg);
    	DialogInterface.OnClickListener OkClick = new DialogInterface.OnClickListener() {

    		@Override
			public void onClick(DialogInterface dialog, int which) {
    			
			}//end onClick.
		};//end okClick.
		MyAlertDialog.setNeutralButton("確定!!!", OkClick);
		MyAlertDialog.show();
    	
    }//end ShowMsgAlertDialog.
}
