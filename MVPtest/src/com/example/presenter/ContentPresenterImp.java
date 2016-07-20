package com.example.presenter;

import java.util.ArrayList;
import java.util.List;

import com.example.module.UserContentLoader;
import com.example.view.ContentView;
import com.example.view.MainActivity;

public class ContentPresenterImp implements ContentPresenter {

	private ContentView contentView;
	private List<String> list;
	private UserContentLoader contentLoader;

	public ContentPresenterImp(ContentView view){        
		contentView=view;
		list=new ArrayList<String>();
		contentLoader=new UserContentLoader();
	}

	@Override
	public void onItemClicked(int position) {
		// TODO Auto-generated method stub
		list.remove(position);
		contentView.updateListView();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		contentView.setAdapterForListView(list);
		list.clear();
		list.addAll(contentLoader.loadContentListFromLocalDB());
		contentView.updateListView();
	}

	@Override   
	public void backToMain() {
		// TODO Auto-generated method stub
		contentView.finishActivity();
	}

}
