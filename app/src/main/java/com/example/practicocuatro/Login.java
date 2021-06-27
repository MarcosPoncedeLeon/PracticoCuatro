package com.example.practicocuatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText txtUsuario, txtClave;
    private Button btnSesion, btnInicioRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtClave = (EditText) findViewById(R.id.txtClave);
        btnSesion = (Button) findViewById(R.id.btnSesion);
        btnInicioRegistro = (Button) findViewById(R.id.btnInicioRegistro);

        btnInicioRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });

        btnSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtUsuario.getText().toString().equals("alumno") && txtClave.getText().toString().equals("123456")){
                    pantallaPrincipal();
                    txtUsuario.setText("");
                    txtClave.setText("");
                }else {
                    Toast.makeText(Login.this, "Usuario o contraseña incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registrar(){
        Intent registro = new Intent(this, Registro.class);
        startActivity(registro);
    }


    private void pantallaPrincipal(){
        Intent aPrincipal = new Intent(this, Principal.class);
        startActivity(aPrincipal);
    }
}