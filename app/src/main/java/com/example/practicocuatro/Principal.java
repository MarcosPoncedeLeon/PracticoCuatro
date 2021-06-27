package com.example.practicocuatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Principal extends AppCompatActivity {

    private Button btnsalir;
    private ImageButton imagenbtntubo, imagenbtnsobre, imagenbtnmundo;
    String numeroTel = "2954548995";
    String[] direcciones = {"poncedeleon0806@gmail.com"};
    String url = "https://github.com/MarcosPoncedeLeon/PracticoCuatro";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnsalir = (Button)findViewById(R.id.btnsalir);
        imagenbtntubo = (ImageButton)findViewById(R.id.imagenbtntubo);
        imagenbtnsobre = (ImageButton)findViewById(R.id.imagenbtnsobre);
        imagenbtnmundo =(ImageButton)findViewById(R.id.imagenbtnmundo);

        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              salir();

            }
        });

        imagenbtntubo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marcar(numeroTel);
            }
        });

        imagenbtnsobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarmail(direcciones, "consulta");
            }
        });

        imagenbtnmundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirsitioweb(url);
            }
        });
    }


    //metodo marcador de llamda
    public void marcar(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    //metodo para envio de mail
    public void enviarmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // solo las aplicaciones de correo electrónico deben manejar esto
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    //metodo para ir a pagina web
    public void abrirsitioweb(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    //metodo boton salir
    private void salir(){
        Intent salir = new Intent(this, Login.class);
        startActivity(salir);
    }
}