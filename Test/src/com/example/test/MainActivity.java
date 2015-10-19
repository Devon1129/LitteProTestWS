package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {
	private ListView lv;
	private TextView tv1, tv2;
	private ArrayList<Map<String, Object>> mapAry;
	
	protected static final int MENU_BUTTON_1 = Menu.FIRST;
	protected static final int MENU_BUTTON_2 = Menu.FIRST + 1;
	
	String[] str1 = {"1", "2", "3", "4", "5"};
	String[] str2 = {"a", "b", "c", "d", "e"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lv = getListView();//extends ListActivity的寫法，XML的寫法也應更改寫法。 
        tv1 = (TextView)findViewById(R.id.tv1_row);
        tv2 = (TextView)findViewById(R.id.tv2_row);
        mapAry = new ArrayList<Map<String, Object>>();
        
       //將數據加到 ArrayList裡
        for(int i = 0; i < str1.length; i++){
        	Map<String, Object> items = new HashMap<String, Object>();
        	items.put("integer", str1[i]);
        	items.put("char", str2[i]);
        	mapAry.add(items);
        }
        
        //利用 adapter配對後，呈現畫面
        SimpleAdapter adapter = new SimpleAdapter(this, mapAry, R.layout.todo_row, 
       			new String[]{"integer", "char"} , new int[]{R.id.tv1_row, R.id.tv2_row});
        
        lv.setAdapter(adapter);
        
        
        
//        registerForContextMenu(findViewById(R.id.main_layout));
    }

    //搭配 extends ListActivity時使用
    //ListView點擊項目時的反應
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(this, TodoDetails.class);
		startActivity(intent);
	}

//	@Override
//	public void onCreateContextMenu(ContextMenu menu, View v,
//			ContextMenuInfo menuInfo) {
//		menu.setHeaderTitle("要如何處理這個項目?");	//設定長按選單的表頭
//		menu.add(0, MENU_BUTTON_1, 0, "按鈕1");
//		menu.add(0, MENU_BUTTON_2, 0, "按鈕2");
//		super.onCreateContextMenu(menu, v, menuInfo);
//	}
//
//	@Override
//	public boolean onContextItemSelected(MenuItem item) {
//		switch(item.getItemId()) {
//		case MENU_BUTTON_1:
//			//執行按鈕1要做的動作
//			break;
//		case MENU_BUTTON_2:
//			//執行按鈕2要做的動作
//			break;
//		default:
//			break;
//		}
//		return super.onContextItemSelected(item);
//	}

    
    
    
    
 
    
    
}
