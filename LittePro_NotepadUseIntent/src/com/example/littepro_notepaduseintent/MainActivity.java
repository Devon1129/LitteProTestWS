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
    	mListview = getListView();//extends ListActivity��神瘜�ML��神瘜���撖急��� 
    	mMapAry = new ArrayList<Map<String, Object>>();
    	
    	//撠��� ArrayList鋆�
    	for(int i = 0; i < mType.length; i++){
    		Map<String, Object> items = new HashMap<String, Object>();
    		items.put(Constants.TYPE_KEY, mType[i]);
    		items.put(Constants.TITLE_KEY, mTitles[i]);
    		mMapAry.add(items);
    	}
    	
    	//�� adapter����
    	mAdapter = new SimpleAdapter(this, mMapAry, R.layout.listview_row,
    			new String[]{Constants.TYPE_KEY, Constants.TITLE_KEY},
    			new int[]{R.id.textView1, R.id.textView2});
    	
    	//撠��末��� adapter閮剔策 mListview 
    	mListview.setAdapter(mAdapter);
    }
   
    //ListActivity��� method. 
    //���� extends ListActivity��蝙�
    //ListView暺��������
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		//撠� position(雿蔭)��嚗霈隞� code雿輻
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
