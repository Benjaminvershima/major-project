package com.fewstera.injectablemedicinesguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        TextView welcomeText = (TextView) findViewById(R.id.welcome_text_view);
        String welcomeHtml = getResources().getString(R.string.welcome_text);
        welcomeText.setText(Html.fromHtml(welcomeHtml));

        TextView updateText = (TextView) findViewById(R.id.last_update_textview);
        String lastUpdate = Preferences.getString(this, Preferences.UPDATE_DATE_KEY, "never");

        String textHtml = String.format(getResources().getString(R.string.last_updated_text), lastUpdate);
        updateText.setText(Html.fromHtml(textHtml));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.action_logout:
	        	Auth.logout(this);
	        	Intent intent = new Intent();
				intent.setClass(MainActivity.this, LoginActivity.class);
				startActivity(intent);
	            finish();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

    public void updateClick(View view){
        Intent intent = new Intent(this, DownloadDataActivity.class);
        startActivity(intent);
        finish();
    }

    public void viewDrugsClick(View view){
        Intent intent = new Intent(this, BrowseDrugsActivity.class);
        startActivity(intent);
    }

}
