package com.proyectosimio.json.application;

import android.app.Application;
import android.content.Context;
import android.widget.ArrayAdapter;

import com.proyectosimio.json.utils.AsyncConector;

/**
 * Clase Application personalizada.
 * 
 * @author Proyecto Simio proyectosimio@gmail.com
 * 
 */
public class JSONApplication extends Application {
	// URL que contiene el documento JSON.
	private final static String URL = "http://api.flickr.com/services/feeds/photos_public.gne?format=json";

	public void getData(Context context, ArrayAdapter<String> adapter) {
		// Actualizamos los datos del Adapter a través de un AsyncTask.
		new AsyncConector(context, adapter, URL).execute();
	}

}
