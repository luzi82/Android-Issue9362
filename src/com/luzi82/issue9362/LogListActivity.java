package com.luzi82.issue9362;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class LogListActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.appwidgetidlist);
	}

	@Override
	protected void onResume() {
		super.onResume();

		updateList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.logview, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.logview_item_clear: {
			Database db = new Database(this);
			db.clearAll();

			updateList();
			return true;
		}
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void updateList() {
		Database db = new Database(this);
		List<Database.Entry> entryList = db.getRecord();

		List<String> idList = new ArrayList<String>();
		for (Database.Entry i : entryList) {
			idList.add(i.log);
		}

		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				R.layout.loglist_entry, R.id.loglist_entry_text, idList);
		setListAdapter(aa);

		onContentChanged();
	}

}
