package com.example.littepro_notepaduseintent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import com.example.test.Constants;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	private ListView mListview;
	private ArrayList<Map<String, Object>> mMapAry;
	private SimpleAdapter mAdapter;
	
	private String[] mType = {"Reminder", "Reminder", "Reminder", "Urgent", "Urgent"};
	private String[] mTitles = {"a", "b", "c", "d", "e"};
	private int mSelectedPosition = -1;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     
        addArrayListEnterListView();
    }
    
    private void addArrayListEnterListView(){
    	mListview = getListView();//extends ListActivity的寫法，XML的寫法也應更改寫法。
    	mMapAry = new ArrayList<Map<String, Object>>();
    	
    	//將數據加到 ArrayList裡
    	for(int i = 0; i < mType.length; i++){
    		Map<String, Object> items = new HashMap<String, Object>();
    		items.put(Constants.TYPE_KEY, mType[i]);
    		items.put(Constants.TITLE_KEY, mTitles[i]);
    		mMapAry.add(items);
    	}
    	
    	//利用 adapter配對後，呈現畫面
    	mAdapter = new SimpleAdapter(this, mMapAry, R.layout.listview_row,
    			new String[]{Constants.TYPE_KEY, Constants.TITLE_KEY},
    			new int[]{R.id.textView1, R.id.textView2});
    	
    	
    	mListview.setAdapter(mAdapter);
    }
   
    //ListActivity的 method. 
    //搭配 extends ListActivity時使用
    //ListView點擊項目時的反應
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// 將 position(位置)抓出，可讓其他 code使用
		mSelectedPosition = position;
		
		Intent intent = new Intent();
		
		Bundle bundle = new Bundle();
		bundle.putString(Constants.TYPE_KEY, 
				mMapAry.get(mSelectedPosition).get(Constants.TYPE_KEY).toString());
		bundle.putString(Constants.TITLE_KEY, 
				mMapAry.get(mSelectedPosition).get(Constants.TITLE_KEY).toString());
		
		intent.putExtras(bundle);
		
		intent.setClass(MainActivity.this, TodoDetails.class);
		startActivityForResult(intent, 0);

	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		Log.d("RETURN", data.getStringExtra(Constants.TITLE_KEY));
		Log.d("RETURN", "loc: " + mSelectedPosition);
		
		mMapAry.get(mSelectedPosition)
			.put(Constants.TYPE_KEY, 
					data.getStringExtra(Constants.TYPE_KEY));
		
		mMapAry.get(mSelectedPosition)
			.put(Constants.TITLE_KEY,
					data.getStringExtra(Constants.TITLE_KEY));
		
		mAdapter.notifyDataSetChanged();
	}
}
