package com.example.rubric;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etcodigo,etnombre,etapellido;
    Spinner Spgrado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etcodigo=(EditText)findViewById(R.id.txtCodEstudiante);
        etnombre=(EditText)findViewById(R.id.txtNombreEstudiante);
        etapellido=(EditText)findViewById(R.id.txtApellidoEstud);
        Spgrado= (Spinner)findViewById(R.id.spinner1);

        //utilizacion de spinner
        String [] opciones={"Primero","Segundo","Tercero","Cuarto","Quinto","Sexto"};
        ArrayAdapter <String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        Spgrado.setAdapter(adapter);

    }
    public void Registrar(View view){
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"bdRubrica", null,1);
        SQLiteDatabase BasedeDatos=admin.getWritableDatabase();

        String codigo=etcodigo.getText().toString();
        String nombre=etnombre.getText().toString();
        String apellido=etapellido.getText().toString();
        String grado=Spgrado.getAdapter().toString();


        if(!codigo.isEmpty()&& !nombre.isEmpty()&&!apellido.isEmpty()&&!grado.isEmpty()){
            ContentValues registro=new ContentValues();
            registro.put("codigo",codigo);
            registro.put("nombre",nombre);
            registro.put("apellido",apellido);
            registro.put("grado",grado);


            try {
                BasedeDatos.insert("estudiante",null,registro);

                BasedeDatos.close();
                etapellido.setText("");
                etnombre.setText("");
                etcodigo.setText("");

                Toast.makeText(this,"Registro guardado con exito",Toast.LENGTH_LONG).show();
            }catch (SQLException e){
                Toast.makeText(this,"Registro no guardado ",Toast.LENGTH_LONG).show();
            }


        }else{
            Toast.makeText(this,"Debes llenar los campos",Toast.LENGTH_SHORT).show();
        }
    }
    public void pruebaPasar(View view3){
        Intent siguiente =new Intent(this,Actividades.class);
        startActivity(siguiente);
    }

    public void ActCalificar(View view1){


        String nombre=etnombre.getText().toString();
        String apellido=etapellido.getText().toString();
        if(!nombre.isEmpty()){
            Intent sig =new Intent(this,Calificar.class);
            sig.putExtra("nom",nombre);
            sig.putExtra("ape",apellido);
            startActivity(sig);
        }else{
            Toast.makeText(this,"Debes Consultar un estudiante a calificar",Toast.LENGTH_SHORT).show();
        }

    }




    public void Consultar(View v1){

        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"bdRubrica",null,1);
        SQLiteDatabase BasedeDatos= admin.getWritableDatabase();

        String codigo=etcodigo.getText().toString();

        if(!codigo.isEmpty()){

            Cursor fila=BasedeDatos.rawQuery("SELECT nombre, apellido FROM estudiante WHERE codigo="+codigo,null);
            if(fila.moveToFirst()){
                etnombre.setText(fila.getString(0));
                etapellido.setText(fila.getString(1));
                BasedeDatos.close();

            }else {
                Toast.makeText(this,"El estudiante no existe",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this,"Debes de introducir el codigo del Alumno",Toast.LENGTH_SHORT).show();
        }

    }
    public void pasarReportes(View v2){
        Intent sig =new Intent(this,Reportes.class);
        startActivity(sig);
    }
}
