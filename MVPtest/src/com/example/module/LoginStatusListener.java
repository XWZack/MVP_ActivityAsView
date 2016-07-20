package com.example.module;

public interface LoginStatusListener {

	void onSuccess();
	void onFailed();
	void onLoading(int progress);
	void onStart();
}
