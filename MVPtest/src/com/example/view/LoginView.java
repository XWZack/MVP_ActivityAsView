package com.example.view;

public interface LoginView {

	void showProgressBar();
	void hideProgressBar();
	void setLoginProgress(int progress);
	void makeToast(String text);
	String getUserName();
	String getPassword();
	void goToActivity(Class<?> className);

}
