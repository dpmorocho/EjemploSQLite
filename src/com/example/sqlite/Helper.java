/* Helper.java
 * Autor: Diego Morocho
 * Versión: 0.1.0 
 * Fecha: 05/06/2014
 * Descripción: Archivo que ayuda como método constructor, generando setter - getter
 * 
 */

package com.example.sqlite;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Context;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class Helper extends SQLiteOpenHelper {
	public Helper(Context context, String nombre, CursorFactory factory, int version) {
		super(context, nombre, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table empleados(codigo integer primary key, nombre text, telefono integer)");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnt, int versionNue) {
		db.execSQL("drop table if exists empleados");
		db.execSQL("create table empleados(codigo integer primary key, nombre text, telefono integer)");
	}

}
