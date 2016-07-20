package com.example.module;

import android.os.AsyncTask;
import android.os.Handler;

public class UserLoginConnector {

	public static void login(final String userName, final String password,final LoginStatusListener listener){

		AsyncTask<Void,Integer,Boolean> task=new AsyncTask<Void,Integer,Boolean>(){

			@Override
			protected Boolean doInBackground(Void... params) {
				// TODO Auto-generated method stub
				publishProgress(10);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(userName.equals("abc")&&password.equals("123")){
					return true;
				}else{
					return false;
				}
			}

			@Override
			protected void onPostExecute(Boolean result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result);
				publishProgress(100);
				if(result==true){
					if(listener!=null){
						listener.onSuccess();
					}
				}else{
					if(listener!=null){
						listener.onFailed();
					}
				}
			}

			@Override
			protected void onProgressUpdate(Integer... values) {
				// TODO Auto-generated method stub
				super.onProgressUpdate(values);
				listener.onLoading(values[0]);
			}

			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();
				listener.onStart();
			}
		};
		task.execute();
	}
}
