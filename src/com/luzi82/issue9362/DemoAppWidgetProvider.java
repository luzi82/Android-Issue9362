/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.luzi82.issue9362;

import java.util.GregorianCalendar;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * Simple widget to show currently playing album art along with play/pause and
 * next track buttons.
 */
public class DemoAppWidgetProvider extends AppWidgetProvider {

	static final String TAG = "DemoAppWidgetProvider";

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		Log.d(TAG, "onUpdate");
		addRecord(context, "onUpdate", appWidgetIds);
		final int N = appWidgetIds.length;
		for (int i = 0; i < N; i++) {
			int appWidgetId = appWidgetIds[i];
			updateAppWidget(context, appWidgetManager, appWidgetId);
		}
	}

	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		Log.d(TAG, "onDeleted");
		addRecord(context, "onDeleted", appWidgetIds);
	}

	@Override
	public void onEnabled(Context context) {
		Log.d(TAG, "onEnabled");
		addRecord(context, "onEnabled", null);
	}

	@Override
	public void onDisabled(Context context) {
		Log.d(TAG, "onDisabled");
		addRecord(context, "onDisabled", null);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG, "onReceive");
		StringBuffer sb = new StringBuffer("onReceive ");
		sb.append(intent.getAction());
		addRecord(context, sb.toString(), null);
		super.onReceive(context, intent);
	}

	static void updateAppWidget(Context context,
			AppWidgetManager appWidgetManager, int appWidgetId) {
		Log.d(TAG, "updateAppWidget appWidgetId=" + appWidgetId);

		RemoteViews views = new RemoteViews(context.getPackageName(),
				R.layout.eclair_album_appwidget);
		views.setTextViewText(R.id.title, Integer.toString(appWidgetId));

		appWidgetManager.updateAppWidget(appWidgetId, views);
	}

	static private void addRecord(Context context, String function, int[] id) {
		StringBuffer sb = new StringBuffer(DateFormat.format("kk:mm ",
				new GregorianCalendar()));
		sb.append(function);
		if (id != null) {
			sb.append(" {");
			boolean comma = false;
			for (int i : id) {
				if (comma) {
					sb.append(",");
				}
				comma = true;
				sb.append(i);
			}
			sb.append("}");
		}
		Database.addRecord(context, sb.toString());
	}

}
