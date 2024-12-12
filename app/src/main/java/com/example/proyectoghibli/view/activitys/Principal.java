package com.example.proyectoghibli.view.activitys;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.proyectoghibli.R;
import com.google.android.material.navigation.NavigationView;

/**
 * Principal.
 */
public class Principal extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //contenedor para el menu lateral
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        //componente del menu lateral
        NavigationView navView = findViewById(R.id.nav_view);

        //obtenemos el el fragmento de navegacion dentro del layout
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        //configuracion de la appbar
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_peliculas, R.id.nav_directores, R.id.nav_ubicaciones, R.id.nav_personajes)
                .setDrawerLayout(drawerLayout)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        NavigationUI.setupWithNavController(navView, navController);
    }

    //metodo para manejar la navegacion en el menu
    @Override
    public boolean onSupportNavigateUp() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
        }
        return false;
    }
}