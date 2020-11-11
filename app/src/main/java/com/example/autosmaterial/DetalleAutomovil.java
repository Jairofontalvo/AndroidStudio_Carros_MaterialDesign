package com.example.autosmaterial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleAutomovil extends AppCompatActivity {
    private ImageView foto;
    private TextView placa, marca, modelo, color, precio;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_automovil);

        foto = findViewById(R.id.imgFotoDetalle);
        placa = findViewById(R.id.lblPlacaDetalle);
        marca = findViewById(R.id.lblMarcaDetalle);
        modelo = findViewById(R.id.lblModeloDetalle);
        color = findViewById(R.id.lblColorDetalle);
        precio = findViewById(R.id.lblPrecioDetalle);

        intent = getIntent();
        bundle = intent.getBundleExtra("datos");

        foto.setImageResource(bundle.getInt("foto"));
        placa.setText(bundle.getString("placa"));
        marca.setText(bundle.getString("marca"));
        modelo.setText(bundle.getString("modelo"));
        color.setText(bundle.getString("color"));
        precio.setText(bundle.getString("precio"));
    }
}