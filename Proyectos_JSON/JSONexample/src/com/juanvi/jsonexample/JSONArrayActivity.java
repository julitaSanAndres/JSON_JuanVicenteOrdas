package com.juanvi.jsonexample;

import org.json.*;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class JSONArrayActivity extends ActionBarActivity {

	private EditText ed_nombre, ed_edad;
	private Button bt_terminar;
	private TextView tx_formato, tx_recuperacion_datos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jsonarray);
		
		ed_nombre = (EditText) findViewById(R.id.ed_nombre);
		ed_edad = (EditText) findViewById(R.id.ed_edad);
		bt_terminar = (Button) findViewById(R.id.bt_terminar);
		tx_formato = (TextView) findViewById(R.id.tx_formato);
		tx_recuperacion_datos = (TextView) findViewById(R.id.tx_recuperacion_datos);
		
		//Creación de un objeto JSONObject que contendrá el JSONArray.
		final JSONObject jsonPadre = new JSONObject();
		
		//Creación del objeto JSONArray. Es final para poder utilizarlo en los métodos posteriores.
		final JSONArray array = new JSONArray();
		
		//Añadir el JSONArray al objeto JSONObject.
		try {
			jsonPadre.put("personas", array);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Escuchador del botón Mostrar.
		bt_terminar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//Limpiar el TextView en el que se recuperan los datos.
				tx_recuperacion_datos.setText("");
				
				//Variables para guardar los valores de los EditText.
				String nombre = ed_nombre.getText().toString();
				int edad = Integer.parseInt(ed_edad.getText().toString());
				
				//Creación de un objeto JSONObject vacío.
				JSONObject json = new JSONObject();
				
				//Añadir elementos al JSONObject.
				try {
					json.put("nombre", nombre);
					json.put("edad", edad);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Añadir el objeto JSONObject al JSONArray que hemos creado anteriormente.
				array.put(json);
				
				//Mostrar el formato del JSONArray.
//				tx_formato.setText(array.toString());
				
				//Mostrar el formato del JSONObject (jsonPadre), es decir, el que contiene el JSONArray.
				tx_formato.setText(jsonPadre.toString());
				
				//Bucle para recorrer el JSONArray.
				for(int i = 0; i < array.length(); i++){
					//Creación de una variable JSONObject para poder guardar cada objeto JSONObject que
					//contiene el array JSONArray.
					JSONObject jsonTemp = null;
					
					try {
						//Recojemos cada objeto JSONObject que devuelve 
						//el método en la variable creada anteriormente.
						jsonTemp = array.getJSONObject(i);
						
						//Otra manera de guardar en una variable los JSONObject que contiene el JSONArray.
//						jsonTemp = (JSONObject) array.get(i);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//Mostrar los datos debidamente parseados en el TextView.
					tx_recuperacion_datos.setText(tx_recuperacion_datos.getText().toString() + "\n"
							+ "Nombre: " + jsonTemp.optString("nombre") + "\n"
							+ "Edad: " + jsonTemp.optInt("edad"));
					
				}
				
				//Limpiar los EditText.
				ed_nombre.setText("");
				ed_edad.setText("");
				
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jsonarray, menu);
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
