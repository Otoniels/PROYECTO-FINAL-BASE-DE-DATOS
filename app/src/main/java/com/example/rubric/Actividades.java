package com.example.rubric;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Actividades extends AppCompatActivity {

    EditText codigo,etnombre,etatb1,etatb2,etatb3,etatb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        //se castea cada variable de tipo editext

        codigo=(EditText)findViewById(R.id.txtCodActi);
        etnombre=(EditText)findViewById(R.id.txtNomActi);
        etatb1=(EditText)findViewById(R.id.txtAt1);
        etatb2=(EditText)findViewById(R.id.txtAt2);
        etatb3=(EditText)findViewById(R.id.txtAt3);
        etatb4=(EditText)findViewById(R.id.txtAt4);

    }

    public void registrarActi(View v11){

        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"bdRubrica",null,1);
        SQLiteDatabase BasedeDatos= admin.getWritableDatabase();

        String id=codigo.getText().toString();
        String nombre1=etnombre.getText().toString();
        String atb1=etatb1.getText().toString();
        String atb2=etatb2.getText().toString();
        String atb3=etatb3.getText().toString();
        String atb4=etatb4.getText().toString();

        if(!id.isEmpty()&&!nombre1.isEmpty()&&!atb1.isEmpty()&&!atb2.isEmpty()&&!atb3.isEmpty()&&!atb4.isEmpty()){
            ContentValues registrar=new ContentValues();
            registrar.put("codigo",id);
            registrar.put("nombre",nombre1);
            registrar.put("atA",atb1);
            registrar.put("atB",atb2);
            registrar.put("atC",atb3);
            registrar.put("atD",atb4);

            BasedeDatos.insert("actividad",null,registrar);
            BasedeDatos.close();
            codigo.setText("");
            etnombre.setText("");
            etatb1.setText("");
            etatb2.setText("");
            etatb3.setText("");
            etatb4.setText("");

            Toast.makeText(this,"Registrado con exito",Toast.LENGTH_LONG).show();

        }else{

            Toast.makeText(this,"Debe de llenar los campos",Toast.LENGTH_LONG).show();
        }


    }

}
