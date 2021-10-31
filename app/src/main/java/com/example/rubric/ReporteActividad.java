package com.example.rubric;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ReporteActividad extends AppCompatActivity {

    public ListView lv1;
    ArrayList<String> Lista;
    ArrayAdapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_actividad);
        lv1= (ListView)findViewById(R.id.lvReportes3);

        //instacia variable
        Lista =llenar_lv1();
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Lista);
        lv1.setAdapter(adaptador);
    }
    public ArrayList llenar_lv1() {
        ArrayList<String> Lista = new ArrayList<>();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "bdRubrica", null, 1);
        SQLiteDatabase BasedeDatos=admin.getWritableDatabase();
        String q= "SELECT * FROM actividad";
        Cursor registro = BasedeDatos.rawQuery(q,null);

        if(registro.moveToFirst()){
            do{
                Lista.add("Codigo: "+registro.getString(0));
                Lista.add("Nombre: "+registro.getString(1));
                Lista.add("Aspecto 1: "+registro.getString(2));
                Lista.add("Aspecto 2: "+registro.getString(3));
                Lista.add("Aspecto 3: "+registro.getString(4));
                Lista.add("Aspecto 4: "+registro.getString(5));
                Lista.add("-------------------------------------------------------------------------");
            }while (registro.moveToNext());
        }

            return  Lista;
        }

    }

