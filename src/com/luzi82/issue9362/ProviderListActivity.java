package com.luzi82.issue9362;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.widget.ArrayAdapter;

public class ProviderListActivity extends ListActivity {

	@Override
	protected void onResume() {
		super.onResume();

		AppWidgetManager awm = AppWidgetManager.getInstance(this);
		List<AppWidgetProviderInfo> awpiList = awm.getInstalledProviders();
		List<String> idList = new ArrayList<String>();
		for (AppWidgetProviderInfo awpi : awpiList) {
			StringBuffer sb = new StringBuffer(awpi.provider.flattenToString());
			if (awpi.configure != null) {
				sb.append(" : ");
				sb.append(awpi.configure.flattenToShortString());
			}
			idList.add(sb.toString());
		}

		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				R.layout.providerlist_entry, R.id.providerlist_entry_text,
				idList);
		setListAdapter(aa);

		onContentChanged();
	}

}
