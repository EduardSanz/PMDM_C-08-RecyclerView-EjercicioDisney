package com.cieep.pmdm_c_08_recyclerview_ejerciciodisney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cieep.pmdm_c_08_recyclerview_ejerciciodisney.conexiones.ApiConexiones;
import com.cieep.pmdm_c_08_recyclerview_ejerciciodisney.conexiones.RetrofitObject;
import com.cieep.pmdm_c_08_recyclerview_ejerciciodisney.modelos.Personaje;
import com.squareup.picasso.Picasso;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerPersonajeActivity extends AppCompatActivity {

    private ImageView imgPersonaje;
    private TextView lblNombre;
    private TextView lblFilms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_personaje);

        imgPersonaje = findViewById(R.id.imgPersonajeVer);
        lblNombre = findViewById(R.id.lblNombreVer);
        lblFilms = findViewById(R.id.lblFilmsVer);

        if (getIntent().getExtras() != null && getIntent().getExtras().getString("ID") != null) {
            ApiConexiones api = RetrofitObject.getConnection().create(ApiConexiones.class);
            Call<Personaje> personajeCall = api.getPersonaje(getIntent().getExtras().getString("ID"));

            personajeCall.enqueue(new Callback<Personaje>() {
                @Override
                public void onResponse(Call<Personaje> call, Response<Personaje> response) {
                    if (response.code() == HttpsURLConnection.HTTP_OK) {
                        Personaje p = response.body();
                        lblNombre.setText(p.getName());
                        lblFilms.setText("");
                        for (String film : p.getFilms()) {
                            lblFilms.setText(lblFilms.getText()+"\n"+film);
                        }
                        Picasso.get()
                                .load(p.getImageUrl())
                                .into(imgPersonaje);
                    }
                }

                @Override
                public void onFailure(Call<Personaje> call, Throwable t) {

                }
            });
        }
    }
}