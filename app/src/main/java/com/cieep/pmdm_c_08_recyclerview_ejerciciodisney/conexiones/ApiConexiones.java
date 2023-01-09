package com.cieep.pmdm_c_08_recyclerview_ejerciciodisney.conexiones;

import com.cieep.pmdm_c_08_recyclerview_ejerciciodisney.modelos.Personaje;
import com.cieep.pmdm_c_08_recyclerview_ejerciciodisney.modelos.Respuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiConexiones {
    // Descarga de datos inicial
    @GET("/characters")
    Call<Respuesta> getPersonajes();

    // Descarga de una página en concreto
    @GET("/characters?")
    Call<Respuesta> getPage(@Query("page") String page);

    // Descarga de un Personaje
    @GET("/characters/{id}")
    Call<Personaje> getPersonaje(@Path("id") String id);



}
