package com.example.rubric;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

    public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


        public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase bdRubrica) {
            bdRubrica.execSQL("CREATE TABLE estudiante(codigo text, nombre text, apellido text,grado text)");
            bdRubrica.execSQL("CREATE TABLE actividad(codigo tex,nombre tex,atA tex,atB tex,atC tex,atD tex)");
            bdRubrica.execSQL("CREATE TABLE calificaciones(nombre text,actividad text,nota text)");
            //bdRubrica.execSQL("CREATE TABLE actividades(codigo text,nombre text,atA text,atB text,atC text,atD text)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
