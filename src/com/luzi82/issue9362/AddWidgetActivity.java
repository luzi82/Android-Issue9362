package com.luzi82.issue9362;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AddWidgetActivity extends Activity {

	private String TAG="AddWidgetActivity";
	
	private int mAppWidgetId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.d(TAG,"onCreate");
		
		setResult(RESULT_CANCELED);

		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		if (extras == null) {
			finish();
		}

		mAppWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
				AppWidgetManager.INVALID_APPWIDGET_ID);
		
		setContentView(R.layout.addwidget);
		
		findViewById(R.id.addwidget_ok_button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
	            Intent resultValue = new Intent();
	            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
	            setResult(RESULT_OK, resultValue);
	            finish();
			}
		});
	}

}
