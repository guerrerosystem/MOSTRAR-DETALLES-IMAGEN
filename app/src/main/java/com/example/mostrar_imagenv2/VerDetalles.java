package com.example.mostrar_imagenv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class VerDetalles extends AppCompatActivity {
TextView tv,tv2;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_detalles);

        tv=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tvprecio);
        img=findViewById(R.id.img);

        Intent intent = getIntent();

        String titulo = intent.getStringExtra("titulo");
        double precio = intent.getDoubleExtra("precio",0);
        String imagen = intent.getStringExtra("imagen");





        tv.setText(titulo);
        tv2.setText(String.valueOf("$ " + precio));



        Glide.with(VerDetalles.this).load(imagen).into(img);
    }
}