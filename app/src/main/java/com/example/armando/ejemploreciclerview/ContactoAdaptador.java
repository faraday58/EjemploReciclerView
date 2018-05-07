package com.example.armando.ejemploreciclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactoAdaptador extends  RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;

    public ContactoAdaptador(ArrayList<Contacto> contactos)
    {
        this.contactos= contactos;
    }

    //Infla el layout y lo relaciona directamente al ViewHolder para asignar a cada elemento
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(v);
    }
        //Asocia a cada elemento con cada view
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Correo:" + contacto.getEmail(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Cantidad de elementos contenidos en la lista
    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvTelefonoCV;
        private TextView tvNombreCV;


        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvTelefonoCV = (TextView)itemView.findViewById(R.id.txtvCardTelefono);
            tvNombreCV =(TextView)itemView.findViewById(R.id.txtvCardNombre);

        }
    }
}
