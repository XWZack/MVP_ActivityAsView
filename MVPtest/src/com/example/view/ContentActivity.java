package com.example.view;


import java.util.List;

import com.example.mvptest.R;
import com.example.presenter.ContentPresenter;
import com.example.presenter.ContentPresenterImp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ContentActivity extends Activity implements OnItemClickListener,ContentView,OnClickListener{

	private ListView listView;
	private TextView backBtn;
	private BaseAdapter listAdapter;
	private ContentPresenter presenter;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		listView=(ListView)findViewById(R.id.lv_content);
		listView.setOnItemClickListener(this);
		backBtn=(TextView)findViewById(R.id.btn_back);
		backBtn.setOnClickListener(this);
		presenter=new ContentPresenterImp(this);
	}

	@Override
	public void onResume(){
		super.onResume();
		presenter.onResume();
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		presenter.onItemClicked(position);
	}

	@Override
	public void setAdapterForListView(List<String> list) {
		// TODO Auto-generated method stub
		listAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
		listView.setAdapter(listAdapter);
	}

	@Override
	public void updateListView() {
		// TODO Auto-generated method stub
		listAdapter.notifyDataSetChanged();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		presenter.backToMain();
	}

	@Override
	public void finishActivity() {
		// TODO Auto-generated method stub
		this.finish();
	}
}
