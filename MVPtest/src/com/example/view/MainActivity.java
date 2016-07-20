package com.example.view;

import com.example.mvptest.R;
import com.example.presenter.LoginPresenter;
import com.example.presenter.LoginPresenterImp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,LoginView {
	private EditText etUserName, etPassword;
	private TextView submitBtn;
	private ProgressBar progressBar;
	private LoginPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		presenter=new LoginPresenterImp(this);
	}

	private void initView() {
		etUserName = (EditText) findViewById(R.id.et_username);
		etPassword = (EditText) findViewById(R.id.et_password);
		submitBtn = (TextView) findViewById(R.id.tv_loginbtn);
		submitBtn.setOnClickListener(this);
		progressBar = (ProgressBar) findViewById(R.id.pb_login);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.tv_loginbtn:
			presenter.login();
			break;
		default:
			break;
		}
	}

	@Override
	public void showProgressBar() {
		// TODO Auto-generated method stub
		progressBar.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideProgressBar() {
		// TODO Auto-generated method stub
		progressBar.setVisibility(View.GONE);
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return etUserName.getText().toString();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return etPassword.getText().toString();
	}
	
	@Override
	public void setLoginProgress(int progress){
		progressBar.setProgress(progress);
	}

	@Override
	public void makeToast(String text) {
		// TODO Auto-generated method stub
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void goToActivity(Class<?> className) {
		// TODO Auto-generated method stub
		Intent intent=new Intent(this,className);
		startActivity(intent);
	}
}
