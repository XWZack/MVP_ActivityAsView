package com.example.view;

import java.util.List;

public interface ContentView {

	void setAdapterForListView(List<String> list);
	void updateListView();
	void finishActivity();
}
