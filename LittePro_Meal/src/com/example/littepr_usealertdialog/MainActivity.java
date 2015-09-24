package com.example.littepr_usealertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
//import android.app.AlertDialog.Builder;


public class MainActivity extends Activity {
	private Button btnInter;
	private TextView tvShow;
	
	private AlertDialog.Builder order;
	String[] hamburger = {"美味蟹堡","義式香腸堡","蔬菜水果堡","香蕉潛艇堡","香烤雞肉堡"};
	boolean[] checkedItems = new boolean[5];
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tvShow = (TextView)findViewById(R.id.tvShow);
        btnInter = (Button)findViewById(R.id.btnInter);
        btnInter.setOnClickListener(btnInterListener);
        order = new AlertDialog.Builder(this);
        order.setTitle(R.string.show);
        order.setPositiveButton("確認", listener);
        order.setNegativeButton("離開", listener);
        order.setMultiChoiceItems(hamburger, checkedItems, muListener);
        
    }
    
    //點擊 Button顯示 AlertDialog視窗
    private OnClickListener btnInterListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			order.show();
			
		}
    };
    
    //點擊 AlertDialog Button的事件反應
    private DialogInterface.OnClickListener listener = 
		new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch(which){
				case Dialog.BUTTON_POSITIVE:
					checkFood();
					break;
					
				case Dialog.BUTTON_NEGATIVE:
					break;
				}
				
			}
		};
			
	//點擊 MultiChoiceItems時的事件反應
	private DialogInterface.OnMultiChoiceClickListener muListener = 
		new DialogInterface.OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				// TODO Auto-generated method stub
//				checkedItems[which] = isChecked;
//				AlertDialog.Builder 會同步更新 checkedItems陣列的值
				
			}
		};  
			
	//將點選的 MultiChoiceItems附加到 tvShow呈現
	private void checkFood(){
		tvShow.setText(R.string.show);
		for(int i = 0; i < hamburger.length; i++){
			if(checkedItems[i]){
				tvShow.append("\n" + hamburger[i]);
			}
		}
		
	}
}
