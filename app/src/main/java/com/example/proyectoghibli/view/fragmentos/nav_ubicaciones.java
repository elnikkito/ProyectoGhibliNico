package com.example.proyectoghibli.view.fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyectoghibli.R;
import com.example.proyectoghibli.adaptadores.AdaptadorUbicaciones;
import com.example.proyectoghibli.viewmodel.UbicacionViewModel;


public class nav_ubicaciones extends Fragment {

    private RecyclerView recyclerViewUbicaciones;
    private UbicacionViewModel ubicacionViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_ubicaciones, container, false);

        recyclerViewUbicaciones = view.findViewById(R.id.recyclerUbicaciones);
        recyclerViewUbicaciones.setLayoutManager(new GridLayoutManager(getContext(), 2));

        ubicacionViewModel = new ViewModelProvider(this).get(UbicacionViewModel.class);

        ubicacionViewModel.getUbicaciones().observe(getViewLifecycleOwner(), ubicaciones -> {
            if (ubicaciones != null) {
                AdaptadorUbicaciones adaptador = new AdaptadorUbicaciones(ubicaciones, getContext());
                recyclerViewUbicaciones.setAdapter(adaptador);
            }
        });

        ubicacionViewModel.cargarUbicaciones();

        return view;
    }
}
