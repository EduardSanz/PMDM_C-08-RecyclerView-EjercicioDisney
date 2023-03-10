package com.cieep.pmdm_c_08_recyclerview_ejerciciodisney.conexiones;

import com.cieep.pmdm_c_08_recyclerview_ejerciciodisney.configuraciones.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {

    public static Retrofit getConnection() {
        return new Retrofit.Builder()
                .baseUrl(Constantes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
