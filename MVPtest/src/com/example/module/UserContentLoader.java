package com.example.module;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;

public class UserContentLoader {

	public UserContentLoader(){
		
	}

	public List<String> loadContentListFromLocalDB(){
		List<String> list=new ArrayList<String>();
		for(int i=0;i<10;i++){
			list.add(String.valueOf(i+1));
		}
		return list;		
	}
}
