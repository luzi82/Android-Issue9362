package com.luzi82.issue9362;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ProviderListActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		int[] data = { 0, 1, 2, 3, 4 };
		List<String> idList = new ArrayList<String>();
		for (int i : data) {
			idList.add(Integer.toString(i));
		}

		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				R.layout.providerlist_entry, R.id.providerlist_entry_text,
				idList);
		setListAdapter(aa);
	}

}
