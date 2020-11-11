package com.example.autosmaterial;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdaptadorAutomovil extends RecyclerView.Adapter<AdaptadorAutomovil.AutomovilViewHolder>{
    private ArrayList<Automovil> automovil;
    private OnAutomovilClickListener clickListener;


    public AdaptadorAutomovil(ArrayList<Automovil> automovil, OnAutomovilClickListener clickListener){
        this.automovil = automovil;
        this.clickListener=clickListener;
    }

    @NonNull
    @Override
    public AutomovilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_automovil,parent,false);
        return new AutomovilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AutomovilViewHolder holder, int position) {
        final Automovil p = automovil.get(position);

        holder.foto.setImageResource(p.getFoto());
        holder.placa.setText(p.getPlaca());
        holder.marca.setText(p.getMarca());
        holder.modelo.setText(p.getModelo());
        holder.color.setText(p.getColor());
        holder.precio.setText(p.getPrecio());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onAutomovilClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return automovil.size();
    }


    public static class AutomovilViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView foto;
        private TextView placa;
        private TextView marca;
        private TextView modelo;
        private TextView color;
        private TextView precio;
        private View v;

        public AutomovilViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            placa = v.findViewById(R.id.lblPlaca);
            marca = v.findViewById(R.id.lblMarca);
            modelo = v.findViewById(R.id.lblModelo);
            color = v.findViewById(R.id.lblColor);
            precio = v.findViewById(R.id.lblPrecio);

        }
    }


    public interface OnAutomovilClickListener{
        void onAutomovilClick(Automovil a);
    }
}
