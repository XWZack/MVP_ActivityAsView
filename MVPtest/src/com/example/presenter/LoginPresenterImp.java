package com.example.presenter;

import android.text.TextUtils;

import com.example.module.LoginStatusListener;
import com.example.module.UserLoginConnector;
import com.example.view.ContentActivity;
import com.example.view.LoginView;

public class LoginPresenterImp implements LoginPresenter,LoginStatusListener {

	private LoginView loginView;

	public LoginPresenterImp(LoginView view) {
		this.loginView = view;
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		String userName=loginView.getUserName();
		String password=loginView.getPassword();
		if (TextUtils.isEmpty(userName)
				|| TextUtils.isEmpty(password)) {
			return;
		}
		UserLoginConnector.login(userName, password, this);
	}

	@Override
	public void onSuccess() {
		// TODO Auto-generated method stub
		loginView.hideProgressBar();
		loginView.makeToast("µÇÂ¼³É¹¦");
		loginView.goToActivity(ContentActivity.class);
	}

	@Override
	public void onFailed() {
		// TODO Auto-generated method stub
		loginView.hideProgressBar();
		loginView.makeToast("µÇÂ¼Ê§°Ü");
	}

	@Override
	public void onLoading(int progress) {
		// TODO Auto-generated method stub
		loginView.setLoginProgress(progress);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		loginView.showProgressBar();
	}
}
