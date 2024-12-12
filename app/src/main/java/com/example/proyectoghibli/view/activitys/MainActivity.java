package com.example.proyectoghibli.view.activitys;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectoghibli.R;

/**
 *  Main activity.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    /**
     * Lanzar principal.
     *
     * @param view the view
     */
//metodo para lanzar la clase principal
    public void lanzarPrincipal(android.view.View view) {
        Intent intent = new Intent(MainActivity.this, Principal.class);
        startActivity(intent);
    }


}