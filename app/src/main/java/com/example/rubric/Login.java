package com.example.rubric;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        a=(EditText)findViewById(R.id.txtUsua);
        b=(EditText)findViewById(R.id.txtContra);
    }
    public void Accesar(View v){
        String usua=a.getText().toString();
        String contra=b.getText().toString();

       /* if(!usua.isEmpty()&&!contra.isEmpty()){
            if(usua.equals("Admin")&& contra.equals("Admin")){

        */
                Intent sig = new Intent(this,MenuOp.class);
                startActivity(sig);
          /*  }else {
                Toast.makeText(this,"Contraseña o Usuario Incorrecto", Toast.LENGTH_LONG).show();
                a.setText("");
                b.setText("");
            }
        }else{
            Toast.makeText(this,"Debe de llenar los campos",Toast.LENGTH_LONG).show();
        }


           */
    }
}
