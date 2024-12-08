package com.example.proyectoghibli.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.proyectoghibli.api.ClienteApi;
import com.example.proyectoghibli.model.Ubicacion;
import com.example.proyectoghibli.api.ServicioApi;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UbicacionViewModel extends ViewModel {

    private final MutableLiveData<List<Ubicacion>> ubicaciones = new MutableLiveData<>();

    public LiveData<List<Ubicacion>> getUbicaciones() {
        return ubicaciones;
    }

    public void cargarUbicaciones() {
        ServicioApi apiService = ClienteApi.getClient().create(ServicioApi.class);
        apiService.getLocations().enqueue(new Callback<List<Ubicacion>>() {
            @Override
            public void onResponse(Call<List<Ubicacion>> call, Response<List<Ubicacion>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ubicaciones.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Ubicacion>> call, Throwable t) {

            }
        });
    }
}
