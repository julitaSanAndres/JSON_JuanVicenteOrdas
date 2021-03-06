package com.proyectosimio.json;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.proyectosimio.json.application.JSONApplication;

/**
 * Activity que muestra un ListView con enlaces a im�genes y abre el navegador
 * para mostrar la imagen seleccionada del ListView.
 * 
 * @author Proyecto Simio proyectosimio@gmail.com
 * 
 */
public class MainActivity extends Activity implements OnItemClickListener {
	private ListView lvPhotos;
	private ArrayAdapter<String> lvAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lvPhotos = (ListView) findViewById(R.id.lvFotos);

		// Creamos un Adapter est�ndar de Android.
		lvAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, new ArrayList<String>());

		// Asignamos el Adapter al ListView.
		lvPhotos.setAdapter(lvAdapter);
		
		lvPhotos.setOnItemClickListener(this);

		// Actualizamos los datos, pasamos el Context para poder mostrar un
		// ProgressDialog durante la carga de datos y el Adapter para
		// actualizarlo.
		((JSONApplication) getApplication()).getData(this, lvAdapter);
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		// Recuperamos el link de la publicaci�n seleccionada.
		String link = lvAdapter.getItem(position);
		
		// Creamos un intent implicito para que el sistema escoja la aplicaci�n
		// que debe utilizar.
		Intent i = new Intent(Intent.ACTION_VIEW);
		
		// Le a�adimos la url que debe mostrar.
		i.setData(Uri.parse(link));
		
		// Lanzamos la nueva Activity.
		startActivity(i);
		
	}
}
