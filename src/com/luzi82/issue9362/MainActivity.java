package com.luzi82.issue9362;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;

public class MainActivity extends TabActivity implements
		TabHost.TabContentFactory {

	private final String TAB_INFO = "info";
	private final String TAB_APPWIDGETID = "appwidgetid";
	private final String TAB_LOG = "log";
	private final String TAB_PROVIDER = "provider";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);

		Resources res = getResources();

		setTitle(R.string.app_name);

		final TabHost tabHost = getTabHost();

		tabHost.addTab(tabHost.newTabSpec(TAB_INFO).setIndicator(
				res.getString(R.string.main_tab_info)).setContent(
				new Intent(this, InfoActivity.class)));

		tabHost.addTab(tabHost.newTabSpec(TAB_APPWIDGETID).setIndicator(
				res.getString(R.string.main_tab_appwidgetid)).setContent(
				new Intent(this, AppWidgetIdListActivity.class)));

		tabHost.addTab(tabHost.newTabSpec(TAB_LOG).setIndicator(
				res.getString(R.string.main_tab_log)).setContent(
				new Intent(this, LogListActivity.class)));

		tabHost.addTab(tabHost.newTabSpec(TAB_PROVIDER).setIndicator(
				res.getString(R.string.main_tab_provider)).setContent(
				new Intent(this, ProviderListActivity.class)));
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	 @Override
	 public View createTabContent(String tag) {
	 // default
	 // return getLayoutInflater().inflate(R.layout.info,
	 // getTabHost().getTabContentView());
//	 return getLayoutInflater().inflate(R.layout.info, null);
		 return null;
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_default, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_item_about: {
			Intent intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
			return true;
		}
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}