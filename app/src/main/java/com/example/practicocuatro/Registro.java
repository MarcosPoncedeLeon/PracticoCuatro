package com.example.practicocuatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText nombreCompleto, nombreUsuario,txtCorreo, txtContraseña, txtRepite;
    private Button btnconfirmaregistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombreCompleto = (EditText) findViewById(R.id.nombreCompleto);
        nombreUsuario = (EditText) findViewById(R.id.nombreUsuario);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtContraseña = (EditText) findViewById(R.id.txtContraseña);
        txtRepite = (EditText) findViewById(R.id.txtRepite);
        btnconfirmaregistro = (Button) findViewById(R.id.btnconfirmaregistro);


        btnconfirmaregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    retornoAlogin();
            }
        });
    }

    private void retornoAlogin(){
        if(nombreCompleto.getText().toString().isEmpty()  ||nombreUsuario.getText().toString().isEmpty() || txtCorreo.getText().toString().isEmpty() ||
        txtContraseña.getText().toString().isEmpty() || txtRepite.getText().toString().isEmpty()){
            Toast.makeText(Registro.this, "Completar todos los campos", Toast.LENGTH_SHORT).show();
        }else {
            Intent volverAlogin = new Intent(this, Login.class);
            startActivity(volverAlogin);
        }
    }

}