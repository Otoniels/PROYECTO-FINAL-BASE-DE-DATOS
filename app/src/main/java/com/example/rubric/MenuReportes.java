package com.example.rubric;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuReportes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_reportes);
    }
    public void ReporteAlumno(View view){
        Intent sig=new Intent(this,Reportes.class);
        startActivity(sig);
    }
    public void ReporteActividad(View v){
        Intent sig=new Intent(this,ReporteActividad.class);
        startActivity(sig);
    }
    public void ReporteCalificacion(View view){
        Intent sig=new Intent(this,ReporteCalificacion.class);
        startActivity(sig);
    }


}
