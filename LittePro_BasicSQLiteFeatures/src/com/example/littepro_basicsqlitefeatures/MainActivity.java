package com.example.littepro_basicsqlitefeatures;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText etInputText;
	private ListView lvShowInputText;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> items;
	private long selectedIndex = -1;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        etInputText = (EditText)findViewById(R.id.editText1);
        lvShowInputText = (ListView)findViewById(R.id.listView1);
        items = new ArrayList<String>();
        items.add("aaa");
        items.add("bbb");
        items.add("ccc");
        
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lvShowInputText.setAdapter(adapter);
        
        //set highlight.
        lvShowInputText.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				etInputText.setText(items.get(position));
				// clear all items
				for(int i =0; i <parent.getChildCount(); i++)
				{
					parent.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
					parent.getChildAt(i).setSelected(false);
				}
				
				view.setSelected(true);
				view.setBackgroundColor(Color.LTGRAY);
				//將抓取到的 item 另外存起來。
				selectedIndex = id;
			}
		});
    }

    //加入 MENU.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	//MENU項目的選擇
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case(R.id.add):
			if(!etInputText.getText().toString().equals("")){
				items.add(etInputText.getText().toString());
//				lvShowInputText.setAdapter(adapter);
				adapter.notifyDataSetChanged();
				etInputText.setText("");
			}
		break;
		
		case(R.id.modify):
			//第一版:移除再將加入
//			String itemString2 = items.get((int)selectedIndex);
//			items.remove(itemString2);
			
			//第二版:設定 ArrayList items，放在指定的 index，加入 String Object.
	/*
	 *		index the index at which to put the specified object.
	 *		object the object to add.
	 */
			if(!etInputText.getText().toString().equals("")){
//				items.add(etInputText.getText().toString().trim());
				items.set((int)selectedIndex, etInputText.getText().toString());
				adapter.notifyDataSetChanged();
				etInputText.setText("");
			}
			break;
			
		case(R.id.delete):
//			lvShowInputText.getSelectedItemId();
			String itemString = items.get((int)selectedIndex);
			items.remove(itemString);
			adapter.notifyDataSetChanged();
			etInputText.setText("");
			Toast.makeText(this, itemString, Toast.LENGTH_SHORT).show();
			break;
		}
		
		return true;
	}
	
	
    
    
}
