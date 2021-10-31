package com.example.rubric;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuOp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_op);
    }
    public void Alumnos(View v){
        Intent sg1=new Intent(this,MainActivity.class);
        startActivity(sg1);
    }
    public void Calificar(View v1){

            Intent sig =new Intent(this,Calificar.class);
            sig.putExtra("nom"," ");
            sig.putExtra("ape"," ");
            startActivity(sig);


    }
    public void Actividad(View v2){
        Intent sg3=new Intent(this,Actividades.class);
        startActivity(sg3);
    }
    public void Reportes(View v3){
        Intent sg2=new Intent(this,MenuReportes.class);
        startActivity(sg2);
    }

}
