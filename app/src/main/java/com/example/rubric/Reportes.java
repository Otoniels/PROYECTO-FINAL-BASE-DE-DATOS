package com.example.rubric;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Reportes extends AppCompatActivity {

    public Spinner s;
    public ListView lv;
    ArrayList<String> Lista;
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);
        lv = (ListView) findViewById(R.id.lvReportes);

        //instanciar la clase de tipo array con la variable de tipo array
        Lista = llenar_lv();
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Lista);
        lv.setAdapter(adaptador);

    }

    public ArrayList llenar_lv() {
        ArrayList<String> Lista = new ArrayList<>();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "bdRubrica", null, 1);
        SQLiteDatabase BasedeDatos=admin.getWritableDatabase();
        String q= "SELECT * FROM estudiante";
        Cursor registro = BasedeDatos.rawQuery(q,null);

        if(registro.moveToFirst()){
            do{
                Lista.add("Codigo: "+registro.getString(0));
                Lista.add("Nombre: "+registro.getString(1));
                Lista.add("Apellido: "+registro.getString(2));
                Lista.add("-------------------------------------------------------------------------");
            }while (registro.moveToNext());
        }


        return Lista;
    }


}
