package com.example.littepro_notepaduseintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TodoDetails extends Activity {
	private Button btn;
	private EditText et1;
	private Spinner spn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.todo_edit);
		
		buildViews();
	}
	
	public void buildViews(){
		spn = (Spinner)findViewById(R.id.spinner1);
		et1 = (EditText)findViewById(R.id.editText1);
		
		btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(btnListener);
		
		receiveIntentData();
		
		
		//點擊 spn項目時，做出的反應
		spn.setOnItemSelectedListener(new OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
	
				Toast.makeText(TodoDetails.this, position + " onClick", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
			}
		});
	}
	
	public void receiveIntentData(){
		Bundle bundle = getIntent().getExtras();
		
		String titleData = bundle.getString(Constants.TITLE_KEY);
		String typeData = bundle.getString(Constants.TYPE_KEY);
		
		//設定 spn的文字與傳過來的文字一致
		for(int i = 0; i < spn.getCount(); i++){
			String spnText = (String) spn.getItemAtPosition(i);
			
			//抓取 intent傳過來文字，設定成 spinner顯示的文字。
			if(spnText.equals(typeData)){
				spn.setSelection(i);
				break;//中斷 for迴圈
			}
		}
		et1.setText(titleData);
	}
	
	private OnClickListener btnListener = new OnClickListener(){
		@Override
		public void onClick(View v) {
			
			Intent intent = new Intent();
			
			//將資料直接放入 intent，intent裡有自己的 bundle
			//抓取 spn的項目。因 for迴圈內已設定好了，所以這裡可以直接抓取。
			intent.putExtra(Constants.TYPE_KEY, spn.getSelectedItem().toString());
			intent.putExtra(Constants.TITLE_KEY, et1.getText().toString());
			
			setResult(RESULT_OK, intent);
			
			finish();
			}
	};
}
