package com.juanvi.jsonexample;

import org.json.*;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class JSONSimple extends ActionBarActivity {

	private EditText ed_nombre, ed_edad;
	private Button bt_terminar, bt_mostrar2;
	private TextView tx_formato, tx_recuperacion_datos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jsonsimple);
		
		ed_nombre = (EditText) findViewById(R.id.ed_nombre);
		ed_edad = (EditText) findViewById(R.id.ed_edad);
		bt_terminar = (Button) findViewById(R.id.bt_terminar);
		bt_mostrar2 = (Button) findViewById(R.id.bt_mostrar2);
		tx_formato = (TextView) findViewById(R.id.tx_formato);
		tx_recuperacion_datos = (TextView) findViewById(R.id.tx_recuperacion_datos);
	}

	public void clickMostrar(View v){
		//Variables para guardar los valores de los EditText.
		String nombre = ed_nombre.getText().toString();
		int edad = Integer.parseInt(ed_edad.getText().toString());
		
		//Creación del objeto JSONObject vacío.
		JSONObject json = new JSONObject();
		
		//Añadir elementos al objeto JSONObject.
		try {
			json.put("nombre", nombre);
			json.put("edad", edad);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Muestro el formato que tiene el objeto JSONObject.
		tx_formato.setText(json.toString());
		
		//Leer elementos del JSONObject con el método getXXX()
		try {
			tx_recuperacion_datos.setText("Nombre: " + json.getString("nombre") + "\n"
					+ "Edad: " + json.getInt("edad"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		//Limpiar los EditText.
		ed_nombre.setText("");
		ed_edad.setText("");
	}
	
	public void clickMostrar2(View v){
		//Variables para guardar los valores de los EditText.
		String nombre = ed_nombre.getText().toString();
		int edad = Integer.parseInt(ed_edad.getText().toString());
		
		//Creación del objeto JSONObject vacío.
		JSONObject json = new JSONObject();
		
		//Añadir elementos al objeto JSONObject.
		try {
			json.put("nombre", nombre);
			json.put("edad", edad);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Muestro el formato que tiene el objeto JSONObject.
		tx_formato.setText(json.toString());
		
		//Leer elementos del JSONObject con el método optXXX()
		tx_recuperacion_datos.setText("Nombre: " + json.optString("nombre") + "\n"
				+ "Edad: " + json.optInt("edad"));
		
		//Limpiar los EditText.
		ed_nombre.setText("");
		ed_edad.setText("");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jsonsimple, menu);
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
