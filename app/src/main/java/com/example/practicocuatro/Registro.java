package com.example.practicocuatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText nombreCompleto, nombreUsuario,txtCorreo, txtContraseña, txtRepite;
    private Button btnconfirmaregistro;
    private SharedPreferences registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        conectar();

        registro = getSharedPreferences("registro_usuarios", Context.MODE_PRIVATE);


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
            SharedPreferences.Editor editor = registro.edit();

            String nombreComplet = nombreCompleto.getText().toString();
            String usuario = nombreUsuario.getText().toString();
            String correo = txtCorreo.getText().toString();
            String clave =  txtContraseña.getText().toString();
            String repeticion = txtRepite.getText().toString();

            editor.putString("nombrePersona", nombreComplet);
            editor.putString("nombreUsuario", usuario);
            editor.putString("email", correo);
            editor.putString("contraseña", clave);
            if(clave.equals(repeticion)){
                editor.putString("repeticion", repeticion);
                editor.commit();
                Toast.makeText(this, "Usuario generado correctamente", Toast.LENGTH_SHORT).show();
                startActivity(volverAlogin);
            }else{
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void conectar(){
        nombreCompleto = (EditText) findViewById(R.id.nombreCompleto);
        nombreUsuario = (EditText) findViewById(R.id.nombreUsuario);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtContraseña = (EditText) findViewById(R.id.txtContraseña);
        txtRepite = (EditText) findViewById(R.id.txtRepite);
        btnconfirmaregistro = (Button) findViewById(R.id.btnconfirmaregistro);


    }

}