package com.example.autosmaterial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdaptadorAutomovil.OnAutomovilClickListener{
    private RecyclerView listAuto;
    private AdaptadorAutomovil adaptador;
    private LinearLayoutManager llm;
    private ArrayList<Automovil> auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listAuto = (RecyclerView) findViewById(R.id.lstAutomovil);

        auto = Datos.obtener();
        auto = new ArrayList<Automovil>();
        auto.add(new Automovil(R.drawable.carrokia, "HSJYSK4", "KIA", "2001", "rojo", "638289000" ));
        auto.add(new Automovil(R.drawable.carroford, "JSJ665S", "FORD", "2008", "negro", "26720000" ));
        auto.add(new Automovil(R.drawable.carrododge, "A345GG", "DODGE", "2019", "negro", "228289200" ));
        auto.add(new Automovil(R.drawable.carromazda, "JSKK675", "MAZDA", "2008", "rojo", "34000000" ));
        auto.add(new Automovil(R.drawable.carroford, "HAHA4J", "FORD", "2019", "negro", "98600000" ));

        adaptador = new AdaptadorAutomovil(auto, this);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        listAuto.setLayoutManager(llm);
        listAuto.setAdapter(adaptador);



    }
    public void onAutomovilClick(Automovil p) {
        Intent intent;
        Bundle bundle;

        bundle = new Bundle();

        bundle.putInt("foto",p.getFoto());
        bundle.putString("placa", p.getPlaca());
        bundle.putString("marca",p.getMarca());
        bundle.putString("modelo", p.getModelo());
        bundle.putString("color", p.getColor());
        bundle.putString("precio", p.getPrecio());


        intent = new Intent(MainActivity.this, DetalleAutomovil.class);
        intent.putExtra("datos",bundle);
        startActivity(intent);
    }
}