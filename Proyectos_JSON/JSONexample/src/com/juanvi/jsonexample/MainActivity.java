package com.juanvi.jsonexample;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	private Button bt_json_simple, bt_json_array;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bt_json_simple = (Button) findViewById(R.id.bt_json_simple);
		bt_json_array = (Button) findViewById(R.id.bt_json_array);
	}

	public void clickJsonSimple(View v){
		//Al pulsar el primer botón se abre la Activity para ver los JSON simples (JSONSimple).
		Intent intent = new Intent(MainActivity.this, JSONSimple.class);
		startActivity(intent);
	}
	
	public void clickJsonArray(View v){
		//Al pulsar el segundo botón se abre la Activity para ver los JSON Array (JSONArrayActivity).
		Intent intent = new Intent(MainActivity.this, JSONArrayActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
