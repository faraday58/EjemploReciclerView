package com.example.armando.ejemploreciclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactosRCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaContactosRCV = findViewById(R.id.rcvContactos);
        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //listaContactosRCV.setLayoutManager(llm);
        GridLayoutManager glm = new GridLayoutManager(this,2);
        listaContactosRCV.setLayoutManager(glm);
        InicializarListaContactos();
        iniciarAdaptador();

    }

    public void iniciarAdaptador()
    {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        listaContactosRCV.setAdapter(adaptador);
    }

    public void InicializarListaContactos()
    {
        contactos = new ArrayList<>();

        contactos.add(new Contacto("Zorro Naranja","tel: 56 22 43 12 31","zorro@zo.com",R.drawable.zorro));
        contactos.add(new Contacto("Musica Caribe ","tel: 56 22 43 32 14","musica@mus.com",R.drawable.servicio));
        contactos.add(new Contacto("Scarlett Johanson","tel: 56 22 43 12 31","zorro@zo.com",R.drawable.scarlett));


    }
}

