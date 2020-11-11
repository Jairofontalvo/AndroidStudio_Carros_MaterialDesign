package com.example.autosmaterial;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<Automovil> automovil = new ArrayList();

    public static void guardar(Automovil p){
        automovil.add(p);
    }

    public static ArrayList<Automovil> obtener(){
        return automovil;
    }
}
