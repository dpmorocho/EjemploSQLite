/* MainActivity.java
 * Autor: Diego Morocho
 * Versión: 0.1.0 
 * Fecha: 05/06/2014
 * Descripción: Clase principal de invocación hacia las consultas SQLite y llamado a interfaces
 * 
 */

package com.example.sqlite;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Context;
import android.database.sqlite.*;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
