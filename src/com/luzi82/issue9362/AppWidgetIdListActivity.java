package com.luzi82.issue9362;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;

public class AppWidgetIdListActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//	}
//	
//	@Override
//	protected void onCreate() {
//		super.onCreate();

		int[] data = { 0, 1, 2, 3, 4 };
		List<String> idList = new ArrayList<String>();
		for (int i : data) {
			idList.add(Integer.toString(i));
		}

		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				R.layout.appwidgetidlist_entry,
				R.id.appwidgetidlist_entry_text, idList);
		setListAdapter(aa);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.appwidgetidlistview, menu);
		return true;
	}

}