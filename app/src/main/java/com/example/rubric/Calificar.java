package com.example.rubric;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.cdma.CdmaCellLocation;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ShareActionProvider;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Calificar extends AppCompatActivity {


    EditText Alumno,Act,At1,At2,At3,At4,codA,CdA;
    String punto;

    private RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificar);

        codA = (EditText) findViewById(R.id.txtCodigoEstudiante1);
        Alumno =(EditText) findViewById(R.id.txtAlumno);
        Act =(EditText) findViewById(R.id.txtActividad);
        At1 =(EditText) findViewById(R.id.txtAtri1);
        At2 =(EditText) findViewById(R.id.txtAtri2);
        At3 =(EditText) findViewById(R.id.txtAtri3);
        At4 =(EditText) findViewById(R.id.txtAtri4);
        r1=(RadioButton)findViewById(R.id.rb1);
        r2=(RadioButton)findViewById(R.id.rb2);
        r3=(RadioButton)findViewById(R.id.rb3);
        r4=(RadioButton)findViewById(R.id.rb4);
        r5=(RadioButton)findViewById(R.id.rb5);
        r6=(RadioButton)findViewById(R.id.rb6);
        r7=(RadioButton)findViewById(R.id.rb7);
        r8=(RadioButton)findViewById(R.id.rb8);
        r9=(RadioButton)findViewById(R.id.rb9);
        r10 =(RadioButton)findViewById(R.id.rb10);
        r11=(RadioButton)findViewById(R.id.rb11);
        r12=(RadioButton)findViewById(R.id.rb12);
        r13=(RadioButton)findViewById(R.id.rb13);
        r14=(RadioButton)findViewById(R.id.rb14);
        r15=(RadioButton)findViewById(R.id.rb15);
        r16=(RadioButton)findViewById(R.id.rb16);
        CdA=(EditText)findViewById(R.id.txtCodActivi);

        RecibirDatos();


        }

///codigo para accesar desde el menu ha calificar y consulta alumno
       public void Consultarr(View v1) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "bdRubrica", null, 1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();

        String codigo = codA.getText().toString();

        if (!codigo.isEmpty()) {

            Cursor fila = BasedeDatos.rawQuery("select nombre from estudiante WHERE codigo=" + codigo, null);
            if (fila.moveToFirst()) {
                Alumno.setText(fila.getString(0));
                BasedeDatos.close();
            } else {
                Toast.makeText(this, "El estudiante no existe", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Debes de introducir el codigo del Alumno", Toast.LENGTH_SHORT).show();
        }


        }


// realiza una consulta en el boton consulta de actividad
    public void ConsultarA(View v11){

        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"bdRubrica",null,1);
        SQLiteDatabase BasedeDatos= admin.getWritableDatabase();

        String Codigo=CdA.getText().toString();

        if(!Codigo.isEmpty()){

            Cursor c=BasedeDatos.rawQuery("SELECT * FROM actividad WHERE codigo="+Codigo,null);
            if(c.moveToFirst()){
                Act.setText(c.getString(1));
                At1.setText(c.getString(2));
                At2.setText(c.getString(3));
                At3.setText(c.getString(4));
                At4.setText(c.getString(5));
                BasedeDatos.close();

            }else {
                Toast.makeText(this,"La actividad no existe",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this,"Debes de introducir el codigo de la actividad",Toast.LENGTH_SHORT).show();
        }

    }

       public void  RecibirDatos(){
        Bundle extras = getIntent().getExtras();
        String nom=extras.getString("nom");
        String ape=extras.getString("ape");

        Alumno.setText(nom+"  "+ape);
       }


       public void CalcularNota(View vv){
          int nota1=0,nota2=0,nota3=0,nota4=0;

          if(r1.isChecked()==true){ nota1=5; }
           if(r2.isChecked()==true){ nota1=4; }
           if(r3.isChecked()==true){ nota1=3; }
           if(r4.isChecked()==true){ nota1=1; }

           if(r5.isChecked()==true){ nota2=5; }
           if(r6.isChecked()==true){ nota2=4; }
           if(r7.isChecked()==true){ nota2=3; }
           if(r8.isChecked()==true){ nota2=1; }


           if(r9.isChecked()==true){ nota3=5; }
           if(r10.isChecked()==true){ nota3=4; }
           if(r11.isChecked()==true){ nota3=3; }
           if(r12.isChecked()==true){ nota3=1; }


           if(r13.isChecked()==true){ nota4=5; }
           if(r14.isChecked()==true){ nota4=4; }
           if(r15.isChecked()==true){ nota4=3; }
           if(r16.isChecked()==true){ nota4=1; }

           int ponderacion =nota1+nota2+nota3+nota4;

           punto=Integer.toString(ponderacion);

           Toast.makeText(this,"nota:"+punto,Toast.LENGTH_LONG).show();

       }
       public void GuardarReg(View view){


           AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"bdRubrica", null,1);
           SQLiteDatabase BasedeDatos=admin.getWritableDatabase();


           String nombre1=Alumno.getText().toString();
           String actividad1=Act.getText().toString();
           String nota1=punto;


           if(!nombre1.isEmpty()&&!actividad1.isEmpty()){
               ContentValues registro=new ContentValues();

               registro.put("nombre",nombre1);
               registro.put("actividad",actividad1);
               registro.put("nota",nota1);


               //try {
                   BasedeDatos.insert("calificaciones",null,registro);

                   BasedeDatos.close();

                   Toast.makeText(this,"Registro guardado con exito",Toast.LENGTH_LONG).show();
               //}catch*(SQLException e){
                  // Toast.makeText(this,"Registro no guardado ",Toast.LENGTH_LONG).show();
               //}


           }else{
               Toast.makeText(this,"Debes llenar los campos",Toast.LENGTH_SHORT).show();
           }

       }

    }
















