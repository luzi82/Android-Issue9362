package com.luzi82.issue9362;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class InfoActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.info);

		findViewById(R.id.info_link_mainsite_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						startActivity(new Intent(Intent.ACTION_VIEW, Uri
								.parse(getResources().getString(
										R.string.info_link_mainsite_url))));
					}
				});

		findViewById(R.id.info_link_issue_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						startActivity(new Intent(Intent.ACTION_VIEW, Uri
								.parse(getResources().getString(
										R.string.info_link_issue_url))));
					}
				});

		findViewById(R.id.info_link_video_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						startActivity(new Intent(Intent.ACTION_VIEW, Uri
								.parse(getResources().getString(
										R.string.info_link_video_url))));
					}
				});
	}

}
