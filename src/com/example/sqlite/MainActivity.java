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
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;

public class MainActivity extends Activity {
	//Delcaración de los inputs
	private EditText et1, et2, et3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Localizamos los inputs en la interfaz y le asignamos un identificador
		et1 = (EditText) findViewById(R.id.editText1);
		et2 = (EditText) findViewById(R.id.editText2);
		et3 = (EditText) findViewById(R.id.editText3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//Método para guardar un empleado
	public void alta(View v) {
		//Instanciar la clase Helper
		Helper gestion = new Helper(this, "Gestion", null, 1);
		SQLiteDatabase db = gestion.getWritableDatabase();
		//Obtener los valores de los inputs
		String codigo = et1.getText().toString();
		String nombre = et2.getText().toString();
		String telefono = et3.getText().toString();
		//Agrupar en forma de lista de valores
		ContentValues registro = new ContentValues();
		registro.put("codigo", codigo);
		registro.put("nombre", nombre);
		registro.put("telefono", telefono);
		//Insertar valores en la base SQLite
		db.insert("empleados", null, registro);
		db.close();
		//Limpiar los inputs
		et1.setText("");
		et2.setText("");
		et3.setText("");
		//Notificar si es correcto
		Toast.makeText(this, "Los valores se han cargado correctamente", Toast.LENGTH_SHORT).show();
	}
	
	//Método para consultar un empleado
		public void consulta(View v) {
			//Instanciar la clase Helper
			Helper gestion = new Helper(this, "Gestion", null, 1);
			SQLiteDatabase db = gestion.getWritableDatabase();
			//Obtener los valores de los inputs
			String codigo = et1.getText().toString();
			String nombre = et2.getText().toString();
			
			Cursor fila = db.rawQuery("Select nombre, telefono from empleados where codigo ="+ codigo, null);
			if (fila.moveToFirst()){
				et2.setText(fila.getString(0));
				et3.setText(fila.getString(1));
			}else{
				//Notificar si es correcto
				Toast.makeText(this, "No se ha encontrado nada", Toast.LENGTH_SHORT).show();
			}
			db.close();
			
		}

}
