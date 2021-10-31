package com.example.rubric;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ReporteCalificacion extends AppCompatActivity {

    public ListView lv3;
    ArrayList<String> Lista;
    ArrayAdapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_calificacion);

        lv3=(ListView)findViewById(R.id.lvReportes1);
        //instanciar la clase de tipo array con la variable de tipo array
        Lista = llenar_lv3();
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Lista);
        lv3.setAdapter(adaptador);
    }
    public  ArrayList llenar_lv3(){

        ArrayList<String> Lista = new ArrayList<>();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "bdRubrica", null, 1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();
        String q= "SELECT * FROM Calificaciones";
        Cursor registro = BasedeDatos.rawQuery(q,null);

        if(registro.moveToFirst()){
            do{
                Lista.add("Nombre: "+registro.getString(0));
                Lista.add("Actividad: "+registro.getString(1));
                Lista.add("Nota: "+registro.getString(2));
                Lista.add("-------------------------------------------------------------------------");
            }while (registro.moveToNext());
        }


        return Lista;
    }
}
