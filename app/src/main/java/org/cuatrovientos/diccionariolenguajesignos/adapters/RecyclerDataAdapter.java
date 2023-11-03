package org.cuatrovientos.diccionariolenguajesignos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.cuatrovientos.diccionariolenguajesignos.R;
import org.cuatrovientos.diccionariolenguajesignos.model.Categoria;

import org.cuatrovientos.diccionariolenguajesignos.model.Categoria;
import org.cuatrovientos.proyectolenguajesignos.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.RecyclerDataHolder> {

    ArrayList<Categoria> listaCategorias;

    public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.RecyclerDataHolder> {
        private List<Categoria> list;
        private OnItemClickListener listener;
    public RecyclerDataAdapter(ArrayList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

        public RecyclerDataAdapter(RealmResults<Categoria> list, OnItemClickListener listener){
            this.list = list;
            this.listener = listener;
        }
        @NonNull
        @Override
        public RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items,parent,false);
            return new RecyclerDataHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerDataHolder holder, int position) {
            holder.assignData(list.get(position),listener);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public void filter(String string) {
            list.clear();
            if(string.isEmpty()){
                list.addAll(listCopia);
            } else{
                string = string.toLowerCase();
                for(Categoria item: listCopia){
                    if(item.getTitulo().toLowerCase().contains(string)){
                        list.add(item);
                    }
                }
            }
        }

        public class RecyclerDataHolder extends RecyclerView.ViewHolder {
            TextView  tw;
            ImageView img;
            public RecyclerDataHolder(@NonNull View itemView) {
                super(itemView);
                img = itemView.findViewById(R.id.imgPortada);
                tw = itemView.findViewById(R.id.txtTitle);
            }

            public void assignData(Imagenes objeto, OnItemClickListener listener) {

                tw.setText(objeto.getTitulo());
                tw.setBackgroundResource(objeto.getColorTexto());
                img.setImageResource(objeto.getImagen());
                img.setBackgroundResource(objeto.getColorImagen());
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onItemClick(objeto, getAdapterPosition());
                    }
                });
            }
        }

        public interface OnItemClickListener{
            void onItemClick(Imagenes objeto,int position);
        }
    }

