package com.example.proyectoghibli.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectoghibli.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void lanzarPrincipal(android.view.View view) {
        Intent intent = new Intent(MainActivity.this, Principal.class);
        startActivity(intent);
    }

    public void lanzarInicio(android.view.View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}